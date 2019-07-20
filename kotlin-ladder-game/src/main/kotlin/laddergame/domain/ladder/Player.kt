package laddergame.domain.ladder

import laddergame.exception.InvalidPlayerNameException

data class Player(val name: String) {

    init {
        if (name.length !in MIN_NAME_LENGTH..MAX_NAME_LENGTH) throw InvalidPlayerNameException()
    }

    companion object {
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
    }
}
