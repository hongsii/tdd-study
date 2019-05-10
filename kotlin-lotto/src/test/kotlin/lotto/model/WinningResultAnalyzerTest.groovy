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
        summary.get(WinningResult.FIRST) == new WinningSummary(1, 25)
        summary.get(WinningResult.SECOND) == new WinningSummary(2, 50)
        summary.get(WinningResult.THIRD) == new WinningSummary(1, 25)
        summary.get(WinningResult.FOURTH) == new WinningSummary(0, 0)
        summary.get(WinningResult.FIFTH) == new WinningSummary(0, 0)
        summary.get(WinningResult.NONE) == new WinningSummary(0, 0)
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

    def "calcuate profit rate from results"() {
        given:
        def analyzer = new WinningResultAnalyzer(winningResults)
        def pricePerLotto = 5000

        when:
        def actual = analyzer.calculateProfitRate(pricePerLotto)

        then:
        actual == profitRate

        where:
        winningResults                                                | profitRate
        [WinningResult.FIFTH, WinningResult.FIFTH]                    | 0
        [WinningResult.NONE, WinningResult.FOURTH]                    | 400
        [WinningResult.NONE, WinningResult.NONE, WinningResult.FIFTH] | -67
    }
}
