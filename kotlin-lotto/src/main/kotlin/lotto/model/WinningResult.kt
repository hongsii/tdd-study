package lotto.model

enum class WinningResult(private val matchResult: MatchResult) {

    FIRST(6),
    SECOND(5, true),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NONE(0);

    constructor(matchCount: Int) : this(matchCount, false)
    constructor(matchCount: Int, matchBonusNumber: Boolean) : this(MatchResult(matchCount, matchBonusNumber))

    fun isSameResult(matchResult: MatchResult): Boolean = if (this.matchResult.matchBonusNumber) {
        this.matchResult == matchResult
    } else {
        this.matchResult.isSameMatchCount(matchResult)
    }

    companion object {
        fun of(matchResult: MatchResult) = values().firstOrNull { it.isSameResult(matchResult) } ?: NONE
    }
}
