fun main(){
    var list:List<String> = mutableListOf("Хрюша", "Степаша", "Филя", "Гуля")
    val value:Boolean=list.any{it.length==7}
    println(value)
}