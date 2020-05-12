package com.faiz.sistempakar.model

data class Result(
    var text: String,
    var percentage: Float
) : Comparable<Result> {
    override fun compareTo(other: Result): Int {
        return other.percentage.compareTo(this.percentage)
    }
    override fun toString(): String {
        val p = "%.2f".format(percentage)
        return "$p% $text"
    }
}