package com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.Subleader;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;
public class HonkaiGiveTag extends Command
{
    public HonkaiGiveTag()
    {
        this.name = "HonkaiGiveTag";
        this.arguments = "member";
        this.requiredRole = "Honkai Impact Vice Leader";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        event.getMessage().delete().complete();
        if (event.getArgs().isEmpty())
        {
            event.reply("Please include a member");
        }
        else
        {
            Member member = event.getMessage().getMentionedMembers().get(0);
            List<Role> found = FinderUtil.findRoles("Honkai Impact Member", event.getGuild());
            Role role = found.get(0);

            event.getGuild().addRoleToMember(member, role).complete();
            event.reply("Given " + member.getAsMention() + " the tag! Welcome to the guild");
        }
    }
}
