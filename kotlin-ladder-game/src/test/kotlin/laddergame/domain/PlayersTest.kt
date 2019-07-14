package laddergame.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
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
            .containsExactly(Player("1"), Player("2"), Player("3"));
    }

    @ParameterizedTest
    @EmptySource
    @MethodSource("minPlayers")
    fun create_fail(invalidPlayers: List<Player>) {
        assertThatIllegalArgumentException()
            .isThrownBy { Players(invalidPlayers) }
    }

    companion object {

        @JvmStatic
        fun minPlayers(): Stream<Arguments> =
            Stream.of(
                arguments((1 until Players.MIN_PLAYER_COUNT).map { Player(it.toString()) })
            )
    }
}