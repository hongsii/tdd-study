package lotto.model

data class Number(val number: Int) : Comparable<Number> {

    init {
        require(number in MIN..MAX) { "숫자는 $MIN ~ $MAX 까지 가능합니다." }
    }

    companion object {
        const val MIN = 1
        const val MAX = 45
    }

    override fun compareTo(other: Number) = number.compareTo(other.number)
}
