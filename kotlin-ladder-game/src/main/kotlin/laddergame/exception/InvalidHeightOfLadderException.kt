package laddergame.exception

import laddergame.domain.ladder.Ladder

class InvalidHeightOfLadderException(message: String) : IllegalArgumentException(message) {

    constructor() : this("높이가 최소 ${Ladder.MIN_HEIGHT} 이상인 사다리만 생성할 수 있습니다.")
}