val list:MutableList<String> = mutableListOf("Крош","Ёжик", "Нюша", "Бараш")
val set:MutableSet<String> = mutableSetOf("Крош","Ёжик", "Нюша", "Бараш")

fun main(){
    println("В списке:")
    for(names in list){
        println(names)
    }
    println("В наборе:")
    for(names in set){
        println(names)
    }
}