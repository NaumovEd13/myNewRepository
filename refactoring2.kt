package ru.tinkoff

import java.util.Scanner

class Car() {
    fun ride(km: Int) {
        var distance=km
        // Ваш код здесь
        println("Поехали!")
        while(distance>0) {
            Thread.sleep(200)
            distance--
            println(distance)
        }
            println("Приехали!")
    }
}

fun main(args: Array<String>) {
    val car = Car()
    car.ride(Integer.parseInt(readLine()))
}