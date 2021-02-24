package com.weebletflowers.tsukika.GachaGameStuff;
import com.weebletflowers.tsukika.GachaGameStuff.AzurLane.AzurLaneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.GenshinImpact.GenshinDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneNormalGacha;
import com.weebletflowers.tsukika.GachaGameStuff.SINoALICE.SinoaliceDailyReset;
import net.dv8tion.jda.api.entities.Guild;
public class NotificationRunner
{
    //run all of the notification here
    public NotificationRunner(Guild guild)
    {
        //Princonne
        PriconneDailyReset.run(guild);
        PriconneNormalGacha.run(guild);

        //Azur Lane
        AzurLaneDailyReset.run(guild);

        //GenshinImpact
        //GenshinDailyReset.run(guild);

        //SinoAlice
        SinoaliceDailyReset.run(guild);

        //Honkai
        //HonkaiDailyReset.run(guild);
    }
}
