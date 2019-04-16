package dev.hongsii.blackjack.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {

    public static final Cards BLACKJACK = Cards.of(asList(CardTest.ofDiamonds(Card.Rank.ACE), CardTest.ofSpades(Card.Rank.KING)));
    public static final Cards BUST = Cards.of(asList(CardTest.ofDiamonds(Card.Rank.EIGHT), CardTest.ofSpades(Card.Rank.JACK), CardTest.ofClubs(Card.Rank.FOUR)));

    @Test
    public void addCard() {
        // given
        Cards cards = Cards.initialize();

        // when
        cards.add(Card.of(Card.Suit.CLUBS, Card.Rank.EIGHT));

        // then
        assertThat(cards.getTotalScore()).isEqualTo(8);
    }

    @Test
    public void getTotalScoreWhenAceIsEleven() {
        // given
        Cards cards = Cards.of(asList(
                Card.of(Card.Suit.CLUBS, Card.Rank.ACE),
                Card.of(Card.Suit.CLUBS, Card.Rank.TEN)
        ));

        // when
        int totalScore = cards.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(21);
    }

    @Test
    public void getTotalScoreWhenAceIsElevenAndHasThreeCard() {
        // given
        Cards cards = Cards.of(asList(
                Card.of(Card.Suit.CLUBS, Card.Rank.FIVE),
                Card.of(Card.Suit.CLUBS, Card.Rank.ACE),
                Card.of(Card.Suit.CLUBS, Card.Rank.QUEEN)
        ));

        // when
        int totalScore = cards.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(16);
    }

    @Test
    public void getTotalScoreWhenHasOnlyTwoAce() {
        // given
        Cards cards = Cards.of(asList(
                Card.of(Card.Suit.CLUBS, Card.Rank.ACE),
                Card.of(Card.Suit.CLUBS, Card.Rank.ACE)
        ));

        // when
        int totalScore = cards.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(12);
    }

    @Test
    public void getTotalScoreWhenAllAceIsOneScore() {
        // given
        Cards cards = Cards.of(asList(
                CardTest.ofClubs(Card.Rank.EIGHT),
                CardTest.ofClubs(Card.Rank.FIVE),
                CardTest.ofClubs(Card.Rank.ACE),
                CardTest.ofDiamonds(Card.Rank.ACE)
        ));
        // 13 1 1

        // when
        int totalScore = cards.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(15);
    }

    public static Cards createCards(Card... cards) {
        return Cards.of(asList(cards));
    }
}