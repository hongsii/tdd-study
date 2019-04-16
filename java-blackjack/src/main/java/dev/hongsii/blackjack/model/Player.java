package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import dev.hongsii.blackjack.model.hand.Ready;
import dev.hongsii.blackjack.model.result.Result;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player implements CardReceiver {

    @Getter
    private int number;
    private Hand hand;
    private Money money;

    public static Player create(int number) {
        return of(number, Ready.ready());
    }

    public static Player of(int number, Hand hand) {
        return of(number, hand, Money.ofDefault());
    }

    public static Player of(Hand hand, Money money) {
        return new Player(1, hand, money);
    }

    public static Player of(int number, Hand hand, Money money) {
        return new Player(number, hand, money);
    }

    @Override
    public void receive(Card card) {
        hand = hand.add(card);
    }

    @Override
    public boolean canReceive() {
        return !hand.isGameOver();
    }

    @Override
    public void clear() {
        hand = Ready.ready();
    }

    public void applyWinningMoney(int winningMoney) {
        money.plus(winningMoney);
    }

    public Result winTo(CardMatcher cardMatcher) {
        return cardMatcher.match(hand);
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getMoney() {
        return money.getMoney();
    }

    public int getTotalScore() {
        return hand.getTotalScore();
    }
}
