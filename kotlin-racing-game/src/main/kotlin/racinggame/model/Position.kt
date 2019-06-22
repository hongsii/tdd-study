package racinggame.model

data class Position(val driver: String, val position: Int) {

    fun isSamePosition(other: Position): Boolean = position == other.position

    companion object {

        @JvmStatic
        fun of(car: Car) = car.run { Position(driver, getPosition()) }
    }
}