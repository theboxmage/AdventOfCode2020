package Day12

import java.io.File

fun main() {
    val list = readFile("src\\main\\resources\\Day12\\input.txt")
    val ship = Ship()
    val ship2 = Ship2(10, 1)
    for(direction in list)
    {
        ship.move(direction)
        ship2.move(direction)
    }
    println("Day 1: ${ship.calculateDistance()}")
    println("Day 2: ${ship2.calculateDistance()}")
}


fun readFile(fileName: String): ArrayList<String> {
    val list = ArrayList<String>()
    File(fileName).forEachLine {
        list.add(it)
    }
    return list
}