package com.weebletflowers.tsukika.UserCommands.Interactions;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;

import java.util.Random;
public class GoodMorning extends Command
{
    public GoodMorning()
    {
        this.name = "goodmorning";
        this.aliases = new String[]{"morning", "ohayou"};
        this.requiredRole = "Weeb";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        Member user = event.getGuild().getMember(event.getAuthor());

        //TODO change so it fit character
        String[] morning = {
                "Good morning to you, [member]",
                "Hope you have a great day [member]",
                "Have you eaten breakfast yet [member]?",
                "I had a great time last night [member] :)",
                "G-good morning, b-baka [member]",
                "So you're alive [member]"
        };

        //RNG
        Random rand = new Random();
        int number = rand.nextInt(morning.length);

        //send message
        event.reply(morning[number].replace("[member]", user.getAsMention()));
    }

}
