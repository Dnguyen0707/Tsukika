package com.weebletflowers.tsukika.GuildStuff.SINoALICE.Grandmaster;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class SAGMJoin extends Command
{
    public SAGMJoin()
    {
        this.name = "SAJoin";
        this.arguments = "<Member>";
        this.requiredRole = "Sinoalice Grandmaster";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {

    }

}