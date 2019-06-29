package laddergame.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DirectionTest {

    @DisplayName("find direction from property")
    @ParameterizedTest
    @CsvSource(value = [
        "true , false, LEFT",
        "false, false, STRAIGHT",
        "false, true , RIGHT"
    ])
    fun of(left: Boolean, right: Boolean, expected: Direction) {
        val actual = Direction.of(left, right)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    @DisplayName("fail to find direction from property")
    fun of_fail() {
        assertThatIllegalArgumentException()
            .isThrownBy { Direction.of(left = true, right = true) }
    }

    @DisplayName("reverse direction")
    @ParameterizedTest
    @CsvSource(value = [
        "LEFT    , RIGHT",
        "STRAIGHT, STRAIGHT",
        "RIGHT   , LEFT"
    ])
    fun reverse(direction: Direction, expected: Direction) {
        val actual = direction.reverse()

        assertThat(actual).isEqualTo(expected)
    }
}