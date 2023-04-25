package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.powers.ratpack.StrongTogetherPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class StrongTogether extends AbstractRatCard {
    public final static String ID = makeID("StrongTogether");
    // intellij stuff power, self, rare, , , , , , 

    public StrongTogether() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.applyToSelf(new StrongTogetherPower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}