package com.weebletflowers.tsukika.ParentClasses;
import com.weebletflowers.tsukika.GachaGameStuff.AzurLane.AzurLaneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.GenshinImpact.GenshinDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiNotification.HonkaiCommissionReset;
import com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.HonkaiNotification.HonkaiDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneBonusShop;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneDailyReset;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneFreeStamina;
import com.weebletflowers.tsukika.GachaGameStuff.Priconne.PriconneNormalGacha;
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

        //Honkai
        HonkaiDailyReset.run(guild);
        HonkaiCommissionReset.run(guild);
    }
}
