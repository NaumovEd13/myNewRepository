fun main(){
    var listOfNames:MutableList<String> = mutableListOf<String>("Хрюша", "Степаша", "Филя", "Гуля")
    var filteredListOfNames = listOfNames.filter{it.length<6}
    println(filteredListOfNames)
}