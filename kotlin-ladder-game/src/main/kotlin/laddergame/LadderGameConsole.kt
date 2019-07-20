package laddergame

import laddergame.LadderGameConsole.generateLadder
import laddergame.LadderGameConsole.play
import laddergame.LadderGameConsole.printGeneratedLadder
import laddergame.domain.LadderGame
import laddergame.domain.info.Players
import laddergame.domain.info.Results
import laddergame.domain.ladder.Ladder
import laddergame.domain.ladder.strategy.RandomGenerationStrategy
import laddergame.view.InputView
import laddergame.view.OutputView

fun main() {
    val ladderGame = generateLadder()
    printGeneratedLadder(ladderGame)
    play(ladderGame)
}

object LadderGameConsole {

    fun generateLadder(): LadderGame {
        val players = inputUniquePlayers()
        val results = Results.fromComma(InputView.inputResults())

        val height = InputView.inputHeight()
        val ladder = Ladder.of(height = height, width = players.size(), generationStrategy = RandomGenerationStrategy())
        return LadderGame(players = players, results = results, ladder = ladder)
    }

    private fun inputUniquePlayers(): Players {
        while (true) {
            try {
                return Players.fromComma(InputView.inputPlayers())
            } catch (e: Exception) {
                OutputView.printError(e)
            }
        }
    }

    fun printGeneratedLadder(ladderGame: LadderGame) {
        OutputView.printLadder(ladderGame)
    }

    fun play(ladderGame: LadderGame) {
        while (true) {
            val playerName = InputView.inputExpectedResult()
            if (playerName == "all") {
                OutputView.printTotalPlayResult(ladderGame.moveAll())
                break
            }

            printPlayResult(ladderGame, playerName)
        }
    }

    private fun printPlayResult(ladderGame: LadderGame, playerName: String) {
        try {
            val playResult = ladderGame.move(playerName)
            OutputView.printPlayResult(playResult)
        } catch (e: Exception) {
            OutputView.printError(e)
        }
    }
}
