package laddergame.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    @DisplayName("Player's name can be up to 1~5 characters")
    fun createWithName() {
        val length = 5
        val name = "박".repeat(length)

        assertThatIllegalArgumentException().isThrownBy { Player(name) }
    }
}