package racinggame

import racinggame.model.MoveResult
import racinggame.model.RacingResult

object OutputUtils {

    fun displayRacingResult(racingResult: RacingResult) {
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
}
