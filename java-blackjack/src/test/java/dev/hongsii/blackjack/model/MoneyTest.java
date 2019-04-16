package dev.hongsii.blackjack.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void plus() {
        // given
        Money money = Money.of(500);

        // when
        money.plus(100);

        // then
        assertThat(money.getMoney()).isEqualTo(600);
    }

    @Test
    public void minus() {
        // given
        Money money = Money.of(500);

        // when
        money.minus(100);

        // then
        assertThat(money.getMoney()).isEqualTo(400);
    }
}