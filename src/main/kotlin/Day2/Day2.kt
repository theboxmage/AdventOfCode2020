package Day2

import java.io.File

class Day2 {

}

fun main()
{
    var list = readFileLineByLineUsingForEachLine("src\\main\\resources\\Day2\\input.txt");
    var passwordList = ArrayList<Password>();
    for(i in list){
        passwordList.add(Password(i));
    }
    var count = 0;
    for(item in passwordList){
        if(item.checkPassword2())
        {
            count++;
        }
        //break;
    }
    println("Valid passwords: $count");
}
fun readFileLineByLineUsingForEachLine(fileName: String): ArrayList<String> {
    var list = ArrayList<String>()
    File(fileName).forEachLine {
        list.add(it.toString())
    }
    return list;
}