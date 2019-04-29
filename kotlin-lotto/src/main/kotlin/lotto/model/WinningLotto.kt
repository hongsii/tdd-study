package lotto.model

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: Number) {

    init {
        require(!winningLotto.contains(bonusNumber)) { "보너스 번호가 중복되었습니다." }
    }

    fun win(lotto: Lotto): WinningResult {
        val matchCount = winningLotto.matchWith(lotto)
        val matchBonusNumber = lotto.contains(bonusNumber)
        return WinningResult.of(MatchResult(matchCount, matchBonusNumber))
    }

    fun getLotto() = winningLotto
    fun getBonusNumber() = bonusNumber
}