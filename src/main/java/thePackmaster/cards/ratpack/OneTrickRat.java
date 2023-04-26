package thePackmaster.cards.ratpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.EscapePlanAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.ratpack.OneTrickRatAction;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class OneTrickRat extends AbstractRatCard {
    public final static String ID = makeID("OneTrickRat");
    // intellij stuff attack, enemy, uncommon, 10, 12, , , 1, 

    public OneTrickRat() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 10;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, Wiz.getRandomSlash());
        Wiz.atb(new DrawCardAction(1, new OneTrickRatAction()));
    }

    public void upp() {
        upgradeDamage(2);
    }
}