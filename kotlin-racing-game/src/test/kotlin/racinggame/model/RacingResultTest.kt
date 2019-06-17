package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingResultTest {

    @Test
    fun getWinners() {
        val winner = Car("ryan", 5)
        val positionRecord = PositionRecord.from(
            listOf(
                winner,
                Car("muzi", 4),
                Car("con", 3)
            )
        )
        val racingResult = RacingResult(listOf(positionRecord))

        val winners = racingResult.getWinners()

        assertThat(winners)
            .hasSize(1)
//            .containsOnly(winner)
    }
}