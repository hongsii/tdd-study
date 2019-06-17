package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class PositionRecordTest {

    @DisplayName("Find winners")
    @ParameterizedTest(name = "[{index}] : winners {arguments}")
    @MethodSource
    fun getWinners(nameOfWinners: List<String>) {
        val loserPosition = 1
        val losers = listOf(
            Position("loser1", loserPosition),
            Position("loser2", loserPosition)
        )
        val winners = nameOfWinners.map { Position(it, loserPosition + 1) }
        val positionRecord = PositionRecord(winners + losers)

        val actual = positionRecord.getWinners()

        assertThat(actual).isEqualTo(nameOfWinners)
    }

    companion object Fixture {

        @JvmStatic
        fun getWinners() = listOf(
            arguments(listOf("ryan")),
            arguments(listOf("ryan", "muzi"))
        )
    }
}
