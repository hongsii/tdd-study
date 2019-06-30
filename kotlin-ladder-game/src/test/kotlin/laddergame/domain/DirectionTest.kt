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

    @DisplayName("If before direction is side, next direction must have reverse direction")
    @ParameterizedTest
    @CsvSource(
        "LEFT    , RIGHT",
        "RIGHT   , LEFT"
    )
    fun next_reverseDirection_success(beforeDirection: Direction, expected: Direction) {
        val nextDirection = beforeDirection.next { Direction.STRAIGHT }

        assertThat(nextDirection).isEqualTo(expected)
    }

    @Test
    @DisplayName("If before direction is straight, next direction choose from direction strategy")
    fun next_whenStraightDirectionToStrategyDirection_success() {
        val beforeDirection = Direction.STRAIGHT
        val expected = Direction.RIGHT

        val nextDirection = beforeDirection.next { expected }

        assertThat(nextDirection).isEqualTo(expected)
    }
}