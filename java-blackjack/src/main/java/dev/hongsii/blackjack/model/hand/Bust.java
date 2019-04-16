package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Bust extends Hand {

    private Bust(Cards cards) {
        super(cards);
    }

    public static Bust of(Cards cards) {
        if (!isValid(cards)) {
            throw new IllegalArgumentException(String.format("점수가 %d 초과여야 합니다.", Blackjack.SCORE));
        }
        return new Bust(cards);
    }

    public static boolean isValid(Cards cards) {
        return cards.isLagerThan(Blackjack.SCORE);
    }

    @Override
    public Hand add(Card card) {
        throw new IllegalStateException("마지막 상태입니다.");
    }

    @Override
    public double getWinningMoneyRate() {
        return -1;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    @Override
    public boolean isBust() {
        return true;
    }
}
