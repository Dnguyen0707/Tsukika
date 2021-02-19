package com.weebletflowers.tsukika.GachaGameStuff.Priconne;

import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class PrinconneNormalGacha
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel =
                guildID.getTextChannelsByName("priconne-alert", true).get(0);


        //1pm
        EmbedBuilder firstmessage = new EmbedBuilder();
        firstmessage.setColor(Color.green);
        firstmessage.setTitle("First Normal Gacha");
        firstmessage.setAuthor("Karin", null, "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/Priconne/Karin.png");
        firstmessage.setDescription("Your first daily gear is now available, let me help you carry it into the guild house");

        Notification
                firstNotifaction =
                new Notification(guildID, textChannel, 13, firstmessage);
        firstNotifaction.run();

        //8pm
        EmbedBuilder secondmessage = new EmbedBuilder();
        secondmessage.setColor(Color.green);
        secondmessage.setTitle("Second Normal Gacha");
        secondmessage.setAuthor("Karin", null, "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/Priconne/Karin.png");
        secondmessage.setDescription("Your second daily gear is now available, let me help you carry it into the guild house");

        Notification
                secondNotifaction =
                new Notification(guildID, textChannel, 20, secondmessage);
        secondNotifaction.run();
    }

}
