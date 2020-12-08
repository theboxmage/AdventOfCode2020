package Day8

import java.io.File

data class Instruction(var instruction: String, var register: Int)
{
    var hasExecuted = false

    override fun toString(): String{
        return "$instruction $register $hasExecuted"
    }
}
var part2Flag = false
fun main()
{
    val list = readFile("src\\main\\resources\\Day8\\input.txt")
    var instructionSet = ArrayList<Instruction>()
    for(i in list)
    {
        val opcode  = i.split(" ")[0]
        val register = i.split(" ")[1]
        instructionSet.add(Instruction(opcode, register.toInt()))
    }
    println("Part 1: ${processInstructionSet(instructionSet)}")

    val instructionSetCopy = instructionSet.map{it.copy()}
    var accumOut = Int.MIN_VALUE
    for(i in instructionSet.indices)
    {
        val currentInstruction = instructionSet[i]
        if(currentInstruction.instruction == "nop")
        {
            currentInstruction.instruction = "jmp"
        } else if( currentInstruction.instruction == "jmp")
        {
            currentInstruction.instruction = "nop"
        }
        accumOut = processInstructionSet(instructionSet)
        if(part2Flag)
        {
            break
        }
        instructionSet = ArrayList(instructionSetCopy.map{it.copy()})
    }
    println("Part 2: $accumOut")
}

fun processInstructionSet(instructionSet: ArrayList<Instruction>): Int {
    var insValue = 0
    var accum = 0
    while(insValue < instructionSet.size && !instructionSet[insValue].hasExecuted)
    {
        val curr = instructionSet[insValue]
        when (curr.instruction) {
            "nop" -> {
                insValue++
            }
            "jmp" -> {
                insValue += curr.register
            }
            "acc" -> {
                accum += curr.register
                insValue++
            }
        }
        curr.hasExecuted = true
    }
    if(insValue >= instructionSet.size)
    {
        part2Flag = true
    }
    return accum
}
fun readFile(fileName: String): ArrayList<String> {
    val list = ArrayList<String>()
    File(fileName).forEachLine {
        list.add(it)
    }
    return list
}