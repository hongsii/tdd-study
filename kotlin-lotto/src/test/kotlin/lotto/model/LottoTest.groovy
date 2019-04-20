package lotto.model

import spock.lang.Specification
import spock.lang.Unroll

class LottoTest extends Specification {

    @Unroll
    def "must have #size numbers"() {
        given:
        def numbers = 1..size

        when:
        def lotto = new Lotto(numbers)

        then:
        lotto != null

        where:
        size       | _
        Lotto.SIZE | _
    }

    def "number must be unique"() {
        given:
        def numbers = [1, 2, 3, 4, 5, 5]

        when:
        new Lotto(numbers)

        then:
        thrown(IllegalArgumentException)
    }

    @Unroll
    def "if Lotto doesn't have required numbers, fail to create [size: #size]"() {
        given:
        def numbers = (size > 0) ? 1..size : null

        when:
        new Lotto(numbers)

        then:
        thrown IllegalArgumentException

        where:
        size | _
        0    | _
        5    | _
        7    | _
    }

    def "match with other Lotto"() {
        given:
        def lotto = new Lotto(1..6)
        def other = new Lotto(numbers)

        when:
        def actual = lotto.matchWith(other)

        then:
        actual == matchCount

        where:
        numbers            | matchCount
        [1, 2, 3, 4, 5, 6] | 6
        [1, 2, 3, 4, 5, 7] | 5
        [1, 2, 3, 4, 7, 8] | 4
    }
}