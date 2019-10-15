fun main(args: Array<String>){
    val cat=Pet("Kitty", 2, null)
    val dog=OnlyDogs("Barbos",1 , true)
    println(cat.isAdult())
    println(cat.respectableNickname)
    println(dog.isAdult())
    println(dog.respectableNickname)
    println(getRespectableName(cat))
    println(getRespectableName(dog))

}

fun Pet.isAdult():Boolean{
    return this.age>=2
}

val Pet.respectableNickname:String
    get() = "Dear pet ${this.nickname}"


fun OnlyDogs.isAdult():Boolean{
    return this.age>=2;
}

val OnlyDogs.respectableNickname:String
    get() = "Dear dog ${this.nickname}"

////Расширения имеют статическую диспетчеризацию, поэтому при вызове этого метода будет выбрано свойство типа Pet, вне
//зависимости от того, какой тип переданного аргумента: Pet или его наследник
fun getRespectableName( pet: Pet){
    println(pet.respectableNickname)
}