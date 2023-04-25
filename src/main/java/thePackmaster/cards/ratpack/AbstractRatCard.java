package thePackmaster.cards.ratpack;

import thePackmaster.cards.AbstractPackmasterCard;

public abstract class AbstractRatCard extends AbstractPackmasterCard {

    public AbstractRatCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        super(cardID, cost, type, rarity, target, "downfall");
    }

    public AbstractRatCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color)
    {
        super(cardID, cost, type, rarity, target, color,"downfall");

    }
}