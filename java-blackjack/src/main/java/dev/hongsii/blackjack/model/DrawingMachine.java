package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DrawingMachine {

    private Deck deck;

    public static DrawingMachine of(Deck deck) {
        return new DrawingMachine(deck);
    }

    public void draw(int drawCount, CardReceiver cardReceiver) {
        for (int count = 1; count <= drawCount; count++) {
            drawToCardReceiver(cardReceiver);
        }
    }

    private void drawToCardReceiver(CardReceiver cardReceiver) {
        if (!cardReceiver.canReceive()) {
            throw new IllegalStateException("더 이상 카드를 받을 수 없습니다.");
        }
        cardReceiver.receive(deck.draw());
    }
}
