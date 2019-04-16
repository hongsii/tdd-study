package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import dev.hongsii.blackjack.model.result.Result;

public interface CardMatcher {

    Result match(Hand hand);
}
