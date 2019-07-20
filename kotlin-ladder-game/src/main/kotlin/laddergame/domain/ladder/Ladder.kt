package laddergame.domain.ladder

import laddergame.domain.ladder.strategy.GenerationStrategy
import laddergame.domain.ladder.strategy.RandomGenerationStrategy
import laddergame.exception.InvalidHeightOfLadderException

class Ladder private constructor(private val ladderLines: List<LadderLine>) {

    init {
        if (ladderLines.size < MIN_HEIGHT) throw InvalidHeightOfLadderException()
    }

    fun move(pointIndex: Int): Int = moveOnLadderLine(START_LINE_INDEX, pointIndex)

    private fun moveOnLadderLine(lineIndex: Int, pointIndex: Int): Int =
        if (isLastLine(lineIndex)) pointIndex
        else moveOnLadderLine(lineIndex + 1, ladderLines[lineIndex].move(pointIndex))

    private fun isLastLine(linIndex: Int) = linIndex == ladderLines.size

    fun getLines() = ladderLines

    companion object {

        const val MIN_HEIGHT = 1
        const val START_LINE_INDEX = 0

        fun of(height: Int, width: Int, generationStrategy: GenerationStrategy = RandomGenerationStrategy()): Ladder =
            (1..height)
                .map { LadderLine.of(width, generationStrategy) }
                .run { Ladder(this) }
    }
}
