package dev.hongsii.blackjack.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Test
    public void equals() {
        assertThat(ofClubs(Card.Rank.ACE)).isEqualTo(ofClubs(Card.Rank.ACE));
    }

    @Test
    public void sumWhenHasNotAce() {
        // given
        Card card = ofClubs(Card.Rank.EIGHT);

        // when
        int result = card.sum(5);

        // then
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void sumWhenAceIsOneScore() {
        // given
        Card card = ofClubs(Card.Rank.ACE);

        // when
        int result = card.sum(15);

        // then
        assertThat(result).isEqualTo(16);
    }

    @Test
    public void sumWhenAceIsElevenScore() {
        // given
        Card card = ofClubs(Card.Rank.ACE);

        // when
        int result = card.sum(10);

        // then
        assertThat(result).isEqualTo(21);
    }

    @Test
    public void hasSpecialScore() {
        // given
        Card card = ofClubs(Card.Rank.ACE);

        // then
        boolean hasSpecialScore = card.hasSpecialScore();

        // when
        assertThat(hasSpecialScore).isTrue();
    }

    @Test
    public void hasNotSpecialScore() {
        // given
        Card card = ofClubs(Card.Rank.TEN);

        // then
        boolean hasSpecialScore = card.hasSpecialScore();

        // when
        assertThat(hasSpecialScore).isFalse();
    }

    public static Card ofClubs(Card.Rank rank) {
        return Card.of(Card.Suit.CLUBS, rank);
    }

    public static Card ofDiamonds(Card.Rank rank) {
        return Card.of(Card.Suit.DIAMONDS, rank);
    }

    public static Card ofHearts(Card.Rank rank) {
        return Card.of(Card.Suit.HEARTS, rank);
    }

    public static Card ofSpades(Card.Rank rank) {
        return Card.of(Card.Suit.SPADES, rank);
    }
}