package laddergame.domain

import laddergame.domain.ladder.LadderTest
import laddergame.domain.ladder.Player
import laddergame.domain.ladder.Players
import laddergame.domain.ladder.Results
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LadderGameTest {

    private lateinit var ladderGame: LadderGame

    @BeforeEach
    internal fun setUp() {
        ladderGame = LadderGame(
            ladder = LadderTest.THREE_BY_THREE_ALWAYS_GENERATION,
            players = Players.fromComma("hong,jin,hoho"),
            results = Results(listOf("꽝", "1000", "500"))
        )
    }

    @Test
    fun start() {
        val ladderResult = ladderGame.moveAll()

        assertThat(ladderResult).isEqualTo(
            TotalPlayResult(mapOf(
                Player("hong") to "1000",
                Player("jin") to "꽝",
                Player("hoho") to "500"
            ))
        )
    }

    @Test
    fun move() {
        val playerName = "hong"

        val ladderResult = ladderGame.move(playerName)

        assertThat(ladderResult).isEqualTo(PlayResult(playerName, "1000"))
    }
}