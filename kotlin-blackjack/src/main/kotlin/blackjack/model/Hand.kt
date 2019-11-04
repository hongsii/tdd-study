package blackjack.model

class Hand(private val cards: MutableList<Card> = mutableListOf()) {

    fun add(card: Card) = cards.add(card)
}