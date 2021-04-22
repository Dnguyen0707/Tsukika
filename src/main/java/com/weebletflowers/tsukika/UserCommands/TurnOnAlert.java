package com.weebletflowers.tsukika.UserCommands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;
import java.util.Locale;
public class TurnOnAlert extends Command
{
    public TurnOnAlert()
    {
        this.name = "TurnOnAlert";
        this.arguments = "game";
        this.requiredRole = "member";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getArgs().isEmpty())
        {
            event.reply("Please enter your choice");
        }
        else
        {
            long user = event.getAuthor().getIdLong();
            List<Role> found;
            Role role;
            String alert;
            String news;
            String leak;
            String code;

            switch (event.getArgs().toLowerCase())
            {
                case "azurlane":
                    found = FinderUtil.findRoles("Azur Lane Info Receiver", event.getGuild());
                    role = found.get(0);
                    event.getGuild().addRoleToMember(user, role).complete();
                    alert = "<#812440158565040148>";
                    news = "<#832697092925161532>";

                    event.reply("Role updated, please check " + alert + " and " + news + " for your good stuff");
                    break;
                case "honkaiimpact":
                    found = FinderUtil.findRoles("Honkai Info Receiver", event.getGuild());
                    role = found.get(0);
                    event.getGuild().addRoleToMember(user, role).complete();
                    alert = "<#813889351104331826>";
                    news = "<#831666201209733171>";
                    leak = "<#830332246380249098>";
                    code = "<#831666851058286602>";

                    event.reply("Role updated, please check " + alert + ", " + news + ", " + leak + " and " + code + " for your good stuff");
                    break;
                case "genshinimpact":
                    found = FinderUtil.findRoles("Genshin Info Receiver", event.getGuild());
                    role = found.get(0);
                    event.getGuild().addRoleToMember(user, role).complete();
                    alert = "<#813893833292382280>";
                    news = "<#832693786789544016>";
                    leak = "<#830332778322329620>";
                    code = "<#832695491212083210>";

                    event.reply("Role updated, please check " + alert + ", " + news + ", " + leak + " and " + code + " for your good stuff");
                    break;
                case "priconne":
                    found = FinderUtil.findRoles("Priconne Info Receiver", event.getGuild());
                    role = found.get(0);
                    event.getGuild().addRoleToMember(user, role).complete();
                    alert = "<#812439929254182934>";
                    news = "<#832697587047202837>";

                    event.reply("Role updated, please check " + alert + " and " + news + " for your good stuff");
                    break;
                default:
                    event.reply("I don't understand what you typed, please try again");
            }
        }
    }

}
