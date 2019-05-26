package baseballgame.console

import baseballgame.model.GuessResult
import baseballgame.model.MatchResult
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

        fun displayWinningMessage() = println("승리했습니다!")
        fun displayGuessResult(guessResult: GuessResult) =
            guessResult
                .getCountOfEachMatchResult()
                .entries
                .joinToString("") { formatResult(it) }
                .also {
                    println("결과 : $it")
                }

        private fun formatResult(matchResult: Map.Entry<MatchResult, Int>) =
            when (matchResult.key) {
                STRIKE -> "S"
                BALL -> "B"
                OUT -> "O"
            } + matchResult.value
    }
}