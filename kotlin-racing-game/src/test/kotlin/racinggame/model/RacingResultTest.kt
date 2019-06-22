package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingResultTest {

    @Test
    fun getWinners() {
        val winnerName = "ryan"
        val positionRecord = PositionRecord(
            listOf(
                Position(winnerName, 5),
                Position("muzi", 4),
                Position("con", 3)
            )
        )
        val racingResult = RacingResult(listOf(positionRecord))

        val winners = racingResult.getWinners()

        assertThat(winners)
            .hasSize(1)
            .containsOnly(winnerName)
    }

    @Test
    @DisplayName("Get winners from last result")
    fun getWinnersFromLastResult() {
        val winnerName = "ryan"
        val positionRecord1 = PositionRecord(
            listOf(
                Position(winnerName, 4),
                Position("muzi", 3),
                Position("con", 3)
            )
        )
        val positionRecord2 = PositionRecord(
            listOf(
                Position(winnerName, 5),
                Position("muzi", 4),
                Position("con", 3)
            )
        )
        val racingResult = RacingResult(listOf(positionRecord1, positionRecord2))

        val winners = racingResult.getWinners()

        assertThat(winners)
            .hasSize(1)
            .containsOnly(winnerName)
    }
}