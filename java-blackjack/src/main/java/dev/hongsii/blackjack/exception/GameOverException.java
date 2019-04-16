package dev.hongsii.blackjack.exception;

public class GameOverException extends RuntimeException {

    public GameOverException() {
        super("게임이 종료되었습니다.");
    }
}
