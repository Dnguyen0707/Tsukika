package com.weebletflowers.tsukika.GuildStuff.SINoALICE.Members;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Role;

import java.util.Random;

public class ColosseumAlert extends Command
{
    public ColosseumAlert()
    {
        this.name = "ColloTime";
        this.aliases = new String[]{"WarTime", "GuildBattle"};
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        if (event.getChannel().getName().equalsIgnoreCase("guild-chat"))
        {
            //delete typed commanded
            event.getMessage().delete().complete();

            Role role =
                    event.getGuild().getRolesByName("Sinoalice Member", true)
                            .get(0);

            String rawMessage = warMessage();

            event.reply(rawMessage.replace("[member]", role.getAsMention()));
        }
    }

    private String warMessage()
    {

        String[] messages = {
                "[member], get on and fight!",
                "*Starts banging the war drum*, [member] get on!!!",
                "We need you [member]! Get on!",
                "[member], let's beat the enemy team! Get on!"
        };

        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        return messages[number];
    }

}
