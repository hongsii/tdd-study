package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Bust;
import dev.hongsii.blackjack.model.hand.Normal;
import dev.hongsii.blackjack.model.result.Lose;
import dev.hongsii.blackjack.model.result.Push;
import dev.hongsii.blackjack.model.result.Result;
import dev.hongsii.blackjack.model.result.Win;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    public void receiveCardWhenTotalScoreLessThanScoreForReceive() {
        // given
        Normal handOfSixteen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN), CardTest.ofSpades(Card.Rank.SIX)));
        Dealer dealer = Dealer.of(handOfSixteen);

        // when
        dealer.receive(CardTest.ofDiamonds(Card.Rank.TWO));

        // then
        assertThat(dealer.getCards()).hasSize(3);
    }

    @Test
    public void receiveCardWhenHasOneCard() {
        // given
        Normal handOfTen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN)));
        Dealer dealer = Dealer.of(handOfTen);

        // when
        dealer.receive(CardTest.ofDiamonds(Card.Rank.NINE));

        // then
        assertThat(dealer.getCards()).hasSize(2);
    }

    @Test
    public void shouldNotReceiveCardWhenHasThreeCardsAndLessThan() {
        // given
        Normal handOfTen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN)));
        Dealer dealer = Dealer.of(handOfTen);

        // when
        dealer.receive(CardTest.ofDiamonds(Card.Rank.NINE));

        // then
        assertThat(dealer.getCards()).hasSize(2);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotReceiveCardWhenTotalScoreMoreThanScoreForReceive() {
        // given
        Normal cardsOfSeventeen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN), CardTest.ofSpades(Card.Rank.SEVEN)));
        Dealer dealer = Dealer.of(cardsOfSeventeen);

        // when
        dealer.receive(CardTest.ofDiamonds(Card.Rank.TWO));
    }

    @Test
    public void matchWhenPlayerWins() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        Result result = dealer.match(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // then
        assertThat(result).isEqualTo(Win.from(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)))));
    }

    @Test
    public void matchWhenPlayerLoses() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // when
        Result result = dealer.match(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // then
        assertThat(result).isEqualTo(Lose.getInstance());
    }

    @Test
    public void matchWhenPlayerIsBust() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // when
        Result result = dealer.match(Bust.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN))));

        // then
        assertThat(result).isEqualTo(Lose.getInstance());
    }

    @Test
    public void matchWhenDealerIsBust() {
        // given
        Dealer dealer = Dealer.of(Bust.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN))));

        // when
        Result result = dealer.match(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // then
        assertThat(result).isEqualTo(Win.from(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)))));
    }

    @Test
    public void matchWhenEachScoreEquals() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // when
        Result result = dealer.match(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // then
        assertThat(result).isEqualTo(Push.getInstance());
    }
}