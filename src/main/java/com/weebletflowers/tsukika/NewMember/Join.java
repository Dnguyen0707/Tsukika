package com.weebletflowers.tsukika.NewMember;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.entities.Role;

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

            //if user is from the SinoAlice guild
            if (event.getArgs().equals("SinoAlice"))
            {

                List<Role> guildrole = FinderUtil.findRoles("SinoAlice Member", event.getGuild());
                Role SAMember = guildrole.get(0);
                event.getGuild().addRoleToMember(user, SAMember).complete();

                event.reply(event.getAuthor().getAsMention() + " is the new SinoAlice member that join us today");
            }
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
