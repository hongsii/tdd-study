package laddergame.domain

import laddergame.exception.InvalidHeightOfLadderException

class Ladder private constructor(private val ladderLines: List<LadderLine>) {

    init {
        if (ladderLines.size < MIN_HEIGHT) throw InvalidHeightOfLadderException()
    }

    fun getLines() = ladderLines

    companion object {

        const val MIN_HEIGHT = 1

        fun of(height: Int, width: Int, generationStrategy: GenerationStrategy): Ladder =
            (1..height)
                .map { LadderLine.of(width, generationStrategy) }
                .run { Ladder(this) }
    }
}
