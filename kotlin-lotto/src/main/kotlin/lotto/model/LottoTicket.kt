package lotto.model

class LottoTicket(private val lottos: List<Lotto>) {

    fun win(winningLotto: WinningLotto): List<WinningResult> = lottos.map { winningLotto.win(it) }.toList()
}