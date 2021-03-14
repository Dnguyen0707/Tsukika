package com.weebletflowers.tsukika.GachaGameStuff.Priconne;

import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class PriconneNormalGacha
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel =
                guildID.getTextChannelsByName("priconne-alert", true).get(0);
        String iconURL = "https://raw.githubusercontent.com/Dnguyen0707/Tsukika/master/src/main/resources/GachaNotificationIcon/Priconne/Karin.png";
        Color karinCol = new Color(16, 171, 14);

        //1pm
        EmbedBuilder firstmessage = new EmbedBuilder();
        firstmessage.setColor(karinCol);
        firstmessage.setTitle("First Normal Gacha");
        firstmessage.setAuthor("Karin", null, iconURL);
        firstmessage.setDescription("Your first daily gear is now available, let me help you carry it into the guild house");

        Notification
                firstNotification =
                new Notification(guildID, textChannel, 13, firstmessage);
        firstNotification.run();

        //8pm
        EmbedBuilder secondmessage = new EmbedBuilder();
        secondmessage.setColor(karinCol);
        secondmessage.setTitle("Second Normal Gacha");
        secondmessage.setAuthor("Karin", null, iconURL);
        secondmessage.setDescription("Your second daily gear is now available, let me help you carry it into the guild house");

        Notification
                secondNotification =
                new Notification(guildID, textChannel, 20, secondmessage);
        secondNotification.run();
    }

}
