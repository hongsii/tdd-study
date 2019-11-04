package blackjack.model

class Player(
    val hand: List<Card>,
    val drawStrategy: DrawStrategy
)