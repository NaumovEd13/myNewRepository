package ru.tinkoff

open class Cat {
    open fun hunt () {
        println("Я охочусь на мышей, ведь я кот!")
    }
}

class HomeCat: Cat(){
     fun hunt(bool:Boolean) {
         if(bool==true) {
             super.hunt()
         }
         else{
             println("Ты че сдурел? Какие мыши? Иди корми меня, ленивая задница!")
         }
    }
}

fun main(args: Array<String>) {
    var homeCat=HomeCat()
    homeCat.hunt(true)
    homeCat.hunt(false)
}