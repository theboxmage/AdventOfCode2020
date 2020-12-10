package Day10

import java.io.File


fun main() {
    val list = readFile("src\\main\\resources\\Day10\\input.txt")
    part1(list)
    println(part2(list))
}

fun part1(list: ArrayList<Long>) {
    val differences = longArrayOf(0, 0, 0)
    for(i in 1 until list.size)
    {
        differences[(list[i]-list[i-1]-1).toInt()]++
    }

    println("Part 1: ${differences[0] * differences[2]}")
}

fun part2(list: ArrayList<Long>): Long {
    val previousCombinations = ArrayList<Long>()
    for (i in list.indices) {
        if(i <= 1)
        {
            previousCombinations.add(1)
        } else {
            var sum: Long = 0
            sum += if(list[i]-list[i-1] <= 3) previousCombinations[i-1] else 0L
            sum += if(list[i]-list[i-2] <= 3) previousCombinations[i-2] else 0L
            sum += if(i > 2 && list[i]-list[i-3] <= 3) previousCombinations[i-3] else 0L
            previousCombinations.add(sum)
        }
    }
    println(previousCombinations)
    return previousCombinations.last()
}

fun readFile(fileName: String): ArrayList<Long> {
    val list = ArrayList<Long>()
    list.add(0)
    File(fileName).forEachLine {
        list.add(it.toLong())
    }
    list.sort()
    list.add(list[list.size-1]+3)
    return list
}