package Day2

import kotlin.math.min

class Password(val rawInput: String) {
    var minimum: Int = 0;
    var maximum: Int = 0;
    var patternCharacter: String = "";
    var password: String = "";

    init {
        val spaceSplit = rawInput.split(" ");
        val hyphenSplit = spaceSplit[0].split("-");
        patternCharacter = spaceSplit[1].substring(0, 1);
        minimum = hyphenSplit[0].toInt()-1;
        maximum = hyphenSplit[1].toInt()-1;
        password = spaceSplit[2];
    }

    fun checkPassword(): Boolean {
        var count = 0;
        for (i in 0..password.length - 1) {
            if (password[i].toString() == (patternCharacter)) {
                count++;
            }
        }
        return count >= minimum && count <= maximum;
    }

    fun checkPassword2(): Boolean {
        var boolean = false;
        if (minimum < password.length && maximum < password.length) {
            if ((password[minimum].toString() == patternCharacter).xor(password[maximum].toString() == patternCharacter)) {
                boolean = true;
            }
        }

        return boolean
    }
}