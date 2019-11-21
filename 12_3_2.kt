fun main(){
    var list:List<String> = listOf("Хрюша", "Степаша", "Филя", "Олег Монгол")
    var max=list.maxBy { it.length }
    println(max)
}
