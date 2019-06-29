package laddergame.domain

class Player(name: String) {

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { "플레이어의 이름은 $MIN_NAME_LENGTH~$MAX_NAME_LENGTH 자 까지 가능합니다." }
    }

    companion object {
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
    }
}
