package blackjack.model

class Deck(val cards: List<Card>) {

    companion object {

        fun ofSingle(): Deck = Suit.values()
            .flatMap { Rank.zipWith(it) }
            .map { Card.of(it) }
            .let { Deck(it) }
    }
}
