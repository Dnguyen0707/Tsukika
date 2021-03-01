package com.weebletflowers.tsukika.GachaGameStuff.AzurLane;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class AzurLaneDailyReset
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel =
                guildID.getTextChannelsByName("azurlane-alert", true).get(0);
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/AzurLane/Bismarck.png?raw=true";

        //7AM UTC
        EmbedBuilder message = new EmbedBuilder();
        message.setColor(Color.getHSBColor(0, 100,47));
        message.setTitle("Daily Reset");
        message.setAuthor("Bismarck", null, iconURL);
        message.setDescription("Everything have been reset. I have expectations of you as well.");

        Notification
                notification =
                new Notification(guildID, textChannel, 7, message);
        notification.run();
    }
}
