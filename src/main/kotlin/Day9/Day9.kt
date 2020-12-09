package Day9

import java.io.File
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val list = readFile("src\\main\\resources\\Day9\\input.txt")
    println(list)
    lookForSum(list, 25)
}

fun lookForSum(list: ArrayList<BigInteger>, queue: Int) {
    var invalidEntry = (-1).toBigInteger()
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
            invalidEntry = list[i]
            break
        }
    }
    println("Part 1: $invalidEntry")
    println("Part 2: ${findBounds(list, invalidEntry)}")
}


fun findBounds(list: ArrayList<BigInteger>, value: BigInteger): BigInteger {
    val queue = ShortQueue(value)
    for (i in list) {
        if(queue.add(i)){
            return queue.mixPlusMax()
        }
    }
    return (-1).toBigInteger()
}

fun readFile(fileName: String): ArrayList<BigInteger> {
    val list = ArrayList<BigInteger>()
    File(fileName).forEachLine {
        list.add(it.toBigInteger())
    }
    return list
}
class ShortQueue(private var max: BigInteger)
{
    private val queue: Queue<BigInteger> = LinkedList()
    private var sum: BigInteger = 0.toBigInteger()

    fun add(input: BigInteger): Boolean
    {
        queue.add(input)
        sum += input
        while(sum > max)
        {
            sum -= queue.poll()
        }
        return sum == max && queue.size > 1
    }

    fun mixPlusMax(): BigInteger
    {
        var min = queue.peek()
        var max = queue.peek()
        for(i in queue)
        {
            if(i < min)
            {
                min = i
            }
            if(i > max)
            {
                max = i
            }
        }
        return min + max
    }

    override fun toString(): String {
        return "Max: $max : Sum: $sum : queue $queue"
    }
}
