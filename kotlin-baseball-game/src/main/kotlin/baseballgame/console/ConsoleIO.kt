package baseballgame.console

import baseballgame.model.GuessResult
import baseballgame.model.MatchResult.*

class ConsoleInput {

    companion object {

        fun inputGuessNumbers(): String = input("숫자 예측 : ") { readLine()!! }

        private fun <T> input(message: String, operation: () -> T): T {
            while (true) {
                try {
                    print(message)
                    return operation.invoke()
                } catch (e: Exception) {
                    println("잘못된 입력입니다.")
                }
            }
        }
    }
}

class ConsoleOutput {

    companion object {

        fun displayWinningMessage(history: List<GuessResult>) =
            println("\n\n승리했습니다!")
                .also { displayHeader() }
                .also {
                    history
                        .withIndex()
                        .map { "${"%2d".format(it.index + 1)} : ${formatTrialNumbers(it.value)} -> ${formatResult(it.value)}" }
                        .forEach(::println)
                }
                .also { displayHeader() }
        fun displayGuessResult(guessResult: GuessResult) =
            println("결과 : ${formatResult(guessResult)}")

        private fun displayHeader() = println("======================")

        private fun formatTrialNumbers(guessResult: GuessResult) =
            guessResult
                .trialNumbers
                .joinToString("") { it.value.toString() }

        private fun formatResult(guessResult: GuessResult) =
            guessResult
                .getCountOfEachMatchResult()
                .entries
                .joinToString("") {
                    when (it.key) {
                        STRIKE -> "S"
                        BALL -> "B"
                        OUT -> "O"
                    } + it.value
                }
    }
}