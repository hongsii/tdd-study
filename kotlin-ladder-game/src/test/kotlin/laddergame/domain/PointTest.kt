package laddergame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PointTest {

    @DisplayName("First point has right or straight direction")
    @ParameterizedTest
    @CsvSource(
        "true , RIGHT",
        "false, STRAIGHT"
    )
    fun first(hasSideDirection: Boolean, expected: Direction) {
        val firstPoint = Point.first(hasSideDirection)

        assertThat(firstPoint.getDirection()).isEqualTo(expected)
    }
}