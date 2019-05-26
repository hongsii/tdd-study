package baseballgame.model

class BaseballGame(
    private var trialCount: Int,
    private val answer: Numbers
) {

    constructor(answer: Numbers) : this(0, answer)

    fun guess(rawGuessNumbers: String): GuessResult {
        val guessNumbers = Numbers.from(rawGuessNumbers)
        return GuessResult(guessNumbers.numbers, answer.match(guessNumbers))
            .also { trialCount++ }
    }
}