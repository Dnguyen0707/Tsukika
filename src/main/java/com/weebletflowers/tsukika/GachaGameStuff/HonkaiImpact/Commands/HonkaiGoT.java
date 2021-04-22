package com.weebletflowers.tsukika.GachaGameStuff.HonkaiImpact.Commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
public class HonkaiGoT extends Command
{
    //update as the game update
    private final String gameVersion = "4.6";

    public HonkaiGoT()
    {
        this.name = "HonkaiGoT";
        this.aliases = new String[]{"GoT"};
        this.arguments = "abbreviation";
        this.requiredRole = "member";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent event)
    {
        event.getMessage().delete().complete();

        if (event.getArgs().isEmpty())
        {
            event.reply("Please enter an abbreviation");
        }
        //Special case for 6S
        else if(event.getArgs().equalsIgnoreCase("6S"))
        {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(Glossary.SixS.getFullName());
            embed.setImage(Glossary.SixS.getPicURL());
            embed.setColor(Color.lightGray);
            embed.setFooter("Version: " + gameVersion);

            event.reply(embed.build());
        }
        else
        {
            String argument = event.getArgs();
            EmbedBuilder embed = new EmbedBuilder();
            boolean pass = false;

            for (Glossary glossary : Glossary.values())
            {
                if(glossary.name().equalsIgnoreCase(argument))
                {
                    embed.setTitle(glossary.getFullName());
                    embed.setImage(glossary.getPicURL());
                    embed.setColor(Color.lightGray);
                    embed.setFooter("Version: " + gameVersion);

                    pass = true;
                    break;
                }
            }

            if(pass)
            {
                event.reply(embed.build());
            }
            else
            {
                event.reply("I don't know what you wrote, please try again");
            }
        }
    }

    /**
     * @Version 4.6
     * */
    private enum Glossary
    {
        //Valkyries

        //Kiana
        CW("White Comet", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/6/63/White_Comet.png/revision/latest?cb=20180521030059"),
        VR("Valkyrie ranger", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/6/64/Valkyrie_Ranger.png/revision/latest?cb=20180521030048"),
        VD("Void Drifter", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/3/3c/Void_Drifter.png/revision/latest?cb=20191216012416"),
        DP("Divind Prayer", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/9/93/Divine_Prayer.png/revision/latest?cb=20180521030111"),
        KM("Knight Moonbeam", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/2/2d/Knight_Moonbeam.png/revision/latest?cb=20180521030120"),
        KMB("Knight Moonbeam", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/2/2d/Knight_Moonbeam.png/revision/latest?cb=20180521030120"),
        HoV("Herrscher of the Void", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/2/29/Herrscher_of_the_Void.png/revision/latest?cb=20190117214555"),

        //Mei
        CI("Crimson Impulse", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/c/c6/Crimson_Impulse.png/revision/latest?cb=20180729183734"),
        SD("Shadow Dash", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/9/92/Shadow_Dash.png/revision/latest?cb=20180521030707"),
        DS("Danzai Spectramancer", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/0/08/Danzai_Spectramancer.png/revision/latest?cb=20200922113443"),
        VB("Valkyrie Bladestrike", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/3/39/Valkyrie_Bladestrike.png/revision/latest?cb=20180521030659"),
        StFu("Striker Fulminata", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/c/ca/Striker_Fulminata.png/revision/latest?cb=20191216012424"),
        LE("Lightning Empress", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/4/4d/Lightning_Empress.png/revision/latest?cb=20180521030716"),
        HoT("Herrscher of Thunder", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/3/3c/Herrscher_of_Thunder.png/revision/latest?cb=20200807063455"),

        //Bronya
        VC("Valkyrie Chariot", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/5a/Valkyrie_Chariot.png/revision/latest?cb=20180521033739"),
        SS("Snowy Sniper", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/8a/Snowy_Sniper.png/revision/latest?cb=20180521033749"),
        YA("Yamabuki Armor", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/9/99/Yamabuki_Armor.png/revision/latest?cb=20180521033759"),
        DK("Drive Kometa", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/b9/Drive_Kometa.png/revision/latest?cb=20191216012419"),
        DB("Dimension Breaker", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/8e/Dimension_Breaker.png/revision/latest?cb=20180521033810"),
        BN("Black Nucleus", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/59/Black_Nucleus.png/revision/latest?cb=20180805051258"),
        HoR("Herrscher of Reason", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/0/0a/Herrscher_of_Reason.png/revision/latest?cb=20190810032309"),
        WD("Wolf's Dawn", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/d/d1/Wolf%27s_Dawn.png/revision/latest?cb=20180805172721"),
        //ASSUME
        HB("Haxxor Bunny", ""),
        //ASSUME
        Haxx("Haxxor Bunny", ""),

        //Himeko
        BS("Battle Storm", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/2/2b/Battle_Storm.png/revision/latest?cb=20180521031258"),
        VT("Valkyrie Triumph", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/0/02/Valkyrie_Triumph.png/revision/latest?cb=20180521031910"),
        SF("Scarlet Fusion", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/54/Scarlet_Fusion.png/revision/latest?cb=20180521031921"),
        BR("Blood Rose", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/4/4f/Blood_Rose.png/revision/latest?cb=20180521032845"),
        IceHimeko("Kriegsmesser", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/3/31/Kriegsmesser.png/revision/latest?cb=20181223001500"),
        Kriegs("Kriegsmesser", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/3/31/Kriegsmesser.png/revision/latest?cb=20181223001500"),
        VK("Vermilion Knight - Eclipse", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/4/4c/Vermilion_Knight_-_Eclipse.png/revision/latest?cb=20190308024957"),

        //Yae Sakura
        Miko("Gyakushinn Miko", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/b5/Gyakushinn_Miko.png/revision/latest?cb=20180521042221"),
        Meme("Goushinnso Memento", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/9/95/Goushinnso_Memento.png/revision/latest?cb=20180521042229"),
        FS("Flame Sakitama", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/9/98/Flame_Sakitama.png/revision/latest?cb=20180521042246"),
        DJ("Darkbolt Jonin", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/4/4b/Darkbolt_Jonin.png/revision/latest?cb=20191219090833"),

        //Theresa
        Teri("Theresa", "https://i.redd.it/js1opgevifo41.jpg"),
        VP("Valkyrie Pledge", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/a/a4/Valkyrie_Pledge.png/revision/latest?cb=20180621015250"),
        VE("Violet Executer", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/7/7b/Violet_Executer.png/revision/latest?cb=20180621015436"),
        TP("Twilight Paladin", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/a/a4/Twilight_Paladin.png/revision/latest?cb=20191216012412"),
        SR("Sakuno Rondo", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/f/fa/Sakuno_Rondo.png/revision/latest?cb=20180621015426"),
        CH("Celestial Hymn", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/bb/Celestial_Hymn.png/revision/latest?cb=20180621015408"),
        LK("Luna Kindred", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/b4/Luna_Kindred.png/revision/latest?cb=20181213020528"),
        SA("Starlit Astrologos", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/8c/Starlit_Astrologos.png/revision/latest?cb=20200628001034"),

        //Fu Hua
        VA("Valkyrie Accipiter", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/f/f7/Valkyrie_Accipiter.png/revision/latest?cb=20180929212715"),
        HotF("Hawk of the Fog", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/0/08/Hawk_of_the_Fog.png/revision/latest?cb=20191216012421"),
        HF("Hawk of the Fog", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/0/08/Hawk_of_the_Fog.png/revision/latest?cb=20191216012421"),
        PX("Phoenix", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/c/c1/Phoenix.png/revision/latest?cb=20180929212711"),
        NS("Night Squire", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/1/12/Night_Squire.png/revision/latest?cb=20181118192702"),
        SK("Shadow Knight", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/4/4d/Shadow_Knight.png/revision/latest?cb=20180929212713"),
        AE("Azure Empyrea", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/b9/Azure_Empyrea.png/revision/latest?cb=20200207091238"),
        AzE("Azure Empyrea", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/b9/Azure_Empyrea.png/revision/latest?cb=20200207091238"),
        HoS("Herrscher of Sentience", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/6/67/Herrscher_of_Sentience.png/revision/latest?cb=20210305022240"),

        //Kallen
        IR("Imayoh Ritual", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/d/d4/Imayoh_Ritual.png/revision/latest?cb=20181118193654"),
        SixS("Sixth Serenade", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/6/63/Sixth_Serenade.png/revision/latest?cb=20181118193328"),
        SJ("Sündenjäger", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/55/Sundenjager.png/revision/latest?cb=20181223000400"),
        Jager("Sündenjäger", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/55/Sundenjager.png/revision/latest?cb=20181223000400"),

        //Rita
        UR("Umbral Rose", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/8a/Umbral_Rose.png/revision/latest?cb=20190305215236"),
        PI("Phantom Iron", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/6/61/Phantom_Iron.png/revision/latest?cb=20190404050304"),
        AK("Argent Knight: Artemis", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/1/1e/Argent_Knight_-_Artemis.png/revision/latest?cb=20190420020701"),
        FR("Fallen Rosemary", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/b0/Fallen_Rosemary.png/revision/latest?cb=20200915111813"),

        //Olenyevas
        BB("Blueberry Blitz", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/4/4e/Blueberry_Blitz.png/revision/latest?cb=20190524034435"),
        MC("Molotov Cherry", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/b/be/Molotov_Cherry.png/revision/latest?cb=20190524034437"),
        FTD("Fervent Tempo Δ", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/89/Fervent_Tempo_Δ.png/revision/latest?cb=20210131203818"),
        FT("Fervent Tempo Δ", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/89/Fervent_Tempo_Δ.png/revision/latest?cb=20210131203818"),
        Delta("Fervent Tempo Δ", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/8/89/Fervent_Tempo_Δ.png/revision/latest?cb=20210131203818"),

        //Seele
        SP("Swallowtail Phantasm", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/e/e0/Swallowtail_Phantasm.png/revision/latest?cb=20190710020737"),
        SN("Stygian Nymph", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/1/13/Stygian_Nymph.png/revision/latest?cb=20191116044946"),
        //ASSUME
        StarN("Starchasm Nyx", ""),

        //Durandal
        VG("Valkyrie Gloria", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/3/37/Valkyrie_Gloria.png/revision/latest?cb=20200414011554"),
        BK("Bright Knight: Excelsis", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/5c/Bright_Knight_-_Excelsis.png/revision/latest?cb=20200516194711"),
        BKE("Bright Knight: Excelsis", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/5/5c/Bright_Knight_-_Excelsis.png/revision/latest?cb=20200516194711"),
        DA("Dea Anchora", "https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/1/17/Dea_Anchora.png/revision/latest?cb=20210131005204"),


        //Open World
        APHO("Post-Honkai Odyssey", ""),    //TODO need picture

        ;
        //constructor
        private final String fullName;
        private final String picURL;
        Glossary(String name, String url)
        {
            this.fullName = name;
            this.picURL = url;
        }
        public String getFullName()
        {
            return fullName;
        }
        public String getPicURL()
        {
            return picURL;
        }
    }


}
