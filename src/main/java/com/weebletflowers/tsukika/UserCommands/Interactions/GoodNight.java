package com.weebletflowers.tsukika.UserCommands.Interactions;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;

import java.util.Random;
public class GoodNight extends Command
{
    public GoodNight()
    {
        this.name = "goodnight";
        this.aliases = new String[]{"night", "oyasumi"};
        this.requiredRole = "Weeb";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        Member user = event.getGuild().getMember(event.getAuthor());

        //TODO change so it fit character
        String[] night = {
                "Good night to you, [member]",
                "Hope you have a great sleep [member]",
                "I ain't letting you sleep tonight [member] :)",
                "Sleep tight [member]",
                "I don't need your good night, b-baka [member]",
                "Try not to lewd me at night [member]"
        };

        //RNG
        Random rand = new Random();
        int number = rand.nextInt(night.length);

        //send message
        event.reply(night[number].replace("[member]", user.getAsMention()));
    }

}
