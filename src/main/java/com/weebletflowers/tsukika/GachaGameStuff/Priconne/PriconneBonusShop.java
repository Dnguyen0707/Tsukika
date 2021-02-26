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
        String iconURL = "https://raw.githubusercontent.com/Dnguyen0707/Tsukika/master/src/main/resources/GachaNotificationIcon/Priconne/Karin.png";

        EmbedBuilder message = new EmbedBuilder();
        message.setColor(Color.green);
        message.setTitle("Bonus Shop reset");
        message.setAuthor("Karin", null, iconURL);
        message.setDescription("Bonus shop have been reset, go on an adventure and it should be ready");


        Notification notification = new Notification(guildID, textChannel, 12,59, message);
        notification.run();
    }
}
