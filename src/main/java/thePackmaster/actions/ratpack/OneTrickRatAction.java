package thePackmaster.actions.ratpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import thePackmaster.cards.ratpack.Rat;
import thePackmaster.util.Wiz;

import java.util.Objects;

public class OneTrickRatAction extends AbstractGameAction {

    public OneTrickRatAction() {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        for (AbstractCard c : DrawCardAction.drawnCards) {
            if (Objects.equals(c.cardID, Rat.ID)) {
                Wiz.att(new GainEnergyAction(1));
                break;
            }
        }
        this.isDone = true;
    }


}