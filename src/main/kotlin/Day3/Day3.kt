package Day3

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class Day2 {

}
val DX = intArrayOf(1, 3, 5, 7, 1);
val DY = intArrayOf(1, 1, 1, 1, 2);
fun main()
{
    var list = readFileLineByLineUsingForEachLine("src\\main\\resources\\Day3\\input.txt");
    //println(list[0]);
    var resultList = ArrayList<Int>();
    for(i in DX.indices) {
        var x = 0;
        var y = 0;
        var count = 0;
        while (y < list.size) {
            //println(list[y][x])
            if (list[y][x] == "#") {
                count++;
            }
            x = (x + DX[i]) % (list[x].size);
            y = (y + DY[i]);
            //println("$y ${list.size}")
        }
        resultList.add(count)
        println(count);
    }
    var current: Double = resultList[0].toDouble()
    for(i in 1 until resultList.size)
    {
        current *= resultList[i]
    }
    println("Final product: ${current.toBigDecimal().toPlainString()}")
}
fun readFileLineByLineUsingForEachLine(fileName: String): ArrayList<ArrayList<String>> {
    var list = ArrayList<ArrayList<String>>()
    File(fileName).forEachLine {
        var temp = ArrayList<String>(it.split(""))
        temp.removeAll(Arrays.asList("", null));
        list.add(temp);
    }
    return list;
}