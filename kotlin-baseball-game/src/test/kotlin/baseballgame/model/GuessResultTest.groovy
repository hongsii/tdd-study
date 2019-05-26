package baseballgame.model

import spock.lang.Specification

import static baseballgame.model.MatchResult.BALL
import static baseballgame.model.MatchResult.STRIKE

class GuessResultTest extends Specification {

    def "If results is all strike, it is win"() {
        given:
        def guessResult = new GuessResult(
                [1,2,3],
                [STRIKE, STRIKE, STRIKE]
        )

        expect:
        guessResult.win()

        where:
        results                  | expected
        [STRIKE, STRIKE, STRIKE] | true
        [STRIKE, STRIKE, BALL]   | false
    }
}