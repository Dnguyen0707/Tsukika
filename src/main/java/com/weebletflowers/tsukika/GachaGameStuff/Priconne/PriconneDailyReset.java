package com.weebletflowers.tsukika.GachaGameStuff.Priconne;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class PriconneDailyReset
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel =
                guildID.getTextChannelsByName("priconne-alert", true).get(0);
        String iconURL =
                "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/Priconne/Normal_Pecorine.png?raw=true";
        Color pecorineCol = new Color(255, 150, 38);

        EmbedBuilder message = new EmbedBuilder();
        message.setColor(pecorineCol);
        message.setTitle("Daily Reset");
        message.setAuthor("Pecorine", null, iconURL);
        message.setDescription("Daily have been reset. How crazy is that!?");

        //1pm
        Notification notification =
                new Notification(guildID, textChannel, 13, message);
        notification.run();
    }

}
