package dev.hongsii.model;

public class Answer {

    private int currentGuessCount;
    private BaseballNumber answer;

    public Answer(BaseballNumber answer) {
        this.answer = answer;
    }

    public GuessResult guess(BaseballNumber baseballNumber) {
        return new GuessResult(++currentGuessCount, answer.match(baseballNumber));
    }

    @Override
    public String toString() {
        return answer.toString();
    }
}
