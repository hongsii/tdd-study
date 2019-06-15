package racinggame

import racinggame.model.RacingGame

fun main() {
    val countOfCar = inputNumberWithMessage("자동차 대수는 몇 대 인가요?")
    val racingGame = RacingGame(countOfCar)

    val trialCount = inputNumberWithMessage("시도할 회수는 몇 회 인가요?")
    repeat(trialCount) {
        val positions = racingGame.moveOneTime()

        println()
        displayTrack(trialCount)
        displayPositionOfCars(positions)
        displayTrack(trialCount)
        println()
    }
}

private fun inputNumberWithMessage(displayMessage: String): Int {
    while (true) {
        try {
            println(displayMessage)
            return readLine()!!.toInt()
        } catch (e: Exception) {
            println("잘못 입력하셨습니다.")
        }
    }
}

private fun displayPositionOfCars(positions: List<Int>) {
    positions.forEach { println("-".repeat(it)) }
}

private fun displayTrack(trialCount: Int) {
    println("=".repeat(trialCount))
}