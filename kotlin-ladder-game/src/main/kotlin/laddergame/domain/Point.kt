package laddergame.domain

data class Point(private val direction: Direction) {

    fun getDirection() = direction

    companion object {

        fun first(hasSideDirection: Boolean) =
            if (hasSideDirection)
                Point(Direction.RIGHT)
            else
                Point(Direction.STRAIGHT)
    }
}