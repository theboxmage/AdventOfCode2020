package Day6

import java.io.File

fun main()
{
    val list = readFile("src\\main\\resources\\Day6\\input.txt")
    var count = 0
    for(i in list)
    {
        count += i.size-1
    }
    println("Part 1: $count")
    count = 0
    for(i in list)
    {
        for(item in i.filter{(key, _) -> key != '#'})
        {
            if(item.value == i['#'])
            {
                count++
            }
        }
    }
    println("Part 2: $count")
}

fun readFile(fileName: String): ArrayList<Map<Char, Int>> {
    val list = ArrayList<Map<Char, Int>>()
    var group = mutableMapOf<Char, Int>()
    group['#'] = 0
    File(fileName).forEachLine {
        if(it == "")
        {
            list.add(group)
            group = mutableMapOf()
            group['#'] = 0
        }
        else {
            group['#'] = group['#']!!.plus(1)
            for(character in it)
            {
                if(group[character] == null)
                {
                    group[character] = 1
                } else {
                    group[character] = group[character]!! + 1
                }
            }
        }
    }
    list.add(group)
    return list
}