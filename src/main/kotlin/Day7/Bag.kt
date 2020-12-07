package Day7

class Bag(var name: String, var inventory: ArrayList<Pair<String, Int>>) {

    override fun toString(): String {
        return "$name:, $inventory"
    }
}