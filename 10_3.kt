val initializedList:List<String> = mutableListOf("Крош","Ёжик", "Нюша", "Бараш")
val notInitializedList:ArrayList<String> = ArrayList()

val initializedSet:Set<String> = mutableSetOf("Крош","Ёжик", "Нюша", "Бараш")
val notInitializedSet:HashSet<String> = HashSet()


fun main(){
    println("В списке:")

    for(names in initializedList){
        notInitializedList.add(names)
    }

    for(names in notInitializedList){
        println(names)
    }

    println("В множестве:")

    for(names in initializedSet){
        notInitializedSet.add(names)
    }

    for(names in notInitializedSet){
        println(names)
    }
}