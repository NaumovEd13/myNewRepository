import ru.tinkoff.Pet

fun main(args: Array<String>) {

    var cat=Pet()
    cat.initPet1("Musya", 2, false)
    println(cat.toString())
    var dog=Pet()
    dog.initPet2("Barbos" ,3 , true)
    println(dog)
    var mouse=Pet()
    mouse.initPet3("Mikkey", 1, true)
    println(mouse)
    var bird:Pet?=null
    bird?.initPet4("Egoza", 4, false)
    println(bird)
    bird=Pet()
    bird?.initPet4("Egoza", 4, false)
    println(bird)
    //////////////////////Второй вариант////////////////////////////////////////
    ////////////apply лучше всего для инициализации свойств///////////////////////////////
    var cat2=Pet()
        cat2.apply {
        this.nickName="Garfield"
        this.age=5
        this.sex=true
    }

    var dog2=Pet()
        with(dog2){
        this.nickName="Ralf"
        this.age=4
        this.sex=true
    }

    var snake=Pet()
        snake.also {
        Pet().nickName="snakey"
        Pet().age=10
        Pet().sex=false
    }

    var lizard=Pet()
        lizard?.let {
        Pet().nickName="lizard"
        Pet().age=2
        Pet().sex=false
    }

    println(cat2.toString())
    println(dog2.toString())
    println(snake.toString())
    println(lizard.toString())



}

