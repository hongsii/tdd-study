package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.CardsTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTotalIsMoreThanBlackjackScore() {
        Normal.of(CardsTest.BLACKJACK);
    }

    @Test
    public void nextToNormal() {
        // given
        Card ten = CardTest.ofClubs(Card.Rank.TEN);
        Card six = CardTest.ofClubs(Card.Rank.SIX);
        Normal current = Normal.of(CardsTest.createCards(ten, six));

        // when
        Card nextCard = CardTest.ofClubs(Card.Rank.THREE);
        Hand next = current.add(nextCard);

        // then
        Normal expected = Normal.of(CardsTest.createCards(ten, six, nextCard));
        assertThat(next).isEqualTo(expected);
    }

    @Test
    public void nextToBlackjack() {
        // given
        Card ace = CardTest.ofClubs(Card.Rank.ACE);
        Normal current = Normal.of(CardsTest.createCards(ace));

        // when
        Card nextCard = CardTest.ofClubs(Card.Rank.TEN);
        Hand next = current.add(nextCard);

        // then
        assertThat(next).isInstanceOf(Blackjack.class);
        assertThat(next).isEqualTo(Blackjack.of(CardsTest.createCards(ace, nextCard)));
    }

    @Test
    public void nextToBust() {
        // given
        Card ten = CardTest.ofClubs(Card.Rank.TEN);
        Card six = CardTest.ofClubs(Card.Rank.SIX);
        Normal current = Normal.of(CardsTest.createCards(ten, six));

        // when
        Card nextCard = CardTest.ofDiamonds(Card.Rank.SIX);
        Hand next = current.add(nextCard);

        // then
        assertThat(next).isInstanceOf(Bust.class);
        assertThat(next).isEqualTo(Bust.of(CardsTest.createCards(ten, six, nextCard)));
    }

    @Test
    public void isNotGameOver() {
        // given
        Normal normal = Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)));

        // when
        boolean isGameOver = normal.isGameOver();

        // then
        assertThat(isGameOver).isFalse();
    }
}