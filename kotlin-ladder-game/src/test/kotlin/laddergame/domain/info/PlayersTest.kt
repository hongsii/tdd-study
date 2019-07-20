package laddergame.domain.info

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class PlayersTest {

    @Test
    fun fromComma() {
        val rawPlayers = "1,2,3"

        val players = Players.fromComma(rawPlayers)

        assertThat(players.getPlayers())
            .hasSize(3)
            .containsExactly(
                Player("1"),
                Player("2"),
                Player("3")
            );
    }

    @ParameterizedTest
    @EmptySource
    @MethodSource("minPlayers")
    fun create_fail(invalidPlayers: List<Player>) {
        assertThatIllegalArgumentException()
            .isThrownBy { Players(invalidPlayers) }
    }

    @ParameterizedTest(name = "index of {0} is {1}")
    @CsvSource(
        "1st, 0",
        "2nd, 1",
        "3rd, 2"
    )
    fun findIndexByPlayerName(playerName: String, expected: Int) {
        val rawPlayers = "1st,2nd,3rd"

        val players = Players.fromComma(rawPlayers)

        assertThat(players.findIndexByPlayerName(playerName)).isEqualTo(expected)
    }

    @Test
    fun findIndexByPlayerName_fail() {
        val rawPlayers = "1st,2nd,3rd"

        val players = Players.fromComma(rawPlayers)

        assertThatIllegalArgumentException()
            .isThrownBy { players.findIndexByPlayerName("fail") }
    }

    companion object {

        @JvmStatic
        fun minPlayers(): Stream<Arguments> =
            Stream.of(
                arguments((1 until Players.MIN_PLAYER_COUNT).map {
                    Player(
                        it.toString()
                    )
                })
            )
    }
}