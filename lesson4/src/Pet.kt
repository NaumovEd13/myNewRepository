package ru.tinkoff

abstract class Pet(name:String, age:Int) {
    var nameOfPet=name
    fun getName(){
        println(nameOfPet)
    }
    var ageOfPet=0
    fun getAge(){
        println("возраст $nameOfPet $ageOfPet год")
    }
    init {
        try {
            if (age < 0) {
                throw AgeException("Неправильно введен возраст у $nameOfPet")
            }
            else{
                ageOfPet=age
            }
        } catch (e: AgeException) {
            println(e.message)
        }

    }
    var counterOfEatings: Int=0
    var isEscaped: Boolean=false
    fun eat(){
        if(!isEscaped==true) {
            println("$nameOfPet: Я ем!")
            counterOfEatings++
            if (counterOfEatings >= 2) {
                isEscaped = true
                runAway()
            }
        }
    }
    abstract fun askToEat()

    fun toClean(){
        if(!isEscaped==true) {
            println("Убрали за животным $nameOfPet")
            counterOfEatings--
        }
        else{
            println("Не за кем чистить")
        }
    }

    private fun runAway(){
        println("$nameOfPet *Ушел в поисках лучшей жизни*")
    }
}