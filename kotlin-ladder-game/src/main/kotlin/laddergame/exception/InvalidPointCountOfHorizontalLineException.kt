package laddergame.exception

import laddergame.domain.HorizontalLine

class InvalidPointCountOfHorizontalLineException(message: String) : IllegalArgumentException(message) {

    constructor() : this("시다리의 가로선은 최소 ${HorizontalLine.MIN_POINT_COUNT}개 이상의 점으로 구성되어야 합니다.")
}