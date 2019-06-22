package racinggame.model

data class Position(val driver: String, val position: Int) {

    fun isSamePosition(other: Position) = position == other.position
}