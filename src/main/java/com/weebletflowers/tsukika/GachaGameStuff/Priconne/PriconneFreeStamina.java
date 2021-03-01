package com.weebletflowers.tsukika.GachaGameStuff.Priconne;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class PriconneFreeStamina
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel =
                guildID.getTextChannelsByName("priconne-alert", true).get(0);
        String iconURL = "";

        //2 AM
        EmbedBuilder firstmessage = new EmbedBuilder();
        firstmessage.setColor(Color.green);
        firstmessage.setTitle("First Free Stamina");
        firstmessage.setAuthor("Karin", null, iconURL);
        firstmessage.setDescription("Your first free stamina is now available");

        Notification
                firstNotification =
                new Notification(guildID, textChannel, 2, firstmessage);
        firstNotification.run();

        //8pm (20:00)
        EmbedBuilder secondmessage = new EmbedBuilder();
        secondmessage.setColor(Color.green);
        secondmessage.setTitle("Second Free Stamina");
        secondmessage.setAuthor("Karin", null, iconURL);
        secondmessage.setDescription("Your second free stamina is now available");

        Notification
                secondNotification =
                new Notification(guildID, textChannel, 20, secondmessage);
        secondNotification.run();
    }
}
