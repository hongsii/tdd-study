package laddergame.domain.ladder

import laddergame.domain.ladder.strategy.BooleanGenerationStrategy
import laddergame.domain.ladder.strategy.GenerationStrategy
import laddergame.exception.InvalidSizeOfLadderLineException

class LadderLine private constructor(private val points: List<Point>) {

    fun move(index: Int): Int {
        if (index !in (MIN_INDEX until points.size))
            throw IllegalArgumentException("이동 범위를 벗어났습니다.")

        return points[index].move(index)
    }

    fun getPoints(): List<Point> = points

    companion object {

        const val MIN_INDEX = 0
        const val MIN_POINT_COUNT = 2

        private val lastPointGenerationStrategy =
            BooleanGenerationStrategy.NEVER_GENERATION

        fun of(width: Int, generationStrategy: GenerationStrategy): LadderLine {
            if (width < MIN_POINT_COUNT) throw InvalidSizeOfLadderLineException()

            return initializeWithFirstPoint(generationStrategy)
                .apply {
                    generateMiddlePoints(width, this, generationStrategy)
                    generateLastPoint(this)
                }
                .let { LadderLine(it) }
        }

        private fun initializeWithFirstPoint(generationStrategy: GenerationStrategy): MutableList<Point> =
            mutableListOf(Point.ofRightOrStraight(generationStrategy))

        private fun generateMiddlePoints(width: Int, points: MutableList<Point>, generationStrategy: GenerationStrategy) {
            val sizeOfMiddlePoint = width - MIN_POINT_COUNT
            repeat(sizeOfMiddlePoint) {
                generateFromBeforePoint(
                    points,
                    generationStrategy
                )
            }
        }

        private fun generateLastPoint(points: MutableList<Point>) =
            generateFromBeforePoint(
                points,
                lastPointGenerationStrategy
            )

        private fun generateFromBeforePoint(points: MutableList<Point>, generationStrategy: GenerationStrategy): Point =
            points.last()
                .run { next(generationStrategy) }
                .apply { points.add(this) }
    }
}
