fun main(){
    var list:List<String> = mutableListOf("Хрюша", "Степаша", "Филя", "Гуля")
    val newList:List<String> = list.asSequence().filter { it.length<=4 }.map { "Привет $it" }.toList()
    println(newList)
}