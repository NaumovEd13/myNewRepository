import java.util.*

val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    val s = scan.next()
    print(isCapitalized(s))
}

fun isCapitalized(str:String):Boolean {
    val firstLetter = str[0];
    if (firstLetter.isUpperCase()) {
        return true;
    }
    return false;

}