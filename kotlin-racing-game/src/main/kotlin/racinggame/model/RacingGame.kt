package racinggame.model

class RacingGame(private val cars: List<Car>) {

    constructor(countOfCar: Int) : this(List(countOfCar) { Car() })

    fun moveOneTime() = cars.map { it.move(random()) }.toList()

    private fun random() = (Car.MIN_CONDITION..Car.MAX_CONDITION).random()
}