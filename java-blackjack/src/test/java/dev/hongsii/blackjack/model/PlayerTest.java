package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Bust;
import dev.hongsii.blackjack.model.hand.Normal;
import dev.hongsii.blackjack.model.result.Lose;
import dev.hongsii.blackjack.model.result.Result;
import dev.hongsii.blackjack.model.result.Win;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = Player.of(1, Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));
    }

    @Test
    public void receive() {
        // when
        player.receive(CardTest.ofDiamonds(Card.Rank.TWO));

        // then
        assertThat(player.getCards()).hasSize(2);
    }

    @Test
    public void win() {
        // given
        Normal hand = Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)));
        player = Player.of(1, hand, Money.of(0));
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        Result result = player.winTo(dealer);

        // then
        assertThat(result).isEqualTo(Win.from(hand));
    }

    @Test
    public void winWhenDealerIsBust() {
        // given
        Normal hand = Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)));
        player = Player.of(1, hand, Money.of(0));
        Dealer dealer = Dealer.of(Bust.of(CardsTest.BUST));

        // when
        Result result = player.winTo(dealer);

        // then
        assertThat(result).isEqualTo(Win.from(hand));
    }

    @Test
    public void lose() {
        // given
        Normal hand = Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.EIGHT)));
        player = Player.of(1, hand, Money.of(0));
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        Result result = player.winTo(dealer);

        // then
        assertThat(result).isEqualTo(Lose.getInstance());
    }
}