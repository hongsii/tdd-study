package dev.hongsii.blackjack.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackGameTest {


    private BlackjackGame blackjackGame;

    @Before
    public void setUp() throws Exception {
        blackjackGame = BlackjackGame.initializeWithSingleDeck(2);
    }

    @Test
    public void drawByDefaultCountToCardReceiver() {
        // given
       Dealer dealer = blackjackGame.getDealer();

        // when
        blackjackGame.deal(dealer);

        // then
        assertThat(dealer.getCards()).hasSize(BlackjackGame.DEFAULT_DRAW_COUNT);
    }

    @Test
    public void receiveAdditionalCardWhenHit() {
        for (Player player : blackjackGame.getPlayers()) {
            blackjackGame.hit(player);
            assertThat(player.getCards()).hasSize(BlackjackGame.ADDITIONAL_DRAW_COUNT);
        }
    }

    @Test
    public void winToDealer() {
        // given
        Player player = blackjackGame.getPlayers().stream().findFirst().get();
        Dealer dealer = blackjackGame.getDealer();

        int currentMoney = player.getMoney();
        blackjackGame.betOnTable(player, 1000);

        player.receive(CardTest.ofClubs(Card.Rank.TEN));
        dealer.receive(CardTest.ofClubs(Card.Rank.NINE));

        // when
        blackjackGame.winToDealer(player);

        // then
        assertThat(player.getMoney()).isEqualTo(currentMoney + 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailPlayerCountMoreThanMaxPlayerCount() {
        BlackjackGame.initializeWithSingleDeck(BlackjackGame.MAX_PLAYER_COUNT + 1);
    }
}