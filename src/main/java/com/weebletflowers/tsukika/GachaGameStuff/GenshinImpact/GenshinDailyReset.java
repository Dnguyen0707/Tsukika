package com.weebletflowers.tsukika.GachaGameStuff.GenshinImpact;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class GenshinDailyReset
{
    public static void run(Guild guildID)   //TODO double check
    {
        TextChannel textChannel = guildID.getTextChannelsByName("genshinimpact-alert", true).get(0);
        String iconURL = "";

        //NA 10:00 UTC
        EmbedBuilder message1 = new EmbedBuilder();
        message1.setColor(Color.blue);
        message1.setTitle("Daily Reset for NA");
        message1.setAuthor("Ganyu", null, iconURL);
        message1.setDescription("");

        Notification
                notificationNA = new Notification(guildID, textChannel, 10, message1);
        notificationNA.run();

        //Asia 20:00 UTC
        EmbedBuilder message2 = new EmbedBuilder();
        message2.setColor(Color.blue);
        message2.setTitle("Daily Reset for Asia");
        message2.setAuthor("Ganyu", null, iconURL);
        message2.setDescription("");

        Notification
                notificationAsia = new Notification(guildID, textChannel, 20, message2);
        notificationAsia.run();

        //EU 3:00 UTC
        EmbedBuilder message3 = new EmbedBuilder();
        message3.setColor(Color.blue);
        message3.setTitle("Daily Reset for EU");
        message3.setAuthor("Ganyu", null, iconURL);
        message3.setDescription("");

        Notification
                notificationEU = new Notification(guildID, textChannel, 3, message3);
        notificationEU.run();
    }
}
