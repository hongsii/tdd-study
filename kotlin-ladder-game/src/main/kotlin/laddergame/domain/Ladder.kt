package laddergame.domain

import laddergame.exception.InvalidHeightOfLadderException

class Ladder private constructor(private val ladderLines: List<LadderLine>) {

    init {
        if (ladderLines.size < MIN_HEIGHT) throw InvalidHeightOfLadderException()
    }

    fun move(startIndex: Int): Int = moveOnLadderLine(START_LADDER_HEIGHT_INDEX, startIndex)

    private fun moveOnLadderLine(currentHeightIndex: Int, currentIndex: Int): Int =
        if (currentHeightIndex == ladderLines.size) currentIndex
        else moveOnLadderLine(currentHeightIndex.inc(),ladderLines[currentHeightIndex].move(currentIndex))

    fun getLines() = ladderLines

    companion object {

        const val MIN_HEIGHT = 1
        const val START_LADDER_HEIGHT_INDEX = 0

        fun of(height: Int, width: Int, generationStrategy: GenerationStrategy = RandomGenerationStrategy()): Ladder =
            (1..height)
                .map { LadderLine.of(width, generationStrategy) }
                .run { Ladder(this) }
    }
}
