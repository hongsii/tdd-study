package racinggame.model

class Car(private var position: Int = 0) {

    fun move(value: Int): Int =
        if (canMove(value)) {
            ++position
        } else {
            position
        }

    private fun canMove(value: Int): Boolean {
        if (value !in MIN_CONDITION..MAX_CONDITION) {
            throw IllegalArgumentException("$MIN_CONDITION ~ $MAX_CONDITION 사이의 값만 가능합니다.")
        }
        return value >= MOVE_CONDITION
    }

    companion object {

        const val MOVE_CONDITION = 4
        const val MAX_CONDITION = 9
        const val MIN_CONDITION = 0
    }
}
