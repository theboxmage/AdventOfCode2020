package Day11

import java.io.File
import kotlin.collections.ArrayList

fun main() {
    val list = readFile("src\\main\\resources\\Day11\\input.txt")
    drivePart1(deepCopy(list))

    drivePart2(deepCopy(list))
}

fun drivePart2(list: java.util.ArrayList<java.util.ArrayList<String>>) {
    var inputList = deepCopy(list)
    var deepCopy = changeBoard2(inputList)

    while(inputList.toString() != deepCopy.toString())
    {
        inputList = deepCopy
        deepCopy = changeBoard2(inputList)
    }
    var count = 0
    for(i in deepCopy)
    {
        for(j in i)
        {
            if(j == "#") count++
        }
    }
    println("Part 2: $count")
}

fun changeBoard2(list: ArrayList<ArrayList<String>>): ArrayList<ArrayList<String>> {
    val outputList = deepCopy(list)
    for(y in list.indices)
    {
        for(x in list[y].indices)
        {
            if(list[y][x] == "L" && countAroundInLines(x, y, list) == 0)
            {
                outputList[y][x] = "#"
            }
            else if(list[y][x] == "#" && countAroundInLines(x, y, list) >= 5)
            {
                outputList[y][x] = "L"
            }
        }
    }
    return outputList
}

fun countAroundInLines(x: Int, y: Int, list: ArrayList<ArrayList<String>>): Int {
    var count = 0
    for(i in -1..1)
    {
        for(j in -1..1)
        {
            if(!(i == 0 && j == 0) && followPath(x+i, y+j, i, j, list) == "#")
            {
                count++
            }
        }
    }
    return count
}

//Don't call from origin point
fun followPath(x: Int, y: Int, dx: Int, dy: Int,list: ArrayList<ArrayList<String>>): String {
    return if(x < 0 || x >= list[0].size || y < 0 || y >= list.size)
    {
        "L"
    } else if(list[y][x] == "#" || list[y][x] == "L")
    {
        list[y][x]
    } else {
        followPath(x + dx, y+dy, dx, dy, list)
    }
}

fun drivePart1(list: ArrayList<ArrayList<String>>) {
    var inputList = deepCopy(list)
    var deepCopy = changeBoard(inputList)
    while(inputList.toString() != deepCopy.toString())
    {
        inputList = deepCopy
        deepCopy = changeBoard(inputList)
    }
    var count = 0
    for(i in deepCopy)
    {
        for(j in i)
        {
            if(j == "#") count++
        }
    }
    println("Part 1: $count")
}



fun deepCopy(list: ArrayList<ArrayList<String>>): ArrayList<ArrayList<String>> {
    val outputList = ArrayList<ArrayList<String>>()
    for(i in list.indices)
    {
        outputList.add(ArrayList())
        for(j in list[i].indices)
        {
            outputList[i].add(list[i][j])
        }
    }
    return outputList
}


fun changeBoard(list: ArrayList<ArrayList<String>>): ArrayList<ArrayList<String>> {
    val outputList = deepCopy(list)
    for(y in list.indices)
    {
        for(x in list[y].indices)
        {
            if(list[y][x] == "L" && countAround(x, y, list) == 0)
            {
                outputList[y][x] = "#"
            }
            else if(list[y][x] == "#" && countAround(x, y, list) >= 4)
            {
                outputList[y][x] = "L"
            }
        }
    }
    return outputList
}

fun countAround(x: Int, y: Int, list: ArrayList<ArrayList<String>>): Int {
    var count = 0
    for(i in -1..1)
    {
        for(j in -1..1)
        {
            if(x+i >= 0 && x+i < list[0].size && y+j >= 0 && y+j < list.size && list[y+j][x+i] == "#" && !(i == 0 && j == 0))
            {
                count++
            }
        }
    }
    return count
}

fun readFile(fileName: String): ArrayList<ArrayList<String>> {
    val list = ArrayList<ArrayList<String>>()
    File(fileName).forEachLine {
        val temp = ArrayList<String>(it.split("").toList())
        temp.removeAll(listOf("", null))
        list.add(ArrayList(temp))
    }
    return list
}