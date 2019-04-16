package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.Cards;
import dev.hongsii.blackjack.model.CardsTest;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackTest {

    @Test
    public void isValid() {
        // given
        Cards cards = Cards.of(asList(
                CardTest.ofClubs(Card.Rank.ACE),
                CardTest.ofClubs(Card.Rank.JACK)
        ));

        // when
        boolean isValid = Blackjack.isValid(cards);

        // then
        assertThat(isValid).isTrue();
    }

    @Test
    public void isInvalidWhenIsNotSameScore() {
        // given
        Cards cards = Cards.of(asList(
                CardTest.ofClubs(Card.Rank.EIGHT),
                CardTest.ofClubs(Card.Rank.JACK)
        ));

        // when
        boolean isValid = Blackjack.isValid(cards);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    public void isInvalidWhenHasMoreCards() {
        // given
        Cards cards = Cards.of(asList(
                CardTest.ofClubs(Card.Rank.EIGHT),
                CardTest.ofClubs(Card.Rank.THREE),
                CardTest.ofClubs(Card.Rank.JACK)
        ));

        // when
        boolean isValid = Blackjack.isValid(cards);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    public void create() {
        // given
        Cards cards = CardsTest.BLACKJACK;


        // when
        Blackjack blackjack = Blackjack.of(cards);

        // then
        assertThat(blackjack).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCreate() {
        // given
        Cards cards = CardsTest.BUST;

        // when
        Blackjack.of(cards);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotNext() {
        // given
        Blackjack blackjack = Blackjack.of(CardsTest.BLACKJACK);

        // when
        blackjack.add(CardTest.ofDiamonds(Card.Rank.ACE));
    }

    @Test
    public void isGameOver() {
        // given
        Blackjack blackjack = Blackjack.of(CardsTest.BLACKJACK);

        // when
        boolean isGameOver = blackjack.isGameOver();

        // then
        assertThat(isGameOver).isTrue();
    }
}