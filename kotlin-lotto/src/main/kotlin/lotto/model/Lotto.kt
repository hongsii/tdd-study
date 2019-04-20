package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == SIZE) { "$SIZE 개의 숫자가 필요합니다." }
        require(numbers.distinct().size == SIZE) { "중복되지 않은 $SIZE 개의 숫자가 필요합니다."}
    }

    fun matchWith(other: Lotto): Int {
        return numbers.intersect(other.numbers).count()
    }

    companion object {
        const val SIZE = 6
    }
}
