package lotto.model

import spock.lang.Specification
import spock.lang.Unroll

class WinningLottoTest extends Specification {

    @Unroll
    def "must have #size numbers and bonus number"() {
        given:
        def lotto = LottoTest.createLotto(1..size)
        def bonusNumber = new Number(size + 1)

        when:
        def winningLotto = new WinningLotto(lotto, bonusNumber)

        then:
        winningLotto != null

        where:
        size       | _
        Lotto.SIZE | _
    }

    def "if bonus number doesn't exist, fail to create"() {
        given:
        def lotto = LottoTest.createLotto(1..Lotto.SIZE)

        when:
        new WinningLotto(lotto, null)


        then:
        thrown(IllegalArgumentException)
    }

    def "if numbers of Lotto include bonus number, fail to create"() {
        given:
        def lotto = LottoTest.createLotto(1..Lotto.SIZE)
        def bonusNumber = new Number(1)

        when:
        new WinningLotto(lotto, bonusNumber)

        then:
        thrown(IllegalArgumentException)
    }

    def "can match with Lotto"() {
        given:
        def lotto = LottoTest.createLotto(1..Lotto.SIZE)
        def bonusNumber = new Number(7)
        def winningLotto = new WinningLotto(lotto, bonusNumber)

        when:
        def actual = winningLotto.win(LottoTest.createLotto(numbers))

        then:
        actual == expected

        where:
        numbers             | expected
        [1, 2, 3, 4, 5, 6]  | WinningResult.FIRST
        [1, 2, 3, 4, 5, 7]  | WinningResult.SECOND
        [1, 2, 3, 4, 5, 9]  | WinningResult.THIRD
        [1, 2, 3, 4, 8, 9]  | WinningResult.FOURTH
        [1, 2, 3, 7, 8, 9]  | WinningResult.FIFTH
        [1, 2, 7, 8, 9, 10] | WinningResult.NONE
    }
}
