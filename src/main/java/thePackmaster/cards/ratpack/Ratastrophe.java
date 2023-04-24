package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class Ratastrophe extends AbstractRatCard {
    public final static String ID = makeID("Ratastrophe");
    // intellij stuff Skill, none, rare, , , , , , 

    public Ratastrophe() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.NONE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //fill hand with rats

    }

    public void upp() {
    }
}