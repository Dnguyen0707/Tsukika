package com.weebletflowers.tsukika.GuildStuff.SINoALICE.Grandmaster;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class SAGMkick extends Command
{
    public SAGMkick()
    {
        this.name = "SALeave";
        this.arguments = "<Member>";
        this.requiredRole = "Sinoalice Grandmaster";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {

    }

}
