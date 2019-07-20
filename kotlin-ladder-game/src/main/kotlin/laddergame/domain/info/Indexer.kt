package laddergame.domain.info

interface Indexer<T> {

    operator fun get(index: Int): T
}