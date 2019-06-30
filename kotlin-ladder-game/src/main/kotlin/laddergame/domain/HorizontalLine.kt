package laddergame.domain

import laddergame.exception.InvalidPointCountOfHorizontalLineException

class HorizontalLine(private val points: List<Point>) {

    init {
        if (points.size < MIN_POINT_COUNT) throw InvalidPointCountOfHorizontalLineException()
    }

    companion object {

        const val MIN_POINT_COUNT = 2
    }
}
