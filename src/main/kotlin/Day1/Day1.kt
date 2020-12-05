import java.io.File

fun main() {
    var list = readFileLineByLineUsingForEachLine("src\\main\\resources\\Day1\\input.txt")
    list.sort();
    processListTwoEntries(list)
    processListThreeEntries(list)
}

fun processListThreeEntries(list: ArrayList<Int>) {
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            for (k in j + 1 until list.size) {
                val a = list[i]
                val b = list[j]
                val c = list[k]
                if (a + b + c == 2020) {
                    println("a+b+c=$a+$b+$c where a*b*c is ${a * b * c}")
                }
            }
        }
    }
}

fun processListTwoEntries(list: ArrayList<Int>) {
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            val a = list[i]
            val b = list[j]
            if (a + b == 2020) {
                println("a+b=$a+$b where a*b is ${a * b}")
            }
        }
    }
}

fun readFileLineByLineUsingForEachLine(fileName: String): ArrayList<Int> {
    var list = ArrayList<Int>()
    File(fileName).forEachLine {
        list.add(it.toInt())
    }
    return list;
}