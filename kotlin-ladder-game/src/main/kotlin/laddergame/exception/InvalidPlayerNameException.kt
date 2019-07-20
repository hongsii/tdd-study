package laddergame.exception

import laddergame.domain.info.Player

class InvalidPlayerNameException(message: String) : IllegalArgumentException(message) {

    constructor() : this("플레이어의 이름은 ${Player.MIN_NAME_LENGTH}~${Player.MAX_NAME_LENGTH}자 까지 가능합니다.")
}