package baseballgame.model

data class Numbers(val numbers: List<Number>) {

    init {
        val size = numbers.size
        require(SIZE == size) { "$SIZE 개의 숫자가 필요합니다." }
        require(numbers.distinct().size == size) { "중복되지 않은 숫자만 가능합니다." }
    }

    fun match(other: Numbers): List<MatchResult> =
        numbers.withIndex()
            .map { other.matchNumber(it) }
            .toList()

    private fun matchNumber(numberWithIndex: IndexedValue<Number>): MatchResult =
        numberWithIndex.run {
            val hasNumber = numbers.contains(value)
            val isSameLocation = numbers[index] == value
            MatchResult.of(hasNumber, isSameLocation)
        }

    companion object {

        const val SIZE = 3

        @JvmStatic
        fun from(numberString: String) =
            numberString
                .toCharArray()
                .filter { it.isDigit() }
                .map { it.toString().toInt() }
                .let { of(it) }

        @JvmStatic
        fun of(rawNumbers: List<Int>) =
            rawNumbers
                .map { Number.of(it) }
                .toList()
                .let { Numbers(it) }
    }
}