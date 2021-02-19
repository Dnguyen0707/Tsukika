package com.weebletflowers.tsukika.GachaGameStuff;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PrinconneNormalGacha;
import com.weebletflowers.tsukika.GachaGameStuff.SINoALICE.SinoaliceDailyReset;
import net.dv8tion.jda.api.entities.Guild;
public class NotificationRunner
{
    //run all of the notification here
    public NotificationRunner(Guild guild)
    {
        //Princonne
        PriconneDailyReset.run(guild);
        PrinconneNormalGacha.run(guild);

        //Azur Lane


        //Genshin


        //SinoAlice
        SinoaliceDailyReset.run(guild);

        //Honkai
        //will need to read day for other day related notification
    }
}
