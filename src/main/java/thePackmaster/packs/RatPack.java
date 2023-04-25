package thePackmaster.packs;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.ratpack.*;

import java.util.ArrayList;

public class RatPack extends AbstractCardPack{
    public static final String ID = SpireAnniversary5Mod.makeID("RatPack");
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public RatPack() {
        super(ID, NAME, DESC, AUTHOR);
    }


    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add(Cheese.ID);
        cards.add(OneTrickRat.ID);
        cards.add(Ratastrophe.ID);
        cards.add(RatGuard.ID);
        cards.add(RatMilitia.ID);
        cards.add(RatKing.ID);
        cards.add(RatSwarm.ID);
        cards.add(RattyStrike.ID);
        cards.add(RatWall.ID);
        cards.add(StrongTogether.ID);
        return cards;
    }
}
