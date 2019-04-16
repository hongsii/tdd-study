package dev.hongsii.blackjack.model.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Push implements Result {

    public static Push getInstance() {
        return Singleton.instance;
    }

    @Override
    public double getWinningMoneyRate() {
        return 0;
    }

    @Override
    public String getResult() {
        return "PUSH";
    }

    private static class Singleton {

        private static final Push instance = new Push();
    }
}
