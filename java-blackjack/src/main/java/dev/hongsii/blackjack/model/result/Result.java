package dev.hongsii.blackjack.model.result;

public interface Result {

    double getWinningMoneyRate();
    String getResult();

    default int calculateWinningMoney(int bettingMoney) {
        return (int) Math.round(bettingMoney * getWinningMoneyRate());
    }
}
