package rule110

fun rule110() {
    val data = mutableListOf(0, 0, 0, 1, 1, 1, 0, 1, 1, 1)
    val N = 100
    val size = N + data.size + 1
    println(data.joinToString("") { if (it == 0) " " else "_" }.padStart(size))
    for (n in 0..N) {
        var i = data[0]
        var j = data[1]
        data.add(1)
        data.drop(2).forEachIndexed { index, k ->
            data[index + 1] = rule110(i, j , k)
            i = j
            j = k
        }
        println(data.joinToString("") { if (it == 0) " " else "_" }.padStart(size))
    }
}

fun rule110(i: Int, j: Int, k: Int): Int {
    // println("$i, $j, $k")
    return when (i to j to k) {
        0 to 0 to 0 -> 0
        0 to 0 to 1 -> 1
        0 to 1 to 0 -> 1
        0 to 1 to 1 -> 1
        1 to 0 to 0 -> 0
        1 to 0 to 1 -> 1
        1 to 1 to 0 -> 1
        1 to 1 to 1 -> 0
        else -> throw IllegalArgumentException()
    }
}

fun main() {
    rule110()
}
