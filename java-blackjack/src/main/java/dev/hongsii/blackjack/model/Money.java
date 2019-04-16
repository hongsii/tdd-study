package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Money {

    private static final int DEFAULT_MONEY = 500;

    private int money;

    public static Money ofDefault() {
        return of(DEFAULT_MONEY);
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public void plus(int money) {
        this.money += money;
    }

    public void minus(int money) {
        this.money -= money;
    }
}
