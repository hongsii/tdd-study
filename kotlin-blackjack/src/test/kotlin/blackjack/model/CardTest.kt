package blackjack.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CardTest {

    @Test
    internal fun `카드는 하나의 문양과 하나의 숫자(문자)로 구성된다`() {
        assertThat(Card.of(Suit.HEARTS to Rank.TWO)).isNotNull
        assertThat(Card.of(Suit.HEARTS to Rank.KING)).isNotNull
    }
}