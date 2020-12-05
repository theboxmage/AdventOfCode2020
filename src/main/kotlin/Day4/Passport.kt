package Day4

import java.lang.NumberFormatException

class Passport(val inputString: String) {
    var byr: String = ""
    var iyr: String = ""
    var eyr: String = ""
    var hgt: String = ""
    var hcl: String = ""
    var ecl: String = ""
    var pid: String = ""
    var cid: String = ""


    init{
        val inputArray = inputString.split(" ");
        for(i in inputArray)
        {
            setVal(ArrayList<String>(i.split(":")));
        }
    }

    fun checkPassport(): Boolean {
        var passed = true;

            when {
                byr == "" || byr.toInt() !in 1920..2002 -> {passed = false; /*println("byr: $byr")*/};
                iyr == "" || iyr.toInt() !in 2010..2020 -> {passed = false; /*println("iyr: $iyr")*/}
                eyr == "" || eyr.toInt() !in 2020..2030  -> {passed = false; /*println("eyr")*/}
                hgt == "" || !checkHeight(hgt) ->  {passed = false; /*println("hgt: $hgt")*/}
                hcl == "" || !hcl.matches("#[a-f0-9]{6}".toRegex()) ->  {passed = false; /*println("hcl: $hcl")*/}
                ecl == "" || !(ecl == "amb" || ecl == "blu" || ecl == "brn" || ecl == "gry" || ecl == "grn" || ecl == "hzl" || ecl == "oth") ->  {passed = false; /*println("ecl: $ecl")*/}
                pid == "" || pid.length != 9 || !pid.matches("\\d{9}".toRegex()) ->  {passed = false; println("pid: $pid")}
            }

        return passed;
    }

    private fun checkHeight(input: String): Boolean {
        val takeLast = input.takeLast(2)
        val result: String = input.filter{it.isDigit()}
        //println(result)
        if(takeLast == "cm") {
            return result.toInt() in 150..193
        } else if(takeLast == "in") {
            return result.toInt() in 59..76
        } else {
            return false
        }
    }

    private fun setVal(split: ArrayList<String>) {
        when (split[0]) {
            "byr" -> byr = split[1]
            "iyr" -> iyr = split[1]
            "eyr" -> eyr = split[1]
            "hgt" -> hgt = split[1]
            "hcl" -> hcl = split[1]
            "ecl" -> ecl = split[1]
            "pid" -> pid = split[1]
            "cid" -> cid = split[1]
        }
    }
}