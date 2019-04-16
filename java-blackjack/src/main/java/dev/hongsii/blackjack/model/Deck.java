package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Deck {

    public static final int DEFAULT_SIZE = 52;

    private Stack<Card> deck;

    public static Deck ofSingle() {
        return of(createCards());
    }

    public static Deck ofDouble() {
        Stack<Card> totalDeck = Stream.of(createCards(), createCards())
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(Stack::new));
        return of(totalDeck);
    }

    public static Deck of(Stack<Card> deck) {
        return new Deck(deck);
    }

    private static Stack<Card> createCards() {
        return Arrays.stream(Card.Suit.values())
                    .flatMap(suit -> Arrays.stream(Card.Rank.values()).map(rank -> Card.of(suit, rank)))
                    .collect(Collectors.toCollection(Stack::new));
    }

    public Card draw() {
        if (size() == 0) {
            throw new IllegalStateException("카드가 존재하지 않습니다.");
        }
        return deck.pop();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int size() {
        return deck.size();
    }
}
