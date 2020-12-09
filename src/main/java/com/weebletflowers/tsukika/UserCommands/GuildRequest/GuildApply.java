package com.weebletflowers.tsukika.UserCommands.GuildRequest;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.concurrent.TimeUnit;
public class GuildApply extends Command
{
    private final EventWaiter waiter;
    public GuildApply(EventWaiter waiter)
    {
        this.waiter = waiter;
        this.name = "GuildApply";
        this.help = "Applying for the guild that you want";
        this.requiredRole = "weeb";
        this.arguments = "<game>";
    }


    @Override
    protected void execute(CommandEvent event)
    {
        event.getMessage().delete().complete();

        if (event.getArgs().isEmpty())
        {
            event.reply("Please type in the name of the guild");
        }
        else if (event.getArgs().equalsIgnoreCase("sinoalice"))
        {
            sinoalice(event);
        }
        else if (event.getArgs().equalsIgnoreCase("azurlane"))
        {
            azurlane(event);
            event.reply("Your request have been sent to AL guild");
            this.cooldown = 86400;
        }
        else
        {
            event.reply("I'm not sure what guild you want to join");
        }
    }

    private void sinoalice(CommandEvent event)
    {

        TextChannel guildchannel = event.getGuild()
                .getTextChannelsByName("sinoalice-application", true).get(0);

        //TODO making so it asked what is the user stats
        event.reply("Please fill in the following detail in one message, don't type the <>.\n" + "Role: <Vanguard, Sorc, Min, Healer>\n" + "Point: <Main set point>");

        waiter.waitForEvent(GuildMessageReceivedEvent.class,
                // make sure it's by the same user, and in the same channel
                e -> e.getAuthor().equals(event.getAuthor()) && e.getChannel().equals(event.getChannel()),
                // run
                e ->
                {
                    //build embed
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setDescription(e.getMessage().getContentRaw());
                    embed.setAuthor(e.getAuthor().getName() + " want to join the guild", "http://www.google.com", e.getAuthor().getAvatarUrl());
                    embed.setColor(Color.cyan);

                    //send message
                    guildchannel.sendMessage(e.getAuthor().getAsMention()).complete();
                    guildchannel.sendMessage(embed.build()).complete();
                    event.reply("Your request have been sent to SA guild");
                },
                1,TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long."));

    }

    private void azurlane(CommandEvent event)
    {
        TextChannel guildchannel = event.getGuild()
                .getTextChannelsByName("azurlane-application", true).get(0);

        guildchannel.sendMessage("application recieved").complete();
    }
}
