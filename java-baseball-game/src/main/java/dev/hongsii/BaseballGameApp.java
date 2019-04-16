package dev.hongsii;

import dev.hongsii.io.BaseballGameInput;
import dev.hongsii.io.BaseballGameOutput;
import dev.hongsii.model.BaseballGameConsole;
import dev.hongsii.model.GuessResult;

public class BaseballGameApp {

    public static void main(String[] args) {
        int numberCount = BaseballGameInput.inputNumberCount();

        BaseballGameConsole baseballGameConsole = new BaseballGameConsole(numberCount);
        GuessResult guessResult;
        do {
            guessResult = baseballGameConsole.play(BaseballGameInput.inputGuessNumber());
            BaseballGameOutput.printGuessResult(guessResult);
        } while (!guessResult.isGameOver());

        BaseballGameOutput.printGameInfo(baseballGameConsole.getAnswer(), guessResult);
    }
}
