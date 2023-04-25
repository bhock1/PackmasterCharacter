package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.powers.ratpack.WaveOfTheRatPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class RatSwarm extends AbstractRatCard {
    public final static String ID = makeID("RatSwarm");
    // intellij stuff skill, none, common, , , , , 2, 1

    public RatSwarm() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = 2;
        baseSecondMagic = secondMagic = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.atb(new MakeTempCardInHandAction(new Rat(), this.magicNumber));
        Wiz.applyToSelf(new WaveOfTheRatPower(p, secondMagic));

    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}