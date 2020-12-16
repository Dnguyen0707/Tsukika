package com.weebletflowers.tsukika.GuildStuff.SINoALICE.Members;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class AFKReport extends Command
{
    public AFKReport()
    {
        this.name = "AFK";
        this.hidden = true;
    }


    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getChannel().getName().equalsIgnoreCase("guild-chat"))
        {
            //delete typed command
            event.getMessage().delete().complete();

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("AFK Notice");
            embed.setDescription(event.getAuthor().getName() +
                    " will be gone for today's collo");
            embed.setColor(Color.cyan);

            event.reply(embed.build());
        }
        else
        {
            //delete typed commanded
            event.getMessage().delete().complete();
        }


    }

}
