package dev.hongsii.blackjack.io;

import dev.hongsii.blackjack.model.Card;

public class CardCharacter {

    private Suit suit;
    private Rank rank;

    public CardCharacter(Card card) {
        suit = Suit.valueOf(card.getSuit().name());
        rank = Rank.valueOf(card.getRank().name());
    }

    @Override
    public String toString() {
        return "[" + suit.character + rank.character + "]";
    }

    public enum Suit {

        CLUBS(Card.Suit.CLUBS, "︎♣︎"),
        DIAMONDS(Card.Suit.DIAMONDS, "♦︎"),
        HEARTS(Card.Suit.HEARTS, "♥︎"),
        SPADES(Card.Suit.SPADES, "♠︎");

        private Card.Suit suit;
        private String character;

        Suit(Card.Suit suit, String character) {
            this.suit = suit;
            this.character = character;
        }
    }

    public enum Rank {

        ACE(Card.Rank.ACE, "A"),
        TWO(Card.Rank.TWO, "2"),
        THREE(Card.Rank.THREE, "3"),
        FOUR(Card.Rank.FOUR, "4"),
        FIVE(Card.Rank.FIVE, "5"),
        SIX(Card.Rank.SIX, "6"),
        SEVEN(Card.Rank.SEVEN, "7"),
        EIGHT(Card.Rank.EIGHT, "8"),
        NINE(Card.Rank.NINE, "9"),
        TEN(Card.Rank.TEN, "10"),
        JACK(Card.Rank.JACK, "J"),
        QUEEN(Card.Rank.QUEEN, "Q"),
        KING(Card.Rank.KING, "K");

        private Card.Rank rank;
        private String character;

        Rank(Card.Rank rank, String character) {
            this.rank = rank;
            this.character = character;
        }
    }
}
