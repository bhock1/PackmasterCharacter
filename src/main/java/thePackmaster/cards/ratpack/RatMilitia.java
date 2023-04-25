package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.ratpack.RatMilitiaPower;
import thePackmaster.powers.ratpack.WaveOfTheRatPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class RatMilitia extends AbstractRatCard {
    public final static String ID = makeID("RatMilitia");
    // intellij stuff power, self, uncommon, , , , , 3, 

    public RatMilitia() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
        baseSecondMagic = secondMagic = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.applyToSelf(new RatMilitiaPower(p, magicNumber));
        Wiz.atb(new MakeTempCardInHandAction(new Rat(), this.secondMagic));
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}