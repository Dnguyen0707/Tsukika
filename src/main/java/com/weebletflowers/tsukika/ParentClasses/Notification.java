package com.weebletflowers.tsukika.ParentClasses;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Timer;
import java.util.TimerTask;
public class Notification
{
    protected Guild guild;
    private TextChannel textChannel;
    private EmbedBuilder message;

    //time
    private int hour;
    private int minute;

    //with minute
    public Notification(Guild guild, TextChannel textChannel, int hour, int minute, EmbedBuilder message)
    {
        //set variable
        this.guild = guild;
        this.hour = hour;
        this.minute = minute;
        this.textChannel = textChannel;
        this.message = message;
    }

    //only hour, preset minute
    public Notification(Guild guild, TextChannel textChannel, int hour, EmbedBuilder message)
    {
        //set variable
        this.guild = guild;
        this.hour = hour;
        this.minute = 0;
        this.textChannel = textChannel;
        this.message = message;
    }

    // run notification
    public void run()
    {
        //set timer
        Timer timer = new Timer();
        TimerTask notification = new TimerTask()
        {
            @Override
            public void run()
            {
                notification();
            }
        };
        //run every second for the time
        timer.scheduleAtFixedRate(notification, 0, 1000); //1 sec
    }

    private void notification()
    {
        if (Time.timeCheck(hour, minute))
        {
            textChannel.sendMessage(message.build()).complete();
        }
    }

}
