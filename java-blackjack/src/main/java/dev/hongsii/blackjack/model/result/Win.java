package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Win implements Result {

    private double winningMoneyRate;

    public static Win from(Hand hand) {
        return new Win(hand.getWinningMoneyRate());
    }

    @Override
    public double getWinningMoneyRate() {
        return winningMoneyRate;
    }

    @Override
    public String getResult() {
        return "WIN";
    }
}
