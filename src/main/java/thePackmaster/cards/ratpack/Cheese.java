package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class Cheese extends AbstractRatCard {
    public final static String ID = makeID("Cheese");
    // intellij stuff power, self, uncommon, , , , , , 

    public Cheese() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //apply cheese power!

    }

    public void upp() {
        this.isInnate = true;
    }
}