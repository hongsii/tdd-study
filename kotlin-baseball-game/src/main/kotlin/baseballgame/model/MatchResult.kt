package baseballgame.model

enum class MatchResult(val hasNumber: Boolean, val isSameLocation: Boolean) {

    STRIKE(true, true),
    BALL(true, false),
    OUT(false, false);

    companion object {

        @JvmStatic
        fun of(hasNumber: Boolean, isSameLocation: Boolean) =
            values()
                .first { it.hasNumber == hasNumber && it.isSameLocation == isSameLocation }
    }
}