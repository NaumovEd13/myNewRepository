import java.util.*

val stack:Stack<Int> = Stack()
val stackOfMax=Stack<Int>()
var arr:IntArray?=null
var count:Int=0

fun main(){
    var str= readLine()
    manageOfStacks(Integer.parseInt(str))
}

fun manageOfStacks(i:Int){
    var j=i
    arr=IntArray(j)
    while(j>0){
        var string= readLine()
        var arrOfStrings: List<String>? = string?.split(" ")
        if(arrOfStrings?.size==2 && arrOfStrings.get(0)=="push"){
            push(Integer.parseInt(arrOfStrings.get(1)))
        }
        else if(arrOfStrings?.size==1 && arrOfStrings.get(0)=="pop"){
            pop()
        }
        else if(arrOfStrings?.size==1&&arrOfStrings.get(0)=="max"){
            max()
        }
        j--;
    }
    for(i in 0 until count step 1){
        println(arr!![i])
    }
}

fun push(i:Int){
    stack.push(i)
    if(stackOfMax.isEmpty()){
        stackOfMax.push(i)
    }
    else{
        if(stackOfMax.peek()>i){
            stackOfMax.push(stackOfMax.peek())
        }
        else{
            stackOfMax.push(i)
        }
    }
}

fun pop(){
    if(!(stack.isEmpty())&&!(stackOfMax.isEmpty())) {
        stack.pop()
        stackOfMax.pop()
    }
}

fun max(){
    arr!![count]=stackOfMax.peek()
    count++
}