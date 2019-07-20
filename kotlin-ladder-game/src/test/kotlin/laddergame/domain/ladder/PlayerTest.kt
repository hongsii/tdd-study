package laddergame.domain.ladder

import laddergame.exception.InvalidPlayerNameException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {

    @DisplayName("Player's name must be in valid name length")
    @ParameterizedTest(name = "[{index}] : length : {0}")
    @ValueSource(ints = [ Player.MIN_NAME_LENGTH, Player.MAX_NAME_LENGTH ])
    fun createWithName(nameLength: Int) {
        val validName = "박".repeat(nameLength)

        assertThat(Player(validName)).isNotNull
    }

    @DisplayName("Player's name must be in valid name length")
    @ParameterizedTest(name = "[{index}] : length : {0}")
    @ValueSource(ints = [ Player.MIN_NAME_LENGTH - 1, Player.MAX_NAME_LENGTH + 1 ])
    fun createWithName_fail(nameLength: Int) {
        val invalidName = "박".repeat(nameLength)

        assertThatExceptionOfType(InvalidPlayerNameException::class.java)
            .isThrownBy { Player(invalidName) }
    }
}