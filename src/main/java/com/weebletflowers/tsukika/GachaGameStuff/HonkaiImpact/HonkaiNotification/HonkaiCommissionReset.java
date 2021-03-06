package com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiNotification;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class HonkaiCommissionReset
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel = guildID.getTextChannelsByName("honkaiimpact-alert", true).get(0);
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/HonkaiImpact/Himeko.png?raw=true";
        Color himekoCol = new Color(224, 61, 36);

        EmbedBuilder message = new EmbedBuilder();
        message.setColor(himekoCol);
        message.setTitle("Commission Reset");
        message.setAuthor("Himeko", null, iconURL);
        message.setDescription("Daily Commission have been reset");

        //1AM UTC
        Notification
                notification = new Notification(guildID, textChannel, 1, message);
        notification.run();
    }
}
