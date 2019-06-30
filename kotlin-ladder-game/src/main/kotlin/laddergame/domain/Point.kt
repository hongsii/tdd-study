package laddergame.domain

data class Point(private val direction: Direction) {

    fun next(directionStrategy: () -> Direction) =
        if (direction.isSide()) {
            Point(direction.reverse())
        } else {
            from(directionStrategy)
        }

    companion object {

        fun first(hasSideDirection: Boolean) =
            if (hasSideDirection)
                Point(Direction.RIGHT)
            else
                Point(Direction.STRAIGHT)

        fun from(directionStrategy: () -> Direction) = Point(directionStrategy())
    }
}