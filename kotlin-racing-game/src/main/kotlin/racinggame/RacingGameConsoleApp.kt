package racinggame

import racinggame.OutputUtils.displayRacingResult
import racinggame.OutputUtils.displayWinners
import racinggame.console.InputUtils.inputDriversWithComma
import racinggame.console.InputUtils.inputTrialCount
import racinggame.model.RacingGame

fun main() {
    val drivers = inputDriversWithComma()
    val trialCount = inputTrialCount()

    val racingGame = RacingGame.ready(drivers)
    val racingResult = racingGame.start(trialCount)
    displayRacingResult(racingResult)
    displayWinners(racingResult)
}
