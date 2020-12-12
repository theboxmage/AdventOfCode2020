package Day12

import kotlin.math.abs

class Ship{
    private var x = 0
    private var y = 0
    private var dx = 1
    private var dy = 0
    var currDegrees = 0
    fun move(input: String)
    {
        val direction = input[0]
        val distance = input.substring(1).toInt()
        when(direction){
            'F' -> {x+=dx*distance;y+=dy*distance}
            'N' -> {y+=distance}
            'S' -> {y-=distance}
            'E' -> {x+=distance}
            'W' -> {x-=distance}
            'L' -> {turn(input.substring(1).toInt())}
            'R' -> {turn(360-input.substring(1).toInt())}
        }
        //println("$direction  $distance $this")
    }

    fun calculateDistance(): Int {
        return abs(x) + abs(y)
    }

    override fun toString(): String {
        return "X : $x Y : $y $currDegrees"
    }

    private fun turn(degrees: Int) {
        currDegrees = (currDegrees + degrees) % 360

        when(currDegrees) {
            0 -> {dx = 1;dy = 0 }
            90 -> {dx = 0;dy = 1 }
            180 -> {dx = -1;dy = 0 }
            270 -> {dx = 0;dy = -1 }
        }
    }
}