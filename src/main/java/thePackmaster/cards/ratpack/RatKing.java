package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.creativitypack.Firewall;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class RatKing extends AbstractRatCard {
    public final static String ID = makeID("RatKing");
    // intellij stuff attack, enemy, rare, 7, 3, , , , 

    public RatKing() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 7;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void upp() {
        upgradeDamage(3);
    }
}