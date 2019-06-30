package racinggame.console

import racinggame.model.PositionRecorder
import racinggame.model.RacingResult

object OutputUtils {

    fun displayRacingResult(racingResult: RacingResult) {
        val positionRecord = racingResult.racingResult
        positionRecord.forEach {
            displayPositionOfCars(it)
            println()
        }
    }

    private fun displayPositionOfCars(positionRecorder: PositionRecorder) {
        positionRecorder.positions
            .forEach { println("${it.driver} : ${"-".repeat(it.position)}") }
    }

    fun displayWinners(racingResult: RacingResult) =
        racingResult.getWinners()
            .joinToString(", ")
            .also { println("$it 가 최종 우승했습니다.") }
}
