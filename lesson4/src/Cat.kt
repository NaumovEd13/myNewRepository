package ru.tinkoff


class Cat(name:String, age:Int) : Voiceable, Walkable ,Pet(name, age) {

    override fun voice() {
        if(!isEscaped==true) {
            println("$nameOfPet:мяу-мяу") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun walk() {
        if(!isEscaped==true) {
            println("$nameOfPet:Гуляю в пределах квартиры, весь мир здесь") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun askToEat() {
        if (!isEscaped == true) {
            println("$nameOfPet:покорми кота") //To change body of created functions use File | Settings | File Templates.
            eat();

        }
    }
}