package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.util.Wiz;

import java.util.Objects;

import static thePackmaster.SpireAnniversary5Mod.makeID;

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
            if (Objects.equals(c.cardID, Rat.ID)){
                Wiz.att(new ExhaustSpecificCardAction(c, p.drawPile));
                hits++;
            }
        }

        for (AbstractCard c : p.discardPile.group){
            if (Objects.equals(c.cardID, Rat.ID)){
                Wiz.att(new ExhaustSpecificCardAction(c, p.discardPile));
                hits++;
            }
        }

        for (AbstractCard c : p.hand.group){
            if (Objects.equals(c.cardID, Rat.ID)){
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