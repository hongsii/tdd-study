package racinggame

import racinggame.model.MoveResult
import racinggame.model.RacingGame
import racinggame.model.RacingResult

fun main() {
    val countOfCar = inputNumberWithMessage("자동차 대수는 몇 대 인가요?")
    val racingGame = RacingGame(countOfCar)

    val trialCount = inputNumberWithMessage("시도할 회수는 몇 회 인가요?")
    val racingResult = racingGame.start(trialCount)
    displayRacingResult(racingResult)
}

private fun inputNumberWithMessage(displayMessage: String): Int {
    while (true) {
        try {
            println(displayMessage)
            return readLine(

            )!!.toInt()
        } catch (e: Exception) {
            println("잘못 입력하셨습니다.")
        }
    }
}

private fun displayRacingResult(racingResult: RacingResult) {
    val trackSize = racingResult.getTrialCount()
    val moveResults = racingResult.moveResults
    moveResults.forEach {
        displayTrack(trackSize)
        displayPositionOfCars(it)
        displayTrack(trackSize)
        println()
    }
}

private fun displayPositionOfCars(moveResult: MoveResult) {
    moveResult.positions
        .map { "-".repeat(it) }
        .forEach { println(it) }
}

private fun displayTrack(size: Int) {
    println("=".repeat(size))
}