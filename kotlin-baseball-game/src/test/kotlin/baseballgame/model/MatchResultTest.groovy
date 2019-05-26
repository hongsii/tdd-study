package baseballgame.model

import spock.lang.Specification

class MatchResultTest extends Specification {

    def "find from property"() {
        expect:
        MatchResult.of(hasNumber, isSameCondition) == expected

        where:
        hasNumber | isSameCondition || expected
        true      | true            || MatchResult.STRIKE
        true      | false           || MatchResult.BALL
        false     | false           || MatchResult.OUT
    }
}
