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
        Color kyaruCol = new Color(152, 38, 181);

        EmbedBuilder message = new EmbedBuilder();
        message.setColor(kyaruCol);
        message.setTitle("Bonus Shop reset");
        message.setAuthor("Kyaru", null, iconURL);
        message.setDescription("I wanna buy more personal item!");


        Notification notification = new Notification(guildID, textChannel, 12,59, message);
        notification.run();
    }
}
