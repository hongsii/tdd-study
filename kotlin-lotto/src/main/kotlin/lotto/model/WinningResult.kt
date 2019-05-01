package lotto.model

enum class WinningResult(private val matchResult: MatchResult, val winningMoney: Int) {

    FIRST(6, 1_000_000),
    SECOND(5, true, 500_000),
    THIRD(5, 200_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    constructor(matchCount: Int, winningMoney: Int) : this(matchCount, false, winningMoney)
    constructor(matchCount: Int, matchBonusNumber: Boolean, winningMoney: Int) : this(MatchResult(matchCount, matchBonusNumber), winningMoney)

    companion object {
        fun of(matchResult: MatchResult) = values().firstOrNull { it.isSameResult(matchResult) } ?: NONE
    }

    fun isSameResult(matchResult: MatchResult): Boolean = if (this.matchResult.matchBonusNumber) {
        this.matchResult == matchResult
    } else {
        this.matchResult.isSameMatchCount(matchResult)
    }
}
