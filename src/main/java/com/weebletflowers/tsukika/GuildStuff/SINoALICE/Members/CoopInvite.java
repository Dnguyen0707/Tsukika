package com.weebletflowers.tsukika.GuildStuff.SINoALICE.Members;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;


public class CoopInvite extends Command
{
    public CoopInvite()
    {
        this.name = "Coop";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getChannel().getName().equalsIgnoreCase("guild-chat"))
        {
            //delete typed commanded
            event.getMessage().delete().complete();

            Role role =
                    event.getGuild().getRolesByName("Sinoalice Member", true)
                            .get(0);

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Co-op Notice");
            embed.setColor(Color.ORANGE);
            embed.setDescription(
                    role.getAsMention() + " | " +
                            event.getAuthor().getName() +
                            " going to run some co-op");

            event.reply(embed.build());
        }
        else
        {
            //delete typed commanded
            event.getMessage().delete().complete();
        }

    }

}
