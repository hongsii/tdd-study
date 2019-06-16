package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    @DisplayName("If race is over, the result has same size as trial count with same count of cars")
    fun start() {
        val countOfCars = 3
        val trialCount = 5

        val racingResult = RacingGame(countOfCars).start(trialCount)

        val moveResults = racingResult.moveResults
        assertThat(moveResults)
            .filteredOn { it.positions.size == countOfCars }
            .hasSize(trialCount)
    }
}