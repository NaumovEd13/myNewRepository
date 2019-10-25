import javafx.application.Application.launch
import kotlinx.coroutines.*

class Pet(val nickName: String, val mealDuration: Long) {
    suspend fun eat() {
        delay(mealDuration)
        println("$nickName покушал")
    }
}

suspend fun main(args: Array<String>) {

    val cat = Pet("Васька", 3000)
    val dog = Pet("Шарик", 2000)
    val mouse = Pet("Камыш", 4000)
    val hampster = Pet("Леонид", 5000)
    val bird = Pet("Жорик", 1000)

    runBlocking {
        launch {
            cat.eat()
        }
        launch {
            dog.eat()
        }
        launch {
            mouse.eat()
        }
        launch {
            hampster.eat()
        }
        launch {
            bird.eat()
        }
    }
    println("Животные поели")
    delay(5000)


    var startEat=GlobalScope.async {
        launch {
            cat.eat()
        }
        launch {
            dog.eat()
        }
        launch {
            mouse.eat()
        }
        launch {
            hampster.eat()
        }
        launch {
            bird.eat()
        }
    }
    println("Еду раздали")
    startEat.await()
    println("Животные поели")


}

