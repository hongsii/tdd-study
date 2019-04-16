package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Normal extends Hand {

    private Normal(Cards cards) {
        super(cards);
    }

    public static Normal of(Cards cards) {
        if (cards.getTotalScore() >= Blackjack.SCORE) {
            throw new IllegalArgumentException(String.format("점수는 %d 미만이여야 합니다.", Blackjack.SCORE));
        }
        return new Normal(cards);
    }

    @Override
    public Hand add(Card card) {
        cards.add(card);
        if (Blackjack.isValid(cards)) {
            return Blackjack.of(cards);
        }
        if (Bust.isValid(cards)) {
            return Bust.of(cards);
        }
        return this;
    }

    @Override
    public double getWinningMoneyRate() {
        return 1;
    }

    @Override
    public boolean isBlackjack() {
        return Blackjack.isValid(cards);
    }

    @Override
    public boolean isBust() {
        return Bust.isValid(cards);
    }
}
