package lotto.model

object LottoSimulator {

    fun simulate(simulationOption: SimulationOption): SimulationResult {
        val winningLotto = LottoGenerator.generateWinningLotto()
        val lottoTicket = LottoTicket(LottoGenerator.generate(simulationOption.lottoCount))

        val winningResultAnalyzer = WinningResultAnalyzer(lottoTicket.win(winningLotto))

        return SimulationResult(
            winningSummary = winningResultAnalyzer.getWinningCountFromResult(),
            winningMoney = winningResultAnalyzer.calculateWinningMoney(),
            profitRate = winningResultAnalyzer.calculateProfitRate(simulationOption.pricePerLotto)
        )
    }
}

data class SimulationOption(val lottoCount: Int, val pricePerLotto: Int)
data class SimulationResult(val winningSummary: Map<WinningResult, WinningSummary>, val winningMoney: Int, val profitRate: Double)