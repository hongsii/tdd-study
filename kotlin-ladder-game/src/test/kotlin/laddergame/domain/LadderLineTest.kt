package laddergame.domain

import laddergame.domain.Direction.LEFT
import laddergame.domain.Direction.RIGHT
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LadderLineTest {

    @Test
    @DisplayName("Horizontal line must have point count at least ${LadderLine.MIN_POINT_COUNT}")
    fun createLine_fromInvalidPointCount_fail() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LadderLine.of(1, BooleanGenerationStrategy.ALWAYS_GENERATION) }
    }

    @Test
    @DisplayName("Generate line for size")
    fun generate_forPointCount_success() {
        val width = 4

        val horizontalLine = LadderLine.of(width, BooleanGenerationStrategy.ALWAYS_GENERATION)

        assertThat(horizontalLine.getPoints())
            .hasSize(width)
            .containsExactly(Point(RIGHT), Point(LEFT), Point(RIGHT), Point(LEFT))
    }
}