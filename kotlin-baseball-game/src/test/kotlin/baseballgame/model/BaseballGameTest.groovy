package baseballgame.model

import spock.lang.Specification

import java.util.stream.Collectors

import static baseballgame.model.MatchResult.STRIKE

class BaseballGameTest extends Specification {

    def "guess answer"() {
        given:
        def guessNumbers = Numbers.of([1, 2, 3])
        def answer = guessNumbers
        def baseballGame = new BaseballGame(answer)

        when:
        def rawGuessNumbers = guessNumbers.numbers.stream()
                .map { it.value.toString() }
                .collect(Collectors.joining(""))
        def guessResult = baseballGame.guess(rawGuessNumbers)

        then:
        guessResult == new GuessResult(guessNumbers.numbers, [STRIKE, STRIKE, STRIKE])
    }
}