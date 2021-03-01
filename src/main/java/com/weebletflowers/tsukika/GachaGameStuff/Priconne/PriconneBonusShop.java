package com.weebletflowers.tsukika.GachaGameStuff.Priconne;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class PriconneBonusShop
{
    public static void run(Guild guildID)
    {
        TextChannel textChannel = guildID.getTextChannelsByName("priconne-alert", true).get(0);
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/Priconne/Kyaru_Normal.png?raw=true";

        EmbedBuilder message = new EmbedBuilder();
        message.setColor(Color.getHSBColor(287,76,73));
        message.setTitle("Bonus Shop reset");
        message.setAuthor("Kyaru", null, iconURL);
        message.setDescription("I");


        Notification notification = new Notification(guildID, textChannel, 12,59, message);
        notification.run();
    }
}
