package com.weebletflowers.tsukika.NewMember;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class Join extends Command
{
    public Join()
    {
        this.name = "yahallo";
        this.help = "Accepting the rules";
        this.arguments = "<game>";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getChannel().getName().equalsIgnoreCase("new-members"))
        {
            long user = event.getAuthor().getIdLong();
            event.getMessage().delete().complete();

            //Add Seedlet
            List<Role> found = FinderUtil.findRoles("Member", event.getGuild());
            Role role = found.get(0);
            event.getGuild().addRoleToMember(user, role).complete();

            //from Honkai Impact
            if(event.getArgs().equalsIgnoreCase("HonkaiImpact"))
            {
                event.reply(event.getAuthor().getAsMention() + " came from Honkai Impact!");
            }
            //from Azur Lane
            else if(event.getArgs().equalsIgnoreCase("AzurLane"))
            {
                event.reply(event.getAuthor().getAsMention() + " came from Azur Lane!");
            }
            //not from any game or they fucked up
            else
            {
                event.reply("Welcome to the Weeblet Hanabusa " + event.getAuthor().getAsMention() + "!");
            }
        }
        else
        {
            event.getMessage().delete().complete();
        }
    }
}
