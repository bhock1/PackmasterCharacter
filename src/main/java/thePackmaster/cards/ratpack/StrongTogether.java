package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class StrongTogether extends AbstractRatCard {
    public final static String ID = makeID("StrongTogether");
    // intellij stuff power, self, rare, , , , , , 

    public StrongTogether() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //apply strong together power
        //1 temp strength for each rat created

    }

    public void upp() {
    }
}