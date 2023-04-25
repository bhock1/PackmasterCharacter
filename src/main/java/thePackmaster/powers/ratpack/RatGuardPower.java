package thePackmaster.powers.ratpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import thePackmaster.cards.ratpack.Rat;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.util.Wiz;

import java.util.Objects;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class RatGuardPower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("RatGuardPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public RatGuardPower(AbstractCreature owner, int amount) {
        super(POWER_ID,NAME,PowerType.BUFF,false,owner,amount);
    }

    @Override
    public void onAfterCardPlayed(AbstractCard usedCard) {
        if (Objects.equals(usedCard.cardID, Rat.ID)){
            Wiz.atb(new GainBlockAction(owner, this.amount));
        }
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
