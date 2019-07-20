package laddergame.domain.ladder

enum class Direction(
    private val left: Boolean,
    private val right: Boolean,
    private val moveValue: Int
) {

    LEFT(true, false, -1),
    STRAIGHT(false, false, 0),
    RIGHT(false, true, 1);

    fun reverse() =
        if (isRight() || isLeft())
            of(!left, !right)
        else
            STRAIGHT

    fun isRight() = this == RIGHT

    private fun isLeft() = this == LEFT

    fun move(index: Int) = index + moveValue

    companion object {

        @JvmStatic
        fun of(left: Boolean, right: Boolean): Direction =
            values()
                .find { it.left == left && it.right == right }
                ?: throw IllegalArgumentException("잘못된 방향입니다.")
    }
}