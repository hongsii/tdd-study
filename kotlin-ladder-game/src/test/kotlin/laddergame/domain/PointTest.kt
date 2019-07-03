package laddergame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PointTest {

    @DisplayName("First point has right or straight direction")
    @ParameterizedTest
    @CsvSource(
        "true , RIGHT",
        "false, STRAIGHT"
    )
    fun first_withProperty_success(hasSideDirection: Boolean, expected: Direction) {
        val firstPoint = Point.ofRightOrStraight(BooleanGenerationStrategy(hasSideDirection))

        assertThat(firstPoint).isEqualTo(Point(expected))
    }

    @DisplayName("If before point has side direction, next point must have reverse direction")
    @ParameterizedTest
    @CsvSource(
        "LEFT  , RIGHT",
        "RIGHT , LEFT"
    )
    fun next_reverseDirection_success(beforeDirection: Direction, expected: Direction) {
        val beforePoint = Point(beforeDirection)

        val nextPoint = beforePoint.next(BooleanGenerationStrategy.ALWAYS_GENERATION)

        assertThat(nextPoint).isEqualTo(Point(expected))
    }

    @Test
    @DisplayName("If before point has straight direction, next point has direction from alwaysGeneration strategy")
    fun next_whenStraightDirectionToStrategyDirection_success() {
        val beforePoint = Point(Direction.STRAIGHT)
        val nextDirection = Direction.RIGHT

        val nextPoint = beforePoint.next(BooleanGenerationStrategy.ALWAYS_GENERATION)

        assertThat(nextPoint).isEqualTo(Point(nextDirection))
    }
}