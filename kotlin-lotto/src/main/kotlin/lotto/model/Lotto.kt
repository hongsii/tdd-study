package lotto.model

class Lotto(numbers: List<Number>) {

    private val numbers: List<Number> = numbers.sorted().toList()

    init {
        require(numbers.size == SIZE) { "$SIZE 개의 숫자가 필요합니다." }
        require(numbers.distinct().size == SIZE) { "중복되지 않은 $SIZE 개의 숫자가 필요합니다."}
    }

    fun matchWith(other: Lotto) = numbers.intersect(other.numbers).count()
    fun contains(number: Number) = numbers.contains(number)
    fun getNumbers() = numbers

    companion object {
        const val SIZE = 6
    }
}
