package blackjack.model

enum class Rank {

    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    ACE, JACK, QUEEN, KING;

    companion object {

        fun zipWith(suit: Suit) = values().map { Pair(suit, it) }
    }
}
