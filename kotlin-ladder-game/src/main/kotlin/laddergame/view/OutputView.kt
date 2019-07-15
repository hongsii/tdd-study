package laddergame.view

import laddergame.domain.*

object OutputView {

    private const val MAX_PRINT_LENGTH = Player.MAX_NAME_LENGTH
    private const val VERTICAL_CHARACTER = "|"
    private const val START_LINE_CHARACTER = "||"
    private const val LINE_CHARACTER = "-"
    private const val EMPTY_SPACE = " "
    private const val LINE_SEPARATOR = "\n"

    fun printLadder(ladderGame: LadderGame) {
        printMessage(
            """
            $START_LINE_CHARACTER${printPlayers(ladderGame.players)}
            $START_LINE_CHARACTER${printLadder(ladderGame.ladder)}
            $START_LINE_CHARACTER${printResults(ladderGame.results)}
            """.trimMargin(START_LINE_CHARACTER)
        )
    }

    private fun printPlayers(players: Players) =
        players.getPlayers().joinToString(EMPTY_SPACE) { padWhiteSpace(it.name) }

    private fun padWhiteSpace(value: String) = value.padStart(MAX_PRINT_LENGTH, EMPTY_SPACE.single())

    private fun printLadder(ladder: Ladder) =
        ladder.getLines().joinToString(separator = LINE_SEPARATOR + START_LINE_CHARACTER) {
            EMPTY_SPACE.repeat(MAX_PRINT_LENGTH) + VERTICAL_CHARACTER + makeLineString(it)
        }

    private fun makeLineString(ladderLine: LadderLine): String =
        ladderLine.getPoints().joinToString(VERTICAL_CHARACTER) {
            when(it.getDirection()) {
                Direction.RIGHT -> LINE_CHARACTER
                else -> EMPTY_SPACE
            }.repeat(MAX_PRINT_LENGTH)
        }

    private fun printResults(results: Results) =
        results.getResults().joinToString(EMPTY_SPACE) { padWhiteSpace(it) }

    fun printPlayResult(playResult: PlayResult) =
        printPlayResult(playResult.result)

    fun printTotalPlayResult(totalPlayResult: TotalPlayResult) =
        totalPlayResult.getAllResult()
            .entries.joinToString(LINE_SEPARATOR) { "${it.key.name} : ${it.value}" }
            .also { printMessage(it) }

    fun printError(exception: Exception) = printMessage(exception.message)

    private fun printPlayResult(playResult: String) = printMessage("실행 결과$LINE_SEPARATOR$playResult")
    private fun printMessage(message: String?) = println("$LINE_SEPARATOR$message$LINE_SEPARATOR")
}