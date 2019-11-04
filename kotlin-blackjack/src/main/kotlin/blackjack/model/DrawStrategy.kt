package blackjack.model

interface DrawStrategy {

    fun draw(hand: List<Card>)
}