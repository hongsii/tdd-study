package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.Cards;
import dev.hongsii.blackjack.model.CardsTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BustTest {

    @Test
    public void isValid() {
        // given
        Cards cards = CardsTest.BUST;

        // when
        boolean isValid = Bust.isValid(cards);

        // then
        assertThat(isValid).isTrue();
    }

    @Test
    public void isInvalidWhenScoreIsLower() {
        // given
        Cards cards = CardsTest.BLACKJACK;

        // when
        boolean isValid = Bust.isValid(cards);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    public void create() {
        // given
        Cards cards = CardsTest.BUST;

        // when
        Bust bust = Bust.of(cards);

        // then
        assertThat(bust).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCreate() {
        // given
        Cards cards = CardsTest.BLACKJACK;

        // when
        Bust.of(cards);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotNext() {
        // given
        Bust bust = Bust.of(CardsTest.BUST);

        // when
        bust.add(CardTest.ofHearts(Card.Rank.TWO));
    }

    @Test
    public void isGameOver() {
        // given
        Bust bust = Bust.of(CardsTest.BUST);

        // when
        boolean isGameOver = bust.isGameOver();

        // then
        assertThat(isGameOver).isTrue();
    }
}