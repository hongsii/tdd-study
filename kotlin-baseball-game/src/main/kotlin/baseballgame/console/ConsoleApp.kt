package baseballgame.console

import baseballgame.model.BaseballGame
import baseballgame.model.Numbers
import baseballgame.model.RandomNumberGenerator

fun main() {
    val answer = RandomNumberGenerator.generateWith(Numbers.SIZE)
    val baseballGame = BaseballGame(answer)

    while (true) {
        try {
            val guessNumbers = ConsoleInput.inputGuessNumbers()
            val guessResult = baseballGame.guess(guessNumbers)
            if (guessResult.win()) {
                ConsoleOutput.displayWinningMessage(baseballGame.history)
                break
            } else {
                ConsoleOutput.displayGuessResult(guessResult)
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }
}