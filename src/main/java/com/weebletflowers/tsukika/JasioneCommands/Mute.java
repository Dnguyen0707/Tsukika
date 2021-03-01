package com.weebletflowers.tsukika.JasioneCommands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.util.List;
public class Mute extends Command
{
    public Mute()
    {
        this.name = "Mute";
        this.arguments = "<Member>";
        this.requiredRole = "Jasione";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getArgs().isEmpty())
        {
            event.reply("Who do you want to give tag?");
        }
        else
        {
            Member member = event.getMessage().getMentionedMembers().get(0);
            List<Role> found = FinderUtil.findRoles("Bug", event.getGuild());
            Role mute = found.get(0);

            event.getGuild().addRoleToMember(member, mute).complete();
            event.getMessage().delete().complete();

            //build embed
            EmbedBuilder message = new EmbedBuilder();
            message.setTitle("You got muted");
            message.setColor(Color.blue);
            message.setDescription(
                    "You have broken a rule and now are muted for a week, don't worry, you can still check out the server but are not able to talk in it"
            );
            message.setFooter(
                    "Don't hesitate to contact the Jasione if you have concern/questions");

            sendMessage(event.getMessage().getMentionedUsers().get(0),
                    message.build());
        }
    }

    private void sendMessage(User user, MessageEmbed content)
    {
        user.openPrivateChannel()
                .flatMap(channel -> channel.sendMessage(content))
                .queue();
    }

}
