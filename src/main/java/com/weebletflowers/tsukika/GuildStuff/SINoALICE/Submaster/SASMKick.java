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

public class SASMKick extends Command
{
    public SASMKick()
    {
        this.name = "SASMKick";
        this.arguments = "<Member>";
        this.requiredRole = "Sinoalice Submaster";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getArgs().isEmpty())
        {
            event.reply("Who do you want to remove tag from?");
        }
        else
        {
            try
            {
                Member member = event.getMessage().getMentionedMembers().get(0);

                List<Role> found = FinderUtil.findRoles("Sinoalice Member", event.getGuild());
                Role role = found.get(0);

                String[] arg = event.getArgs().split("\\s+");
                int reason = 0;

                //check for arguments
                if (arg.length == 1)
                {
                    event.reply("Please state what's the reason for expel");
                }
                else
                {
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("Expel notice from SINoALICE guild");
                    embed.setColor(Color.red);

                    try
                    {
                        reason = Integer.parseInt(arg[1]);
                    }
                    catch (Exception e)
                    {
                        event.reply("Invalid reason");
                        return;
                    }

                    switch (reason)
                    {
                        case 1:
                            embed.setDescription("Offline for more than 3 days");
                            break;
                        case 2:
                            embed.setDescription("Constantly not joining colosseum");
                            break;
                        case 3:
                            embed.setDescription("See no improvement");
                            break;

                    }

                    embed.setFooter("Message Guildmaster or Submaster for more info");

                    //send to that person DM
                    sendMessage(event.getMessage().getMentionedUsers().get(0), embed.build());

                    //let gm/sm know
                    event.getGuild().removeRoleFromMember(member, role).complete();
                    event.getMessage().delete().queue();
                    event.reply("I have strip the role from " + member.getAsMention());
                }
            }
            catch (Exception e)
            {
                event.reply("Command no work");
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