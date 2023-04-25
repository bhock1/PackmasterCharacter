package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.cards.creativitypack.Firewall;
import thePackmaster.util.Wiz;

import java.util.ArrayList;
import java.util.Collection;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class RatKing extends AbstractRatCard {
    public final static String ID = makeID("RatKing");
    // intellij stuff attack, enemy, rare, 7, 3, , , , 

    public RatKing() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 7;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int hits = 0;

        for (AbstractCard c : p.drawPile.group){
            if (c.cardID == Rat.ID){
                Wiz.att(new ExhaustSpecificCardAction(c, p.drawPile));
                hits++;
            }
        }

        for (AbstractCard c : p.discardPile.group){
            if (c.cardID == Rat.ID){
                Wiz.att(new ExhaustSpecificCardAction(c, p.discardPile));
                hits++;
            }
        }

        for (AbstractCard c : p.hand.group){
            if (c.cardID == Rat.ID){
                Wiz.att(new ExhaustSpecificCardAction(c, p.hand));
                hits++;
            }
        }

        for (int i = 0; i < hits; i++){
            dmg(m, Wiz.getRandomSlash());
        }

    }

    public void upp() {
        upgradeDamage(3);
    }
}