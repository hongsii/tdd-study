package racinggame

import racinggame.model.Car

fun main() {
    println("자동차 대수는 몇 대 인가요?")
    val countOfCar = readLine()!!.toInt()
    val cars = (0..countOfCar).map { Car() }.toList()

    println("시도할 회수는 몇 회 인가요?")
    val trialCount = readLine()!!.toInt()
    repeat(trialCount) {
        val positions = cars.map { it.move((Car.MIN_CONDITION..Car.MAX_CONDITION).random()) }
        println("=".repeat(trialCount))
        positions.forEach { println("-".repeat(it)) }
        println("=".repeat(trialCount))
        println()
    }
}