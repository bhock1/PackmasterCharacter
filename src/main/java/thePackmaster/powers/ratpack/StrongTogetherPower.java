package thePackmaster.powers.ratpack;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.cards.ratpack.Rat;
import thePackmaster.util.Wiz;
import thePackmaster.util.creativitypack.onGenerateCardMidcombatInterface;
import thePackmaster.powers.AbstractPackmasterPower;

import java.util.Objects;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class StrongTogetherPower extends AbstractPackmasterPower implements onGenerateCardMidcombatInterface
{
    public static final String POWER_ID = makeID("StrongTogetherPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public StrongTogetherPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, false, owner, amount);
    }

    @Override
    public void onCreateCard(AbstractCard card) {
        if (Objects.equals(card.cardID, Rat.ID)) {
            addToBot(new ApplyPowerAction(owner, owner, new StrengthPower(owner, amount), amount));
            addToBot(new ApplyPowerAction(owner, owner, new LoseStrengthPower(owner, amount), amount));
        }
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
