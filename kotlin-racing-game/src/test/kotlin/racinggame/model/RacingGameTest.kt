package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {

    @DisplayName("Ready by drivers")
    @ParameterizedTest(name = "[{index}] : drivers = {arguments}")
    @ValueSource(strings = [
        "ryan,muzi,con",
        "ryan, muzi, con",
        "ryan , muzi , con",
        "ryan  ,   muzi  ,  con"
    ])
    fun readyByDrivers(drivers: String) {
        val racingGame = RacingGame.ready(drivers)

        assertThat(racingGame.cars)
            .hasSize(3)
            .extracting("driver").containsExactly("ryan", "muzi", "con")
    }

    @Test
    @DisplayName("If race is over, the result has same size as trial count with same count of cars")
    fun start() {
        val cars = listOf(Car("ryan"), Car("muzi"), Car("con"))
        val trialCount = 5
        val racingGame = RacingGame(cars)

        val racingResult = racingGame.start(trialCount)

        assertThat(racingResult.allPositionRecord)
            .filteredOn { it.positions.size == cars.size }
            .hasSize(trialCount)
    }
}