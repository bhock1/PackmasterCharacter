package thePackmaster.cards.dragonwrathpack;

import com.evacipated.cardcrawl.mod.stslib.actions.defect.EvokeSpecificOrbAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;
import com.megacrit.cardcrawl.vfx.combat.MiracleEffect;
import thePackmaster.actions.witchesstrikepack.ManifestAction;
import thePackmaster.orbs.dragonwrathpack.LightOrb;
import thePackmaster.powers.dragonwrathpack.confessionpower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.*;

public class HolyWrath extends AbstractDragonwrathCard {

    public static final String ID = makeID(HolyWrath.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String IMG = makeCardPath("Attack.png");// "public static final String IMG = makeCardPath("DivineJolt.png");
    // This does mean that you will need to have an image with the same NAME as the card in your image folder for it to run correctly.


    // /TEXT DECLARATION/


    // STAT DECLARATIO

    private static final int DAMAGE = 5;
    private static final int UPGRADE_PLUS_DMG = 2;  // UPGRADE_PLUS_DMG = 2

    // /STAT DECLARATION/


    public HolyWrath(){
        super(ID, 2, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        exhaust = true;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play("POWER_MANTRA", 0.05F);
        Wiz.vfx(new MiracleEffect(LightOrb.color,LightOrb.color2,"HEAL_3"));
        for (AbstractOrb o : AbstractDungeon.player.orbs){
            if (o instanceof LightOrb){
                addToBot(new EvokeSpecificOrbAction(o));
                break;
            }
        }
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                if (AbstractDungeon.player.hasPower(confessionpower.POWER_ID)) {
                    for (int i = 0; i < AbstractDungeon.player.getPower(confessionpower.POWER_ID).amount; i++) {
                        addToBot(new ManifestAction(new Lightning()));
                    }
                }
                isDone = true;
            }
        });
    }


    // Upgraded stats.
    @Override
    public void upp() {
        upgradeBaseCost(1);
    }
}
