package com.weebletflowers.tsukika.GachaGameStuff.GenshinImpact;
import com.weebletflowers.tsukika.ParentClasses.Notification;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
public class GenshinDailyReset
{
    public static void run(Guild guildID)   //TODO change quote
    {
        TextChannel textChannel = guildID.getTextChannelsByName("genshinimpact-alert", true).get(0);
        String iconURL = "https://github.com/Dnguyen0707/Tsukika/blob/master/src/main/resources/GachaNotificationIcon/GenshinImpact/Ganyu.png?raw=true";
        Color ganyuCol = new Color(68, 177, 227);

        //NA 10:00 UTC   TODO: Daytime saving so it's 9
        EmbedBuilder message1 = new EmbedBuilder();
        message1.setColor(ganyuCol);
        message1.setTitle("Daily Reset for NA");
        message1.setAuthor("Ganyu", null, iconURL);
        message1.setDescription("I finished all my dailies today. ...M-More? I understand. I'll get right on the case");

        Notification
                notificationNA = new Notification(guildID, textChannel, 9, message1);
        notificationNA.run();

        //Asia 20:00 UTC
        EmbedBuilder message2 = new EmbedBuilder();

        message2.setColor(ganyuCol);
        message2.setTitle("Daily Reset for Asia");
        message2.setAuthor("Ganyu", null, iconURL);
        message2.setDescription("I finished all my dailies today. ...M-More? I understand. I'll get right on the case");

        Notification
                notificationAsia = new Notification(guildID, textChannel, 20, message2);
        notificationAsia.run();

        //EU 3:00 UTC
        EmbedBuilder message3 = new EmbedBuilder();
        message3.setColor(ganyuCol);
        message3.setTitle("Daily Reset for EU");
        message3.setAuthor("Ganyu", null, iconURL);
        message3.setDescription("I finished all my dailies today. ...M-More? I understand. I'll get right on the case");

        Notification
                notificationEU = new Notification(guildID, textChannel, 3, message3);
        notificationEU.run();
    }
}
