package racinggame.model

data class Position(val driver: String, val position: Int) {

    companion object {

        @JvmStatic
        fun of(car: Car) = car.run { Position(driver, getPosition()) }
    }
}