package dev.hongsii.blackjack.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DrawingMachineTest {

    @Test
    public void drawByCount() {
        // given
        Deck deck = DeckTest.createDeck(asList(
                CardTest.ofSpades(Card.Rank.TWO),
                CardTest.ofSpades(Card.Rank.THREE),
                CardTest.ofSpades(Card.Rank.FOUR)
        ));
        DrawingMachine drawingMachine = DrawingMachine.of(deck);
        Player player = Player.create(1);

        // when
        int drawCount = 2;
        drawingMachine.draw(drawCount, player);

        // then
        assertThat(player.getCards()).hasSize(drawCount);
    }
}