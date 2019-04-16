package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Ready extends Hand {

    private Ready() {
        super(Cards.initialize());
    }

    public static Ready ready() {
        return new Ready();
    }

    @Override
    public Hand add(Card card) {
        cards.add(card);
        return Normal.of(cards);
    }

    @Override
    public double getWinningMoneyRate() {
        return 0;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    @Override
    public boolean isBust() {
        return false;
    }
}

