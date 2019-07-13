package laddergame.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
}