package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class RatGuard extends AbstractRatCard {
    public final static String ID = makeID("RatGuard");
    // intellij stuff power, self, uncommon, , , , , 3, 

    public RatGuard() {
        super(ID, 0, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
        baseSecondMagic = secondMagic = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //apply rat guard power
        Wiz.atb(new MakeTempCardInHandAction(new Rat(), this.secondMagic));

    }

    public void upp() {
    }
}