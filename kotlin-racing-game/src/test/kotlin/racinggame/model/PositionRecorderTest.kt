package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class PositionRecorderTest {

    @DisplayName("Find winners")
    @ParameterizedTest(name = "[{index}] : winners {arguments}")
    @MethodSource
    fun getWinners(positions: List<Position>, nameOfWinners: List<String>) {
        val positionRecord = PositionRecorder(positions)

        val actual = positionRecord.getWinners()

        assertThat(actual).isEqualTo(nameOfWinners)
    }

    companion object Fixture {

        @JvmStatic
        fun getWinners() = listOf(
            arguments(emptyList<Position>(), emptyList<String>()),
            arguments(
                listOf(
                    Position("ryan", 5),
                    Position("muzi", 4),
                    Position("con", 3)
                ),
                listOf("ryan")
            ),
            arguments(
                listOf(
                    Position("ryan", 5),
                    Position("muzi", 5),
                    Position("con", 3)
                ),
                listOf("ryan", "muzi")
            )
        )
    }
}
