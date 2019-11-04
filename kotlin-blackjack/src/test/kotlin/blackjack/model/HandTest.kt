package blackjack.model

import org.junit.jupiter.api.Test

internal class HandTest {

    @Test
    internal fun `패에 카드를 추가하다`() {
        val emptyHand = Hand()

        emptyHand.add()
    }
}