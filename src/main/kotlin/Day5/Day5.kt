package Day5

import java.io.File

class Day5 {
}

fun main()
{
    val list = readFile("src\\main\\resources\\Day5\\input.txt")
    val idList = ArrayList<Int>()
    for( i in list)
    {
        val row = processString(i.take(7), 0, 127)
        val column = processString(i.takeLast(3), 0, 7)
        val id = row * 8 + column
        idList.add(id)
        println("ID = $id for row $row and column $column")
    }
    idList.sort()
    println("Max ID is: ${idList[idList.size-1]}")
    for(x in 1 until idList.size-1)
    {
        if(idList[x] == idList[x+1]-2 || idList[x] == idList[x-1]-2)
        {
            println("My seat ID: ${idList[x+1]-1}")
        }
    }
}

fun processString(input: String, lowerBound: Int, upperBound: Int): Int {
    var lowerCount = lowerBound
    var upperCount = upperBound
    for(char in input)
    {
        if(char == "B"[0] || char == "R"[0])
        {
            lowerCount = 1+((upperCount + lowerCount) / 2)
        } else {
            upperCount = (upperCount + lowerCount) / 2
        }
    }
    return upperCount
}

fun readFile(fileName: String): ArrayList<String> {
    val list = ArrayList<String>()
    File(fileName).forEachLine {
        list.add(it)
    }
    return list
}