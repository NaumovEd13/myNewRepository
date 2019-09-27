import java.io.*;
import java.util.*


fun main(args:Array<String>){
    val scanner= Scanner(System.`in`);
    var a=scanner.nextInt();
    var b=scanner.nextInt();
    var c=scanner.nextInt();
    var d=scanner.nextInt();
    minOfFour(a,b,c,d);
}

fun minOfFour(a:Int, b:Int, c:Int, d:Int  ){
    val numbers:Array<Int> = arrayOf(a,b,c,d);
    var min=a;
    for(n in numbers){
        if(n<min){
            min=n;
        }
    }
    println(min);
}