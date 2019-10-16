package ru.tinkoff

import ru.tinkoff.Pet

fun main(args: Array<String>) {

    ////////////apply лучше всего для инициализации свойств///////////////////////////////

    var cat=Pet().apply {
        this.nickName="Garfield"
        this.age=5
        this.sex=true
    }


    var dog=Pet()
    with(dog){
        this.nickName="Ralf"
        this.age=4
        this.sex=true
    }


    var snake=Pet().also {
        it.nickName="snakey"
        it.age=10
        it.sex=false
    }


    var lizard=Pet()
    lizard?.let {
        it.nickName="lizard"
        it.age=2
        it.sex=false
    }

    println(cat)
    println(dog)
    println(snake.toString())
    println(lizard.toString())



}