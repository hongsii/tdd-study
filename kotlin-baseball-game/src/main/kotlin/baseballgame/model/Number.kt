package baseballgame.model

data class Number private constructor(val value: Int) {

    init {
        require(value in MIN..MAX) { "$MIN~$MAX 사이의 숫자만 가능합니다."}
    }

    companion object {

        const val MIN = 0
        const val MAX = 9

        private val CACHE: MutableMap<Int, Number> = mutableMapOf()

        @JvmStatic
        fun of(value: Int): Number = CACHE.getOrPut(value) { Number(value) }
    }
}
