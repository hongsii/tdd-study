package racinggame

import racinggame.console.InputUtils.inputDriversWithComma
import racinggame.console.InputUtils.inputTrialCount
import racinggame.console.OutputUtils.displayRacingResult
import racinggame.console.OutputUtils.displayWinners
import racinggame.model.RacingGame

fun main() {
    val drivers = inputDriversWithComma()
    val trialCount = inputTrialCount()

    val racingGame = RacingGame.ready(drivers)
    val racingResult = racingGame.start(trialCount)
    displayRacingResult(racingResult)
    displayWinners(racingResult)
}
