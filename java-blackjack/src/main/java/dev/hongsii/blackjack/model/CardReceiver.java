package dev.hongsii.blackjack.model;

public interface CardReceiver {

    void receive(Card card);
    boolean canReceive();
    void clear();
}
