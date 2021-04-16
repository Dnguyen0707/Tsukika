package com.weebletflowers.tsukika;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.Subleader.HonkaiGiveTag;
import com.weebletflowers.tsukika.ParentClasses.NotificationRunner;
import com.weebletflowers.tsukika.NewMember.Join;
import com.weebletflowers.tsukika.JasioneCommands.Mute;
import com.weebletflowers.tsukika.UserCommands.TurnOnAlert;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Launcher extends ListenerAdapter
{
    private static CommandClientBuilder builder;
    private static EventWaiter waiter;

    public static void main(String[] args)
            throws LoginException
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

        //jda awaitReady
        try
        {
            jda.awaitReady();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

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

        //Gacha rest notification
        Guild guild = jda.getGuildById("728455513532006491");   //Main

        new NotificationRunner(guild);

        jda.getPresence().setActivity(Activity.playing("1.2.0"));  //TODO remember to switch this with build.gradle
    }

    private static void commands()
    {
        //New Member
        builder.addCommands(
                new Join()
        );

        //User Command
        builder.addCommands(
                new TurnOnAlert()
        );

        //Gacha game stuff
        builder.addCommands(
                new HonkaiGiveTag()
        );

        //Jasione Commands
        builder.addCommands(
                new Mute()
        );
    }


}
