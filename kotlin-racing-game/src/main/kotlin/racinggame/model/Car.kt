package racinggame.model

class Car(val driver: String, private var position: Int = START_POSITION) {

    fun move(value: Int): Int =
        if (canMove(value)) {
            ++position
        } else {
            position
        }

    private fun canMove(value: Int): Boolean {
        if (value !in CONDITION_RANGE) {
            throw IllegalArgumentException("$MIN_CONDITION ~ $MAX_CONDITION 사이의 값만 가능합니다.")
        }
        return value >= MOVE_CONDITION
    }

    fun getPosition() = position

    companion object {

        const val START_POSITION = 0

        const val MOVE_CONDITION = 4
        const val MAX_CONDITION = 9
        const val MIN_CONDITION = 0

        val CONDITION_RANGE = MIN_CONDITION..MAX_CONDITION
    }
}
