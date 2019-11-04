package blackjack.model

data class Card(
    val suit: Suit,
    val rank: Rank
) {

    companion object {

        fun of(card: Pair<Suit, Rank>) = Card(card.first, card.second)
    }
}
