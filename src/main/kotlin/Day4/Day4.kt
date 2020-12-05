package Day4

import java.io.File


class Day4 {
}

fun main(){
    var list = readFileLineByLineUsingForEachLine("src\\main\\resources\\Day4\\input.txt");
    var count = 0;
    for(i in list)
    {
        var current = Passport(i);
        var status = current.checkPassport();
        //println("Password: $i || $status")
        if(status)
        {
            count++;
        }
    }
    println("Count: $count")

}

fun readFileLineByLineUsingForEachLine(fileName: String): ArrayList<String> {
    var list = ArrayList<String>()
    var count = 0;
    var input = ""
    File(fileName).forEachLine {
        if (it.toString() == "")
        {
            list.add(input.trim())
            input = "";
        }
        else{
            input += "$it ";
        }
    }
    list.add(input);
    return list;
}