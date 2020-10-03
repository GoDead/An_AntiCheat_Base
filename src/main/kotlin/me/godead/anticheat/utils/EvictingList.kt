package me.godead.anticheat.utils

import java.util.*

class EvictingList<T> : LinkedList<T> {

    private val maxSize: Int

    constructor(maxSize: Int) {
        this.maxSize = maxSize
    }

    constructor(c: Collection<T>?, maxSize: Int) : super(c) {
        this.maxSize = maxSize
    }

    override fun add(element: T): Boolean {
        if (size >= maxSize) removeFirst()
        return super.add(element)
    }
}