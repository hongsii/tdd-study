package dev.hongsii.io;

import dev.hongsii.model.Answer;
import dev.hongsii.model.GuessResult;

public class BaseballGameOutput {

    public static void printGuessResult(GuessResult guessResult) {
        System.out.println("결과 : " + guessResult.getDisplayResult());
        System.out.println();
    }

    public static void printGameInfo(Answer answer, GuessResult guessResult) {
        System.out.println("\n=== 게임 결과 ===");
        System.out.println("정답 : " + answer);
        System.out.println("시도횟수 : " + guessResult.getGuessCount());
    }
}
