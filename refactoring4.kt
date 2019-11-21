import java.util.*

fun main(args: Array<String>) {
    val numbers: Array<Int> = arrayOf(2, 5, 4, 1, 3)
    for(n in numbers){
        print("$n ")
    }
    println()
    Arrays.sort(numbers)
    for(n in numbers){
        print("$n ")
    }
    println()

}
