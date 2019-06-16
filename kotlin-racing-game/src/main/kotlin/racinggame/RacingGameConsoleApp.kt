package racinggame

import racinggame.OutputUtils.displayRacingResult
import racinggame.console.InputUtils.inputCountOfCars
import racinggame.console.InputUtils.inputTrialCount
import racinggame.model.RacingGame

fun main() {
    val countOfCars = inputCountOfCars()
    val trialCount = inputTrialCount()

    val racingGame = RacingGame(countOfCars)
    val racingResult = racingGame.start(trialCount)
    displayRacingResult(racingResult)
}