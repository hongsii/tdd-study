package lotto.model

import spock.lang.Specification
import spock.lang.Unroll

class NumberTest extends Specification {

    def "must be in the range"() {
        expect:
        new Number(1) == new Number(1)
    }

    @Unroll
    def "if number is not in the range, fail create [number: #number]"() {
        when:
        new Number(number)

        then:
        thrown(IllegalArgumentException)

        where:
        number         | _
        Number.MIN - 1 | _
        Number.MAX + 1 | _
    }
}
