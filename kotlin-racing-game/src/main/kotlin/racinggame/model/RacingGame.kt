package racinggame.model

class RacingGame(val cars: List<Car>) {

    fun start(trialCount: Int): RacingResult =
        (1..trialCount)
            .map { moveAll() }
            .let { RacingResult(it) }

    private fun moveAll(): PositionRecord =
        cars
            .map {
                it.move(Car.CONDITION_RANGE.random())
            }
            .let { PositionRecord(it) }

    companion object {

        private val COMMA_SEPARATOR = """\s*,\s*""".toRegex()

        @JvmStatic
        fun ready(driversWithComma: String): RacingGame =
            driversWithComma
                .split(COMMA_SEPARATOR)
                .map { Car(it) }
                .let { RacingGame(it) }
    }
}