package racinggame

import racinggame.model.RacingGame

fun main() {
    println("자동차 대수는 몇 대 인가요?")
    val countOfCar = readLine()!!.toInt()
    val racingGame = RacingGame(countOfCar)

    println("시도할 회수는 몇 회 인가요?")
    val trialCount = readLine()!!.toInt()
    repeat(trialCount) {
        val positions = racingGame.moveOneTime()
        println("=".repeat(trialCount))
        positions.forEach { println("-".repeat(it)) }
        println("=".repeat(trialCount))
        println()
    }
}