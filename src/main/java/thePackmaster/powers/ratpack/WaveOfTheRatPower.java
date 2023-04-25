package thePackmaster.powers.ratpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.WeakPower;
import thePackmaster.actions.highenergypack.AllEnemyApplyPowerAction;
import thePackmaster.cards.ratpack.Rat;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.util.Wiz;

import java.util.Objects;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class WaveOfTheRatPower extends AbstractPackmasterPower {
    public static final String POWER_ID = makeID("WaveOfTheRatPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public WaveOfTheRatPower(AbstractCreature owner, int amount) {
        super(POWER_ID,NAME,PowerType.BUFF,true,owner,amount);
    }

    @Override
    public void onAfterCardPlayed(AbstractCard usedCard) {
        if (Objects.equals(usedCard.cardID, Rat.ID)){
            Wiz.atb(new AllEnemyApplyPowerAction(owner, amount, (q) -> new WeakPower(q, amount, false)));
        }
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        removeThis();
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
