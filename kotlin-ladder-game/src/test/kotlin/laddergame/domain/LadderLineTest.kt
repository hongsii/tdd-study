package laddergame.domain

import laddergame.domain.Direction.*
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LadderLineTest {

    private lateinit var ladderLine: LadderLine

    @BeforeEach
    fun setUp() {
        ladderLine = LadderLine.of(DEFAULT_WIDTH, BooleanGenerationStrategy.ALWAYS_GENERATION)
    }

    @Test
    @DisplayName("Horizontal line must have point count at least ${LadderLine.MIN_POINT_COUNT}")
    fun createLine_fromInvalidPointCount_fail() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LadderLine.of(1, BooleanGenerationStrategy.ALWAYS_GENERATION) }
    }

    @Test
    @DisplayName("Generate line for size")
    fun generate_forPointCount_success() {
        assertThat(ladderLine.getPoints())
            .hasSize(DEFAULT_WIDTH)
            .containsExactly(Point(RIGHT), Point(LEFT), Point(STRAIGHT))
    }

    @DisplayName("move next index on line")
    @ParameterizedTest
    @CsvSource(
        "1, 0",
        "0, 1",
        "2, 2"
    )
    fun move(startIndex: Int, expected: Int) {
        val nextIndex = ladderLine.move(startIndex)

        assertThat(nextIndex).isEqualTo(expected)
    }

    @Test
    @DisplayName("index of out of range can't move")
    @ValueSource(ints = [-1, DEFAULT_WIDTH])
    fun move_fail() {
        assertThatIllegalArgumentException().isThrownBy { ladderLine.move(DEFAULT_WIDTH) }
    }

    companion object {

        const val DEFAULT_WIDTH = 3
    }
}