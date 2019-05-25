package baseballgame.model

import spock.lang.Specification
import spock.lang.Unroll

class NumbersTest extends Specification {

    def "Numbers must have valid size"() {
        when:
        Numbers.of(numbers)

        then:
        thrown(IllegalArgumentException.class)

        where:
        numbers      | _
        [1, 2]       | _
        [1, 2, 3, 4] | _
    }

    def "Elements of Numbers must be unique"() {
        when:
        Numbers.of(numbers)

        then:
        thrown(IllegalArgumentException.class)

        where:
        numbers   | _
        [1, 1, 2] | _
        [1, 1, 1] | _
    }

    @Unroll
    def "get match result from other numbers : #numbers -> #expected"() {
        given:
        def target = Numbers.of([1, 2, 3])

        when:
        def actual = target.match(Numbers.of(numbers))

        then:
        actual.containsAll(expected)

        where:
        numbers   || expected
        [1, 2, 3] || ["STRIKE", "STRIKE", "STRIKE"]
        [1, 2, 4] || ["STRIKE", "STRIKE", "OUT"]
        [1, 4, 5] || ["STRIKE", "OUT"   , "OUT"]
        [1, 3, 4] || ["STRIKE", "BALL"  , "OUT"]
        [1, 3, 2] || ["STRIKE", "BALL"  , "BALL"]
        [3, 1, 2] || ["BALL"  , "BALL"  , "BALL"]
        [4, 5, 6] || ["OUT"   , "OUT"   , "OUT"]
    }
}
