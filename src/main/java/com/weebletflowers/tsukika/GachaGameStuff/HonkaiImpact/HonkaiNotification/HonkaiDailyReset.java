package com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiNotification;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class HonkaiDailyReset
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel = guildID.getTextChannelsByName("honkaiimpact-alert", true).get(0);
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/HonkaiImpact/Seele.png?raw=true";
        Color seeleCol = new Color(115, 59, 227);

        //NA 9:00 UTC
        EmbedBuilder message1 = new EmbedBuilder();
        message1.setColor(seeleCol);
        message1.setTitle("Daily Reset for NA");
        message1.setAuthor("Seele", null, iconURL);
        message1.setDescription("Always felt like there was a voice in my mind, telling me daily reset happened");

        Notification
                notificationNA = new Notification(guildID, textChannel, 9, message1);
        notificationNA.run();

        //Asia 20:00 UTC
        EmbedBuilder message2 = new EmbedBuilder();
        message2.setColor(seeleCol);
        message2.setTitle("Daily Reset for Asia");
        message2.setAuthor("Seele", null, iconURL);
        message2.setDescription("Always felt like there was a voice in my mind, telling me daily reset happened");

        Notification
                notificationAsia = new Notification(guildID, textChannel, 20, message2);
        notificationAsia.run();

        //EU 3:00 UTC
        EmbedBuilder message3 = new EmbedBuilder();
        message3.setColor(seeleCol);
        message3.setTitle("Daily Reset for EU");
        message3.setAuthor("Seele", null, iconURL);
        message3.setDescription("Always felt like there was a voice in my mind, telling me daily reset happened");

        Notification
                notificationEU = new Notification(guildID, textChannel, 3, message3);
        notificationEU.run();
    }
}
