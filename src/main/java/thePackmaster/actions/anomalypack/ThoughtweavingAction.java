package thePackmaster.actions.anomalypack;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardGroup.CardGroupType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.NoDrawPower;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.util.Wiz;

import java.util.Iterator;

public class ThoughtweavingAction extends AbstractGameAction {
    private AbstractPlayer p;
    private CardType typeToCheck;
    private String packIDToAvoid;

    public ThoughtweavingAction(int amount, CardType type, String packIDToAvoid) {
        this.p = AbstractDungeon.player;
        this.setValues(this.p, this.p, amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_MED;
        this.typeToCheck = type;
        this.packIDToAvoid = packIDToAvoid;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_MED) {
            if (this.p.drawPile.isEmpty() || p.hasPower(NoDrawPower.POWER_ID)) {
                this.isDone = true;
                return;
            }
            int counter = 0;
            CardGroup tmp = new CardGroup(CardGroupType.UNSPECIFIED);
            Iterator var2 = this.p.drawPile.group.iterator();

            AbstractCard card;
            while(var2.hasNext() && counter < amount) {
                AbstractCard c = (AbstractCard)var2.next();
                String parentID = SpireAnniversary5Mod.cardParentMap.getOrDefault(c.cardID, null);
                if (c.type == this.typeToCheck && parentID != null && !parentID.equals(packIDToAvoid)) {
                    tmp.addToRandomSpot(c);
                    counter++;
                }
            }

            if (tmp.isEmpty()) {
                this.isDone = true;
                return;
            }


            for(int i = 0; i < counter; ++i) {
                if (!tmp.isEmpty()) {
                    if (this.p.hand.size() == BaseMod.MAX_HAND_SIZE) {
                        this.p.createHandIsFullDialog();
                    } else {
                        card = tmp.getBottomCard();
                        tmp.removeCard(card);
                        p.drawPile.group.remove(card);
                        p.drawPile.addToTop(card);
                        Wiz.att(new DrawCardAction(1));
                    }
                }
            }

            this.isDone = true;
        }

        this.tickDuration();
    }
}
