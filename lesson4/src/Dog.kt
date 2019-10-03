
package ru.tinkoff

class Dog(name:String, age:Int): Walkable, Swimable, Voiceable, Pet(name, age) {


    override fun walk() {
        if(!isEscaped==true) {
            println("$nameOfPet: Я гуляю, веселюсь и бегаю за палкой!") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun swim() {
        if(!isEscaped==true) {
            println("$nameOfPet:А еще я хорошо плаваю") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun voice() {
        if(!isEscaped==true) {
            println("$nameOfPet: гав-гав!") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun askToEat() {
        if(!isEscaped==true){
        println("$nameOfPet: Хозяин! Есть хочу!") //To change body of created functions use File | Settings | File Templates.
        eat();
    }
}
}