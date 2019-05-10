package lotto.model

class LottoTicket(private val lottos: List<Lotto>) {

    fun win(winningLotto: WinningLotto): WinningResultAnalyzer {
        val winningResults = lottos
            .map { winningLotto.win(it) }
            .toList()
        return WinningResultAnalyzer(winningResults)
    }
}