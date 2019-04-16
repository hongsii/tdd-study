package dev.hongsii.model;

public class BaseballGameConsole {

    private Answer answer;

    public BaseballGameConsole(int numberCount) {
        this(new Answer(new UniqueNumberGenerator().generate(numberCount)));
    }

    public BaseballGameConsole(Answer answer) {
        this.answer = answer;
    }

    public GuessResult play(String rawNumbers) {
        return answer.guess(BaseballNumber.from(rawNumbers));
    }

    public Answer getAnswer() {
        return answer;
    }
}
