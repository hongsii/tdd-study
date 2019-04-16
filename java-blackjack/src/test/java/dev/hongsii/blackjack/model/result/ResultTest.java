package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.CardsTest;
import dev.hongsii.blackjack.model.hand.Blackjack;
import dev.hongsii.blackjack.model.hand.Normal;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    public void calculateWinningMoneyByWinAsBlackjack() {
        // given
        Win win = Win.from(Blackjack.of(CardsTest.BLACKJACK));

        // when
        int winningMoney = win.calculateWinningMoney(1000);

        // then
        assertThat(winningMoney).isEqualTo(1500);
    }

    @Test
    public void calculateWinningMoneyByWinAsNormal() {
        // given
        Win win = Win.from(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.KING))));

        // when
        int winningMoney = win.calculateWinningMoney(1000);

        // then
        assertThat(winningMoney).isEqualTo(1000);
    }

    @Test
    public void calculateWinningMoneyByPush() {
        // given
        Push push = Push.getInstance();

        // when
        int winningMoney = push.calculateWinningMoney(1000);

        // then
        assertThat(winningMoney).isEqualTo(0);
    }

    @Test
    public void calculateWinningMoneyByLose() {
        // given
        Lose lose = Lose.getInstance();

        // when
        int winningMoney = lose.calculateWinningMoney(1000);

        // then
        assertThat(winningMoney).isEqualTo(-1000);
    }
}