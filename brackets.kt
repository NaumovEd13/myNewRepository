import java.util.*

var stackOfBrackets= Stack<Char>()
var stackOfIndexes=Stack<Int>()

fun main(){
    var str= readLine()
    checkBrackets(str!!)
}
fun checkBrackets(str:String){
    var arrOfChars: CharArray = str.toCharArray()
    for(i in 0 until arrOfChars.size step 1){
        if(")]}".contains(arrOfChars[i])&&stackOfBrackets.isEmpty()){
            println(i+1)
            return
        }
        if("({[".contains(arrOfChars[i])){
            stackOfBrackets.push(arrOfChars[i])
            stackOfIndexes.push(i)
        }
        if(")]}".contains(arrOfChars[i])){
            if(arrOfChars[i]==')'){
                if(stackOfBrackets.peek()=='('){
                    stackOfBrackets.pop()
                    stackOfIndexes.pop()
                }
                else{
                    println(i+1)
                    return
                }
            }
            if(arrOfChars[i]==']'){
                if(stackOfBrackets.peek()=='['){
                    stackOfBrackets.pop()
                    stackOfIndexes.pop()
                }
                else{
                    println(i+1)
                    return
                }
            }
            if(arrOfChars[i]=='}'){
                if(stackOfBrackets.peek()=='{'){
                    stackOfBrackets.pop()
                    stackOfIndexes.pop()
                }
                else{
                    println(i+1)
                    return
                }
            }
        }
    }
    if(stackOfBrackets.isEmpty())
        println("Success")
    else
        println(stackOfIndexes.firstElement()+1)
}
