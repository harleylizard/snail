package com.harleylizard.gladys

@JvmRecord
data class Pair<L, R>(val l: L, val r: R) {

    companion object {

        infix fun <L, R> L.and(r: R): Pair<L, R> = Pair(this, r)
    }
}