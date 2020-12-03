package Day3

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class Day2 {

}


fun main()
{
    var list = readFileLineByLineUsingForEachLine("src\\main\\resources\\Day3\\input.txt");
    //println(list[0]);
    var current: Double = runSlope(list, 1, 1);
    current *= runSlope(list, 3, 1);
    current *= runSlope(list, 5, 1);
    current *= runSlope(list, 7, 1);
    current *= runSlope(list, 1, 2);

    println("Final product: ${current.toBigDecimal().toPlainString()}")
}

fun runSlope(list: ArrayList<ArrayList<String>>, dx: Int, dy: Int): Double {
    var x = 0;
    var y = 0;
    var count = 0;
    while (y < list.size) {
        if (list[y][x] == "#") {
            count++;
        }
        x = (x + dx) % (list[x].size);
        y = (y + dy);
    }
    println("With Slope dx:$dx dy:$dy you hit $count trees")
    return count.toDouble();
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