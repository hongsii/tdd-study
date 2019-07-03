package laddergame.domain

import laddergame.exception.InvalidSizeOfLadderLineException

class LadderLine private constructor(private val points: List<Point>) {

    fun getPoints(): List<Point> = points

    companion object {

        const val MIN_POINT_COUNT = 2

        private val lastPointGenerationStrategy = BooleanGenerationStrategy.NEVER_GENERATION

        fun of(width: Int, generationStrategy: GenerationStrategy): LadderLine {
            if (width < MIN_POINT_COUNT) throw InvalidSizeOfLadderLineException()

            val points = initializeWithFirstPoint(generationStrategy)
            generateMiddlePoints(width, points, generationStrategy)
            generateLastPoint(points)
            return LadderLine(points)
        }

        private fun initializeWithFirstPoint(generationStrategy: GenerationStrategy): MutableList<Point> =
            mutableListOf(Point.ofRightOrStraight(generationStrategy))

        private fun generateMiddlePoints(width: Int, points: MutableList<Point>, generationStrategy: GenerationStrategy) {
            val sizeOfMiddlePoint = width - MIN_POINT_COUNT
            repeat(sizeOfMiddlePoint) { generateFromBeforePoint(points, generationStrategy) }
        }

        private fun generateLastPoint(points: MutableList<Point>) =
            generateFromBeforePoint(points, lastPointGenerationStrategy)

        private fun generateFromBeforePoint(points: MutableList<Point>, generationStrategy: GenerationStrategy): Point =
            points.last()
                .run { next(generationStrategy) }
                .apply { points.add(this) }
    }
}
