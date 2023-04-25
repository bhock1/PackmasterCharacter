package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class Ratastrophe extends AbstractRatCard {
    public final static String ID = makeID("Ratastrophe");
    // intellij stuff Skill, none, rare, , , , , , 

    public Ratastrophe() {
        super(ID, 2, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
        exhaust=true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int toRat = 11 - p.hand.size();
        if (toRat > 0){
            Wiz.att(new MakeTempCardInHandAction(new Rat(), toRat));
        }
    }

    public void upp() {
        upgradeBaseCost(1);
    }
}