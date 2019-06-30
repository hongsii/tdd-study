package racinggame.model

data class Position(
    val driver: String,
    val position: Int
) : Comparable<Position> {

    fun isSamePosition(other: Position) = position == other.position

    override fun compareTo(other: Position) = position.compareTo(other.position)
}