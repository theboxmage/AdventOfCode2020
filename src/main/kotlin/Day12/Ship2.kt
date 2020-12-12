package Day12

import kotlin.math.abs

class Ship2 (private var wx: Int, private var wy: Int){
    private var x = 0
    private var y = 0
    fun move(input: String)
    {
        val direction = input[0]
        val distance = input.substring(1).toInt()
        when(direction){
            'F' -> {x+=distance * wx;y+=distance * wy}
            'N' -> {wy+=distance}
            'S' -> {wy-=distance}
            'E' -> {wx+=distance}
            'W' -> {wx-=distance}
            'L' -> {turn(360-input.substring(1).toInt())}
            'R' -> {turn(input.substring(1).toInt())}
        }
        //println("$direction  $distance $this")

    }

    fun calculateDistance(): Int {
        return abs(x) + abs(y)
    }
    override fun toString(): String {
        return "X : $x Y : $y WX : $wx WY : $wy"
    }

    private fun turn(toInt: Int) {
        for(i in 0 until toInt/90)
        {
            val temp = wx
            wx = wy
            wy = -temp
        }
    }
}