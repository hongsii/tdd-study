package baseballgame.model

data class Numbers(val numbers: List<Number>) {

    init {
        val size = numbers.size
        require(SIZE == size) { "$SIZE 개의 숫자만 가능합니다." }
        require(numbers.distinct().size == size) { "중복된 숫자가 존재합니다." }
    }

    companion object {

        const val SIZE = 3

        @JvmStatic
        fun from(rawNumbers: String) = rawNumbers
            .toCharArray()
            .map { it.toString().toInt() }
            .let { of(it) }

        @JvmStatic
        fun of(rawNumbers: List<Int>) = rawNumbers
            .map { Number.of(it) }
            .toList()
            .let { Numbers(it) }
    }

    fun match(other: Numbers): List<MatchResult> {
        return numbers.withIndex()
            .map { other.matchByEach(it) }
            .toList()
    }

    private fun matchByEach(number: IndexedValue<Number>): MatchResult {
        val hasNumber = numbers.contains(number.value)
        val isSameLocation = numbers[number.index] == number.value
        return MatchResult.of(hasNumber, isSameLocation)
    }
}