package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.Cards;
import groovy.transform.EqualsAndHashCode;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@EqualsAndHashCode
public class ReadyTest {

    private Ready ready;

    @Before
    public void setUp() throws Exception {
        ready = Ready.ready();
    }

    @Test
    public void nextToTotal() {
        // given
        Card card = CardTest.ofHearts(Card.Rank.NINE);

        // when
        Hand next = ready.add(card);

        // then
        assertThat(next).isEqualTo(Normal.of(Cards.of(asList(card))));
    }

    @Test
    public void isNotGameOver() {
        // when
        boolean isGameOver = ready.isGameOver();

        // then
        assertThat(isGameOver).isFalse();
    }
}
