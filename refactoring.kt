fun main(){
    var listOfNames:List<String> = listOf<String>("Хрюша", "Степаша", "Филя", "Гуля")
    var mappedListOfNames = listOfNames.map {"Привет $it"}
    println(mappedListOfNames)
}

