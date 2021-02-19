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
            List<Role> found = FinderUtil.findRoles("Weeblet Seedlet", event.getGuild());
            Role role = found.get(0);
            event.getGuild().addRoleToMember(user, role).complete();

            //search for from-guild channel
            TextChannel fromguild = event.getGuild()
                    .getTextChannelsByName("from-guild", true).get(0);

            //if user is from certain game guild
            if (event.getArgs().equalsIgnoreCase("SinoAlice"))
            {
                //send message to from-guild channel
                fromguild.sendMessage(event.getAuthor().getAsMention() + " came from **SinoAlice**").complete();
            }
            //from Honkai Impact
            else if(event.getArgs().equalsIgnoreCase(" HonkaiImpact"))
            {
                //send message to from-guild channel
                fromguild.sendMessage(event.getAuthor().getAsMention() + " came from **Honkai Impact**").complete();
            }
            //from Azur Lane
            else if(event.getArgs().equalsIgnoreCase("AzurLane"))
            {
                //send message to from-guild channel
                fromguild.sendMessage(event.getAuthor().getAsMention() + " came from **Azur Lane**").complete();
            }

            event.reply("Welcome to the Weeblet Hanabusa " + event.getAuthor().getAsMention() + "!");
        }
        else
        {
            event.getMessage().delete().complete();
        }
    }
}
