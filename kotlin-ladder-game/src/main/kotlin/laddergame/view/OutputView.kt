package laddergame.view

import laddergame.domain.Direction
import laddergame.domain.Ladder
import laddergame.domain.LadderLine
import laddergame.domain.Player

object OutputView {

    private const val MAX_PRINT_LENGTH = Player.MAX_NAME_LENGTH
    private const val VERTICAL_CHARACTER = "|"
    private const val LINE_CHARACTER = "-"
    private const val EMPTY_SPACE = " "
    private const val LINE_SEPARATOR = "\n"

    fun printPlayers(players: List<String>) =
        players.joinToString(EMPTY_SPACE) { padWhiteSpace(it) }
                .also { println(it) }

    private fun padWhiteSpace(value: String) = value.padStart(MAX_PRINT_LENGTH, EMPTY_SPACE.single())

    fun printLadder(ladder: Ladder) =
        ladder.getLines().joinToString(LINE_SEPARATOR) {
            EMPTY_SPACE.repeat(MAX_PRINT_LENGTH) + VERTICAL_CHARACTER + makeLineString(it)
        }
            .also { println(it) }

    private fun makeLineString(ladderLine: LadderLine): String =
        ladderLine.getPoints().joinToString(VERTICAL_CHARACTER) {
            when(it.getDirection()) {
                Direction.RIGHT -> LINE_CHARACTER
                else -> EMPTY_SPACE
            }.repeat(MAX_PRINT_LENGTH)
        }
}