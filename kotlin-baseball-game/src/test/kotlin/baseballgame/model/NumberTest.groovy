package baseballgame.model

import baseballgame.model.Number
import spock.lang.Specification

class NumberTest extends Specification {

    def "Number must be in valid range"() {
        when:
        Number.of(number)

        then:
        notThrown()

        where:
        number     | _
        Number.MIN | _
        Number.MAX | _
    }

    def "If number is in invalid range, fail to create"() {
        when:
        Number.of(number)

        then:
        thrown(IllegalArgumentException)

        where:
        number         | _
        Number.MIN - 1 | _
        Number.MAX + 1 | _
    }

    def "Number can be cached"() {
        expect:
        Number.of(Number.MIN) == Number.of(Number.MIN)
        new Number(Number.MIN) != new Number(Number.MIN)
    }
}
