package ru.tinkoff


class Fish(name:String, age:Int): Swimable, Pet(name, age) {

    override fun swim() {
        if(!isEscaped==true) {
            println("$nameOfPet:Вода-моя стихия!") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun askToEat() {
        if (!isEscaped == true) {
            println("$nameOfPet:хочу есть, но не знаю, как сказать") //To change body of created functions use File | Settings | File Templates.
            eat();

        }
    }
}