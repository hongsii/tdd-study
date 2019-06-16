package racinggame.model

class RacingGame(private val cars: List<Car>) {

    constructor(countOfCars: Int) : this(List(countOfCars) { Car() })

    fun start(trialCount: Int): RacingResult =
        (1..trialCount)
            .map { moveOneTime() }
            .let { RacingResult(it) }

    private fun moveOneTime(): MoveResult =
        cars
            .map { it.move(random()) }
            .let { MoveResult(it) }

    private fun random() = Car.CONDITION_RANGE.random()
}