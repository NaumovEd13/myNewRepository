package ru.tinkoff


class Snake(name:String, age:Int) : Crawlable, Voiceable,Pet(name, age) {

    override fun crawl() {
        if(!isEscaped==true) {
            println("$nameOfPet:Раньше я ползал по лесам и полям, а теперь по террариуму...") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun voice() {
        if(!isEscaped==true) {
            println("$nameOfPet:шшшшш") //To change body of created functions use File | Settings | File Templates.
        }
        }

    override fun askToEat() {
        if (!isEscaped == true) {
            println("$nameOfPet:кидай в террариум мертвую мышь") //To change body of created functions use File | Settings | File Templates.
            eat();

        }
    }
}