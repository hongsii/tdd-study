package laddergame.domain

data class Point(private val direction: Direction) {

    fun next(generationStrategy: GenerationStrategy): Point =
        if (direction.isSide())
            Point(direction.reverse())
        else
            ofRightOrStraight(generationStrategy)

    companion object {

        fun ofRightOrStraight(generationStrategy: GenerationStrategy) =
            if (generationStrategy.canGenerate())
                Point(Direction.RIGHT)
            else
                Point(Direction.STRAIGHT)
    }
}