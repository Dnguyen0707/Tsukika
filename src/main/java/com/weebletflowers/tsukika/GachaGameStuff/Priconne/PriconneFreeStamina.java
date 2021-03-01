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
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/Priconne/Kokkoro_Normal.png?raw=true";

        //2 AM
        EmbedBuilder firstmessage = new EmbedBuilder();
        firstmessage.setColor(Color.green);
        firstmessage.setTitle("First Free Stamina");
        firstmessage.setAuthor("Kokkoro", null, iconURL);
        firstmessage.setDescription("My lord, let's go explore");

        Notification
                firstNotification =
                new Notification(guildID, textChannel, 2, firstmessage);
        firstNotification.run();

        //8pm (20:00)
        EmbedBuilder secondmessage = new EmbedBuilder();
        secondmessage.setColor(Color.green);
        secondmessage.setTitle("Second Free Stamina");
        secondmessage.setAuthor("Kokkoro", null, iconURL);
        secondmessage.setDescription("My lord, I'm looking forward to assisting you");

        Notification
                secondNotification =
                new Notification(guildID, textChannel, 20, secondmessage);
        secondNotification.run();
    }
}
