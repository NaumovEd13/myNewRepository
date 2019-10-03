package ru.tinkoff


class Parrot(name:String, age:Int) : Flyable, Voiceable, Pet(name, age) {

    override fun fly() {
        if(!isEscaped==true) {
            println("$nameOfPet:Я лечу с плеча на плечо и с шкафа на стол") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun voice() {
        if(!isEscaped==true) {
            println("$nameOfPet хороший") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun askToEat() {
        if (!isEscaped == true) {
            println("$nameOfPet хочет кушать") //To change body of created functions use File | Settings | File Templates.
            eat();

        }
    }
}