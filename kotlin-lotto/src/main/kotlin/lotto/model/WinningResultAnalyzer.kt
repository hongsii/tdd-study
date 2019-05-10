package lotto.model

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

class WinningResultAnalyzer(private val winningResults: List<WinningResult>) {

    fun getWinningCountFromResult(): Map<WinningResult, WinningSummary> {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.roundingMode = RoundingMode.HALF_UP
        return WinningResult.values()
            .map { key -> key to winningResults.count { key == it } }
            .map { it.first to WinningSummary(it.second, decimalFormat.format((it.second.toDouble() / winningResults.size) * 100)) }
            .toMap()
    }

    fun calculateWinningMoney(): Int {
        return winningResults.sumBy { it.winningMoney }
    }

    fun calculateProfitRate(pricePerLotto: Int): Int {
        val totalBuyingMoney = winningResults.size * pricePerLotto
        val winningMoney = calculateWinningMoney().toDouble()
        return (((winningMoney - totalBuyingMoney) / totalBuyingMoney) * 100).roundToInt()
    }
}

data class WinningSummary(val winningCount: Int, val percentage: Double) {

    constructor(winningCount: Int, percentage: String) : this(winningCount, percentage.toDouble())
}