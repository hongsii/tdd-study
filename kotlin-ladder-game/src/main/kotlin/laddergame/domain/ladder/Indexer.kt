package laddergame.domain.ladder

interface Indexer<T> {

    operator fun get(index: Int): T
}