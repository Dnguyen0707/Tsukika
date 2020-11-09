package com.weebletflowers.tsukika;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Launcher extends ListenerAdapter
{
    private static JDA jda;
    private static CommandClientBuilder builder;

    public static void main(String[] args) throws Exception
    {
        //readToken
        File tokenFile = new File("Tsukika Token.txt");
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

        //connect
        jda = new JDABuilder(AccountType.BOT).setToken(token).build();

        //setting builder
        builder = new CommandClientBuilder();
        builder.setOwnerId(ownerID);
        builder.setPrefix(">");
        builder.setHelpWord("sendhelp");
        commmands();
    }

    private static void commmands()
    {
        //Guild Package


        //AdminCommands Package


        //GuildmasterCommands Package


        //UserCommmands Package
//        builder.addCommand(new SelfRole());

    }


    //TODO: Change this
    private static void Presence()
    {
        String[] playing = {
                "Nier: Automata",
                "Azur Lane",
                "SINoAlice",
                "Monster Hunter World: Iceborne",
                "Halo: MCC",
                "Minecraft",
                "Code Vein",
                "Azur Lane Crosswave",
                "Soul Worker"
        };

        String[] watching = {
                "Oregairu",
                "The Monogatari Series",
                "Aobuta",
                "Clannad",
                "Konosuba",
                "Violet Evergarden",
                "Steins;Gate",
                "Katanagatari",
                "Mahoutsukai no Yome"
        };

        String[] listening = {
                "Harumodoki - Yanagi Nagi",
                "Megumi no Ame - Yanagi Nagi",
                "Over and Over - Yanagi Nagi",
                "Before My Body Is Dry - Mika Kobayashi feat. David Whitaker",
                "Nier OST: Kaine ~ Salvation",
                "Nier OST: Song of the Ancients / Devola",
                "Nier OST: Song of the Ancients / Popola",
                "Weight of the World - Keiichi Okabe",
                "Shiori - Claris",
                "Kimi no Sei - The Peggies",
                "Koi no Uta - Yunomi feat. Tsukasa Tsukuyomi"
        };

        //Initialing Random integer
        Random rand = new Random();
        int num = rand.nextInt(3);

        switch(num)
        {
            case 0:
                int play = rand.nextInt(playing.length);
                jda.getPresence().setActivity(Activity.playing(playing[play]));
                break;
            case 1:
                int watch = rand.nextInt(watching.length);
                jda.getPresence().setActivity(Activity.watching(watching[watch]));
                break;
            default:
                int listen = rand.nextInt(listening.length);
                jda.getPresence().setActivity(Activity.listening(listening[listen]));
        }

        //Playing
        if (num == 0)
        {
            int play = rand.nextInt(playing.length);
            jda.getPresence().setActivity(Activity.playing(playing[play]));
        }
        //Watching
        else if (num == 1)
        {
            int watch = rand.nextInt(watching.length);
            jda.getPresence().setActivity(Activity.watching(watching[watch]));
        }
        //listening
        else
        {
            int listen = rand.nextInt(listening.length);
            jda.getPresence().setActivity(Activity.listening(listening[listen]));
        }
    }
}
