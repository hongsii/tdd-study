package lotto

import lotto.model.*
import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    val simulationOperation = SimulationOption(
        lottoCount = inputLottoCount(),
        pricePerLotto = inputPricePerLotto()
    )
    val simulationResult = LottoSimulator.simulate(simulationOperation)
    displaySimulationResult(simulationResult)
}

fun inputLottoCount(): Int = inputNumber("# 로또 개수 : ")
fun inputPricePerLotto(): Int = inputNumber("# 한장당 가격 : ")
fun inputNumber(message: String): Int = input(message) { readLine()!!.toInt() }
private fun <T> input(message: String, operation: () -> T): T {
    while (true) {
        try {
            print(message)
            return operation.invoke()
        } catch (e: Exception) {
            println("잘못된 입력입니다.")
        }
    }
}

fun displaySimulationResult(simulationResult: SimulationResult) = println(
        """
        |
        |# 시뮬레이션 결과
        |-------------
        |${makeSummaryToString(simulationResult.winningSummary)}
        |-------------
        |> 당첨 금액 : ${simulationResult.winningMoney}
        |> 수익률 : ${formatToPercentage(simulationResult.profitRate, 0)}
        |
        """.trimMargin()
    )
private fun makeSummaryToString(winningCounter: Map<WinningResult, WinningSummary>) =
    winningCounter.entries.joinToString("\n") {
            (key, value) ->"${WinningResultCharacter.valueOf(key.toString())} : ${value.winningCount} (${formatToPercentage(value.percentage, 2)})"
    }

private fun formatToPercentage(value: Double, point: Int): String = "#".repeat(point)
    .run {
        if (isEmpty()) this else ".$this"
    }
    .run {
        "0$this'%'"
    }
    .run {
        DecimalFormat(this).run {
            roundingMode = RoundingMode.HALF_UP
            format(value)
        }
    }

enum class WinningResultCharacter(private val character: String) {

    FIRST("1등"), SECOND("2등"), THIRD("3등"), FOURTH("4등"), FIFTH("5등"), NONE("꽝!");

    override fun toString() = character
}
