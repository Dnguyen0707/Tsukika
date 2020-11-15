package com.weebletflowers.tsukika.GuildStuff.SINoALICE.Submaster;
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
public class SASMJoin extends Command
{
    public SASMJoin()
    {
        this.name = "SASMJoin";
        this.arguments = "<Member>";
        this.requiredRole = "Sinoalice Submaster";
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
            try
            {
                Member member = event.getMessage().getMentionedMembers().get(0);
                List<Role> found =
                        FinderUtil.findRoles("Sinoalice Member", event.getGuild());
                Role role = found.get(0);

                event.getGuild().addRoleToMember(member, role).complete();

                event.getMessage().delete().queue();

                //build embed
                EmbedBuilder message = new EmbedBuilder();
                message.setTitle("Welcome to our SINoALice guild");
                message.setColor(Color.blue);
                message.setDescription(
                        "Now that you're in our guild, prepare for a fight everyday :)\n" +
                                "There are couple rules that you should follow since we're semi-competitive\n\n" +
                                "```\n" + "Rule\n" + "```\n" +
                                "1. Offline for more than 3 days will result to kick unless report to grandmaster or submaster\n" +
                                "2. Not joining colosseum for more than 3 days will result to kick unless report to grandmaster or submaster\n" +
                                "3. Constantly not joining colosseum will result to kick.\n \n" +
                                "We all like to have fun playing the guild war, but it won't be fun for anyone if you keep being afk without telling us\n" +
                                "If you forget the rule you can just check the guild-information channel"
                );
                message.setFooter(
                        "Don't hesitate to contact Guildmaster or Submaster if you have concern/questions");
                message.setImage("https://tinyurl.com/y5mf39cm");

                sendMessage(event.getMessage().getMentionedUsers().get(0), message.build());

            }
            catch (Exception e)
            {
                event.reply("Command not working");
            }
        }
    }

    private void sendMessage(User user, MessageEmbed content)
    {
        user.openPrivateChannel()
                .flatMap(channel -> channel.sendMessage(content))
                .queue();
    }
}
