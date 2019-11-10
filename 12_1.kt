fun main(){
    var listOfNames:MutableList<String> = mutableListOf<String>("Хрюша", "Степаша", "Филя", "Гуля")
    var mappedListOfNames = listOfNames.map {"Привет $it"}
    println(mappedListOfNames)
}