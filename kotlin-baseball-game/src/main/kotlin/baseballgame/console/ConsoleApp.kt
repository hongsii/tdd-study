package baseballgame.console

import baseballgame.model.BaseballGame
import baseballgame.model.Numbers
import baseballgame.model.RandomNumberGenerator

fun main() {
    val answer = RandomNumberGenerator.generateWith(Numbers.SIZE)
    val baseballGame = BaseballGame(answer)

    while (true) {
        val guessNumbers = ConsoleInput.inputGuessNumbers()
        val guessResult = baseballGame.guess(guessNumbers)
        if (guessResult.win()) {
            ConsoleOutput.displayWinningMessage()
            break
        } else {
            ConsoleOutput.displayGuessResult(guessResult)
        }
    }
}