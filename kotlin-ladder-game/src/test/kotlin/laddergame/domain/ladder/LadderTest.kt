package laddergame.domain.ladder

import laddergame.domain.ladder.strategy.BooleanGenerationStrategy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LadderTest {

    @Test
    @DisplayName("Generate ladder from height")
    fun generateFromHeight() {
        val height = 5
        val width = 4

        val ladder = Ladder.of(
            height = height,
            width = width,
            generationStrategy = BooleanGenerationStrategy.ALWAYS_GENERATION
        )

        assertThat(ladder.getLines())
            .hasSize(height)
            .allMatch { it.getPoints().size == width }
    }

    @Test
    @DisplayName("Height of ladder must be at least ${Ladder.MIN_HEIGHT}")
    fun invalidHeight() {
        assertThatIllegalArgumentException()
            .isThrownBy {
                Ladder.of(
                    Ladder.MIN_HEIGHT - 1,
                    LadderLine.MIN_POINT_COUNT,
                    BooleanGenerationStrategy.ALWAYS_GENERATION
                )
            }
    }

    @DisplayName("find result index from moveAll index")
    @ParameterizedTest(name = "[{index}] : {0} -> {1}")
    @CsvSource(
        "0, 1",
        "1, 0",
        "2, 2"
    )
    fun move(startIndex: Int, expected: Int) {
        val ladder = THREE_BY_THREE_ALWAYS_GENERATION

        val resultIndex = ladder.move(startIndex)

        assertThat(resultIndex).isEqualTo(expected)
    }

    companion object {
        val THREE_BY_THREE_ALWAYS_GENERATION = Ladder.of(3, 3, BooleanGenerationStrategy.ALWAYS_GENERATION)
    }
}