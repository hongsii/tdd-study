package dev.hongsii.blackjack.model.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Lose implements Result {

    public static Lose getInstance() {
        return Singleton.instance;
    }

    @Override
    public double getWinningMoneyRate() {
        return -1;
    }

    @Override
    public String getResult() {
        return "LOSE";
    }

    private static class Singleton {

        private static final Lose instance = new Lose();
    }
}
