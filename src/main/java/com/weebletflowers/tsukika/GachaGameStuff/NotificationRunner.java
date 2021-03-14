package com.weebletflowers.tsukika.GachaGameStuff;
import com.weebletflowers.tsukika.GachaGameStuff.AzurLane.AzurLaneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.GenshinImpact.GenshinDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiCommissionReset;
import com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneBonusShop;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneFreeStamina;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneNormalGacha;
import com.weebletflowers.tsukika.GachaGameStuff.SINoALICE.SinoaliceConquest;
import com.weebletflowers.tsukika.GachaGameStuff.SINoALICE.SinoaliceDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.SINoALICE.SinoaliceGuerrilla;
import net.dv8tion.jda.api.entities.Guild;
public class NotificationRunner
{
    //run all of the notification here
    public NotificationRunner(Guild guild)
    {
        //Princonne
        PriconneDailyReset.run(guild);  //NA EU Asia
        PriconneNormalGacha.run(guild);
        PriconneBonusShop.run(guild);
        PriconneFreeStamina.run(guild);

        //Azur Lane
        AzurLaneDailyReset.run(guild);

        //Genshin
        GenshinDailyReset.run(guild);  //NA EU Asia

        //SinoAlice
        SinoaliceDailyReset.run(guild);
        SinoaliceGuerrilla.run(guild);
        SinoaliceConquest.run(guild);

        //Honkai
        HonkaiDailyReset.run(guild);
        HonkaiCommissionReset.run(guild);
    }
}
