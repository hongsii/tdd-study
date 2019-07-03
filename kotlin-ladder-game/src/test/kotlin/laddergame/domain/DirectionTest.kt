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
    @CsvSource(
        "true , false, LEFT",
        "false, false, STRAIGHT",
        "false, true , RIGHT"
    )
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

    @ParameterizedTest(name = "[{index}] : reverse of {0} is {1}")
    @CsvSource(
        "LEFT, RIGHT",
        "RIGHT, LEFT",
        "STRAIGHT, STRAIGHT"
    )
    fun reverse(direction: Direction, expected: Direction) {
        assertThat(direction.reverse()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} is side : {1}")
    @CsvSource(
        "LEFT, true",
        "RIGHT, true",
        "STRAIGHT, false"
    )
    fun reverse(direction: Direction, expected: Boolean) {
        assertThat(direction.isSide()).isEqualTo(expected)
    }
}