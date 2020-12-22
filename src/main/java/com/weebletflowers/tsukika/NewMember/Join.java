package com.weebletflowers.tsukika.NewMember;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;
import java.util.Random;

public class Join extends Command
{
    public Join()
    {
        this.name = "yahallo";
        this.help = "Accepting the rules";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        Member user = event.getGuild().getMember(event.getAuthor());

        List<Role> found = FinderUtil.findRoles("Weeblet Seedlet", event.getGuild());
        Role role = found.get(0);
        //SHOULD NEVER HAPPENED LMAO
        if (found.isEmpty())
        {
            event.replyError("I don't see the role. Type something legit");
        }
        else
        {
            role = found.get(0);
        }

        event.getMessage().delete().complete();


        event.getGuild().addRoleToMember(user, role).complete();
        String rawMessage = joinMessage();

        event.reply(rawMessage.replace("[member]", user.getAsMention()));

    }

    //TODO change this so it fit character
    private String joinMessage()
    {
        String[] messages = {
                "[member] joined, go and compliment their hair",
                "Yahallo [member]! Welcome to the Weeblet",
                "It's not like we need you here [member], b-baka!",
                "You think it was a bot, but it was me, [member]",
                "My current being is due to [member]'s presence",
                "To suffer at the hands of [member] is my ideal",
                "[member] joined the fleet, get ready for sorties",
                "[member] is the new operator that join us today",
                "[member] is the new valkyries, time to fight!"
        };

        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        return messages[number];
    }
}
