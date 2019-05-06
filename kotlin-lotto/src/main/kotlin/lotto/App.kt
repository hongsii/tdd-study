package lotto

import lotto.model.LottoSimulator
import lotto.model.SimulationOption
import lotto.model.SimulationResult
import lotto.model.WinningResult

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
        |> 수익률 : ${simulationResult.profitRate}%
        |
        """.trimMargin()
    )
private fun makeSummaryToString(winningCounter: Map<WinningResult, Int>) = winningCounter.entries
    .map { "${WinningResultCharacter.valueOf(it.key.toString())} : ${it.value}" }
    .joinToString("\n")

enum class WinningResultCharacter(val character: String) {

    FIRST("1등"), SECOND("2등"), THIRD("3등"), FOURTH("4등"), FIFTH("5등"), NONE("꽝!");

    override fun toString() = character
}
