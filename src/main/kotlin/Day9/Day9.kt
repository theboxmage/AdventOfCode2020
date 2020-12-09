package Day9

import java.io.File
import java.math.BigInteger

fun main() {
    val list = readFile("src\\main\\resources\\Day9\\input.txt")
    println(list)
    lookForSum(list, 25)
}

fun lookForSum(list: java.util.ArrayList<BigInteger>, queue: Int) {
    for (i in queue until list.size) {
        var flag = false
        for (x1 in i - queue until i) {
            for (x2 in i - queue until i) {
                if (x1 != x2) {
                    if (list[x1] + list[x2] == list[i]) {
                        //println("${list[x1]} ${list[x2]} : ${list[i]}")
                        flag = true
                    }
                }
            }
        }
        if (!flag) {
            println("Part 1: ${list[i]}")
            findBounds(list, list[i])
        }
    }
}

fun findBounds(list: ArrayList<BigInteger>, value: BigInteger) {
    for (i in list.indices) {
        val temp = ArrayList<BigInteger>()
        var sum = 0.toBigInteger()
        for (x in i until list.size) {
            sum += list[x]
            temp.add(list[x])
            if (sum >= value) {
                break
            }
        }
        temp.sort()
        if (sum == value) {
            println("Part 2: ${temp[0] + temp[temp.size-1]} || ${temp[0]} and ${temp[temp.size-1]}")
            break
        }
    }
}

fun readFile(fileName: String): ArrayList<BigInteger> {
    val list = ArrayList<BigInteger>()
    File(fileName).forEachLine {
        list.add(it.toBigInteger())
    }
    return list
}