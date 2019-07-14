package laddergame.domain

data class Point(private val direction: Direction) {

    fun next(generationStrategy: GenerationStrategy): Point =
        if (direction.isRight())
            Point(direction.reverse())
        else
            ofRightOrStraight(generationStrategy)



    fun getDirection() = direction

    fun move(index: Int) = direction.move(index)

    companion object {

        fun ofRightOrStraight(generationStrategy: GenerationStrategy) =
            if (generationStrategy.canGenerate())
                Point(Direction.RIGHT)
            else
                Point(Direction.STRAIGHT)
    }
}