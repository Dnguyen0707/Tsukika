package com.weebletflowers.tsukika;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.weebletflowers.tsukika.GuildStuff.SINoALICE.Masters.SAJoin;
import com.weebletflowers.tsukika.GuildStuff.SINoALICE.Masters.SAKick;
import com.weebletflowers.tsukika.GuildStuff.SINoALICE.Members.AFKReport;
import com.weebletflowers.tsukika.GuildStuff.SINoALICE.Members.ColosseumAlert;
import com.weebletflowers.tsukika.GuildStuff.SINoALICE.Members.CoopInvite;
import com.weebletflowers.tsukika.NewMember.Join;
import com.weebletflowers.tsukika.JasioneCommands.Mute;
import com.weebletflowers.tsukika.UserCommands.GuildRequest.GuildApply;
import com.weebletflowers.tsukika.UserCommands.GuildRequest.GuildOnly;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Launcher extends ListenerAdapter
{
    private static CommandClientBuilder builder;
    private static EventWaiter waiter;

    public static void main(String[] args) throws LoginException
    {
        //readToken
        File tokenFile = new File("Tsukika Key.txt");
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
            System.exit(- 1);
        }

        //create jda
        JDA jda = JDABuilder.createDefault(token).build();

        // define an eventwaiter
        waiter = new EventWaiter();

        //setting builder
        builder = new CommandClientBuilder();
        builder.setHelpWord("sendhelp");
        builder.setOwnerId(ownerID);
        builder.setPrefix("-");
        builder.setAlternativePrefix("/");

        //add commmands
        commands();

        //connect
        CommandClient client = builder.build();
        jda.addEventListener(client);
        jda.addEventListener(waiter);
    }

    private static void commands()
    {
        //New Member
        builder.addCommands(new Join());

        //User Command
        builder.addCommands(
                new GuildOnly(),
                new GuildApply(waiter)
        );

        //Sinoalice
        builder.addCommands(
                new SAJoin(),
                new SAKick(),
                new AFKReport(),
                new CoopInvite(),
                new ColosseumAlert()
        );

        //Azur Lane
        builder.addCommands(

        );

        //Jasione Commands
        builder.addCommands(
                new Mute()
        );
    }

}
