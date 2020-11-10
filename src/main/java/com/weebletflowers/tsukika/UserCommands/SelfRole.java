package com.weebletflowers.tsukika.UserCommands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class SelfRole extends Command
{
    public SelfRole()
    {
        this.name = "role";
        this.aliases = new String[]{"getrole"};
        this.help = "give yourself a role";
        this.arguments = "<role>";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        Role role = null;
        Member user = event.getGuild().getMember(event.getAuthor());

        event.getMessage().delete().queue();

        if (event.getArgs().isEmpty())
        {
            event.replyError("Bruh, there is the role you want?");
            return;
        }
        else
        {
            List<Role> found = FinderUtil.findRoles(event.getArgs(), event.getGuild());
            if (found.isEmpty())
            {
                event.replyError("I don't see the role");
            }
            else
            {
                role = found.get(0);
            }
        }
        event.getGuild().addRoleToMember(user, role).complete();
        event.getChannel().sendMessage("Got Chu");
    }


}
