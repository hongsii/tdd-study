package laddergame.domain.info

data class Results(private val results: List<String>) : Indexer<String> {

    override fun get(index: Int): String = results[index]

    fun getResults() = results

    companion object {

        fun fromComma(rawResults: String): Results =
            rawResults.split(",")
                .run { Results(this) }
    }
}