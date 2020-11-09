package com.weebletflowers.tsukika;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Launcher extends ListenerAdapter
{

    private static CommandClientBuilder builder;
    public static void main(String[] args) throws Exception
    {
        File tokenFile = new File("Token.txt");
        String token = "";
        String ownerID = "";
        try
        {
            Scanner readToken = new Scanner(tokenFile);
            token = readToken.nextLine();
            ownerID = readToken.nextLine();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Don't see file");
            System.exit(-1);
        }

        //setup JDA
        JDA jda = new JDABuilder(AccountType.BOT).setToken(token).build();

        //setup bot
        builder = new CommandClientBuilder();
        builder.setPrefix(">");
        builder.setHelpWord("sendhelp");
        builder.setOwnerID(ownerID);
        commands();

        CommandClient client = builder.build();
        jda.addEventListener(client);




    }

    private void commands()
    {

    }
}
