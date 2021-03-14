package com.weebletflowers.tsukika.GachaGameStuff.SINoALICE;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class SinoaliceDailyReset
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel = guildID.getTextChannelsByName("sinoalice-alert", true).get(0);
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/SINoALICE/Snow_White.png?raw=true";
        Color snowCol = new Color(255, 245, 245);

        EmbedBuilder message = new EmbedBuilder();
        message.setColor(snowCol);
        message.setTitle("Daily Reset");
        message.setAuthor("Snow White", null, iconURL);
        message.setDescription("Everything have been reset, but not justice");

        //5AM
        Notification
                notification = new Notification(guildID, textChannel, 5, message);
        notification.run();
    }
}
