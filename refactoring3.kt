fun main(){
    var listOfNames:List<String> = listOf<String>("Хрюша", "Степаша", "Филя", "Гуля")
    var filteredListOfNames = listOfNames.filter{it.length<6}
    println(filteredListOfNames)
}