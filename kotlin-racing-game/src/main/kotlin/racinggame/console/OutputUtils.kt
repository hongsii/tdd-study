package racinggame

import racinggame.model.PositionRecord
import racinggame.model.RacingResult

object OutputUtils {

    fun displayRacingResult(racingResult: RacingResult) {
        val positionRecord = racingResult.allPositionRecord
        positionRecord.forEach {
            displayPositionOfCars(it)
            println()
        }
    }
    private fun displayPositionOfCars(positionRecord: PositionRecord) {
        positionRecord.positions
            .forEach { println("${it.driver} : ${"-".repeat(it.position)}") }
    }

    fun displayWinners(racingResult: RacingResult) =
        racingResult.getWinners()
            .joinToString(", ")
            .also { println("$it 가 최종 우승했습니다.") }
}
