package laddergame.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HorizontalLineTest {

    @Test
    @DisplayName("Horizontal line must have point count at least ${HorizontalLine.MIN_POINT_COUNT}")
    fun createLine_fromInvalidPointCount_fail() {
        val invalidPoints = (1 until HorizontalLine.MIN_POINT_COUNT)
            .map { Point(Direction.LEFT) }

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { HorizontalLine(invalidPoints) }
    }
}