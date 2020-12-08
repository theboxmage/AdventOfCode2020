package Day7

import java.io.File
var bagList: MutableMap<String, Bag> = mutableMapOf()
fun main() {
    val list = readFile("src\\main\\resources\\Day7\\input.txt")
    bagList = populateBagList(list)
    var count = 0
    for ((_, value) in bagList) {
        count += processPart1Bag(value)
    }
    println("Part 1: $count")
    println("Part 2: ${-1+countBags(bagList["shiny gold"]!!)}")

}

fun processPart1Bag(bag: Bag, searchTerm: String = "shiny gold"): Int {
    for (i in bag.inventory) {
        if(i.first == searchTerm)
        {
            return 1
        }
        if (processPart1Bag(bagList[i.first]!!) == 1) {
            return 1
        }
    }
    return 0
}

fun countBags(bag: Bag): Int {
    var count = 0
    for(input in bag.inventory)
    {
        count += input.second * countBags(bagList[input.first]!!)
    }
    return 1 + count
}

fun populateBagList(list: ArrayList<String>): MutableMap<String, Bag> {
    val bagList = mutableMapOf<String, Bag>()
    for (item: String in list) {
        val name = "^\\S+ \\S+".toRegex().find(item)
        val matches = "\\d+ \\S+ \\S+".toRegex().findAll(item)
        val heldBags = ArrayList<Pair<String, Int>>()
        for (i in matches) {
            heldBags.add(Pair(i.value.substring(2), i.value.substring(0, 2).trim().toInt()))
        }
        bagList[name!!.value] = Bag(name.value, heldBags)
    }
    return bagList
}

fun readFile(fileName: String): ArrayList<String> {
    val list = ArrayList<String>()
    File(fileName).forEachLine {
        list.add(it)
    }
    return list
}