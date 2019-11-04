package blackjack.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeckTest {

    @Test
    internal fun `덱은 4개의 Suit과 13개의 Rank로 구성된 52장의 카드가 있다`() {
        val deck = Deck.ofSingle()

        assertThat(deck.cards)
            .hasSize(52)
            .containsAnyElementsOf(createCardsOf(Suit.HEARTS))
            .containsAnyElementsOf(createCardsOf(Suit.DIAMONDS))
            .containsAnyElementsOf(createCardsOf(Suit.CLUBS))
            .containsAnyElementsOf(createCardsOf(Suit.SPADES))
    }

    private fun createCardsOf(suit: Suit) = Rank.values().map { Card(suit, it) }
}