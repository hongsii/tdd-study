package laddergame.domain

interface Indexer<T> {

    operator fun get(index: Int): T
}