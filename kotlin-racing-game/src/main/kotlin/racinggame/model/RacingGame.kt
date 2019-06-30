package racinggame.model

class RacingGame(val cars: List<Car>) {

    init {
        require(cars.isNotEmpty()) { "경기를 시작할 자동차가 없습니다." }
    }

    fun start(trialCount: Int): RacingResult =
        (1..trialCount)
            .map { moveAll() }
            .let { RacingResult(it) }

    private fun moveAll(): PositionRecorder =
        cars
            .map {
                it.move(Car.CONDITION_RANGE.random())
            }
            .let { PositionRecorder(it) }

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