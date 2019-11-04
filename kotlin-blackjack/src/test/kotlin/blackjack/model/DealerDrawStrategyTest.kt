package blackjack.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DealerDrawStrategyTest {

    private lateinit var drawStrategy: DrawStrategy

    @BeforeEach
    internal fun setUp() {
        drawStrategy = DealerDrawStrategy()
    }

    @Test
    internal fun `17점 이상이면 더이상 카드를 받지 않는다`() {
        val hand = listOf(
            Card(Suit.HEARTS, Rank.TEN),
            Card(Suit.HEARTS, Rank.SEVEN)
        )

        drawStrategy.draw(hand)
    }
}