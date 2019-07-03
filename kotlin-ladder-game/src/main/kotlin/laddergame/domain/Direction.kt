package laddergame.domain

enum class Direction(
    private val left: Boolean,
    private val right: Boolean
) {

    LEFT(true, false),
    STRAIGHT(false, false),
    RIGHT(false, true);

    fun reverse() =
        if (isSide())
            of(!left, !right)
        else
            STRAIGHT

    fun isSide() = this == LEFT || this == RIGHT

    companion object {

        @JvmStatic
        fun of(left: Boolean, right: Boolean): Direction =
            values()
                .find { it.left == left && it.right == right }
                ?: throw IllegalArgumentException("잘못된 방향입니다.")
    }
}