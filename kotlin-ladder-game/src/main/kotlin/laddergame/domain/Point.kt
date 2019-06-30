package laddergame.domain

data class Point(private val direction: Direction) {

    fun next(directionStrategy: () -> Direction): Point =
        Point(direction.next(directionStrategy))

    companion object {

        fun first(hasSideDirection: Boolean) =
            if (hasSideDirection)
                Point(Direction.RIGHT)
            else
                Point(Direction.STRAIGHT)
    }
}