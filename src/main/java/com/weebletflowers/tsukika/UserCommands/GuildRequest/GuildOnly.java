package com.weebletflowers.tsukika.UserCommands.GuildRequest;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;
public class GuildOnly extends Command
{
    public GuildOnly()
    {
        this.name = "GuildOnly";
        this.help = "to show only guild chat, only do this if you're in the guild";

    }

    @Override
    protected void execute(CommandEvent event)
    {
        event.getMessage().delete().complete();

        List<Role> count = event.getMember().getRoles();
        List<Role> role = event.getGuild().getRolesByName("weeb", true);
        Member author = event.getGuild().getMember(event.getAuthor());

        if (count.size() == 1)
        {
            event.reply("You only have one role");
        }
        else
        {
            event.getGuild().removeRoleFromMember(author, role.get(0)).complete();
            event.reply("You now can only see the guild chat");
        }
    }
}
