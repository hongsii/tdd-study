package lotto.model

import spock.lang.Specification

class WinningResultAnalyzerTest extends Specification {

    def "get winning count from results"() {
        given:
        def winningResults = [WinningResult.FIRST, WinningResult.SECOND, WinningResult.SECOND, WinningResult.THIRD]
        def analyzer = new WinningResultAnalyzer(winningResults)

        when:
        def summary = analyzer.getWinningCountFromResult()

        then:
        summary.get(WinningResult.FIRST) == 1
        summary.get(WinningResult.SECOND) == 2
        summary.get(WinningResult.THIRD) == 1
        summary.get(WinningResult.FOURTH) == 0
        summary.get(WinningResult.FIFTH) == 0
        summary.get(WinningResult.NONE) == 0
    }

    def "calculate winning money from results"() {
        given:
        def winningResults = [WinningResult.FIRST, WinningResult.SECOND]
        def analyzer = new WinningResultAnalyzer(winningResults)

        when:
        def winningMoney = analyzer.calculateWinningMoney()

        then:
        winningMoney == WinningResult.FIRST.winningMoney + WinningResult.SECOND.winningMoney
    }
}
