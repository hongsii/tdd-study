package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import dev.hongsii.blackjack.model.hand.Ready;
import dev.hongsii.blackjack.model.result.Lose;
import dev.hongsii.blackjack.model.result.Push;
import dev.hongsii.blackjack.model.result.Result;
import dev.hongsii.blackjack.model.result.Win;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Dealer implements CardReceiver, CardMatcher {

    private static final int SCORE_FOR_RECEIVE = 17;

    private Hand hand;

    public static Dealer create() {
        return of(Ready.ready());
    }

    public static Dealer of(Hand hand) {
        return new Dealer(hand);
    }

    @Override
    public void receive(Card card) {
        if (!canReceive()) {
            throw new IllegalStateException("더 이상 카드를 받을 수 없습니다.");
        }
        hand = hand.add(card);
    }

    @Override
    public boolean canReceive() {
        return hand.getTotalScore() < SCORE_FOR_RECEIVE;
    }

    @Override
    public void clear() {
        hand = Ready.ready();
    }

    @Override
    public Result match(Hand target) {
        if (target.isBust()) {
            return Lose.getInstance();
        }
        if (hand.isBust()) {
            return Win.from(target);
        }
        if (target.isSameScore(hand)) {
            return Push.getInstance();
        }
        return (target.isLargerScore(hand)) ? Win.from(target) : Lose.getInstance();
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getTotalScore() {
        return hand.getTotalScore();
    }
}
