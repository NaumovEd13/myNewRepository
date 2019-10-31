val list:List<String> = ArrayList(listOf("Крош","Ёжик", "Нюша", "Бараш"))
val set:Set<String> = HashSet(list)


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