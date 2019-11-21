fun main(){
    var list:List<String> = mutableListOf("Хрюша", "Степаша", "Филя", "Олег Монгол")
    var max=list.asSequence().find { it.equals(list.asSequence().maxBy { it.length }) }
    println(max)
}
