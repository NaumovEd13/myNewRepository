fun main(){
    var list:List<String> = mutableListOf("Хрюша", "Степаша", "Филя", "Гуля")
    var max=list.get(0)
    var maxLengthName=list.find {it.length>max.length}
    println(maxLengthName)
}
