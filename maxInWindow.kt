import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    var sizeOfTheString= Integer.parseInt(readLine())
    var string= readLine()
    var sizeOfWindow= Integer.parseInt(readLine())
    var listOfSTRNumbers = string?.split(" ")
    if(sizeOfTheString!=listOfSTRNumbers!!.size){
        println("Количество аргументов второй строки не совпадает с длиной")
        return
    }

    var listOfNumbers:MutableList<Int> = mutableListOf()
    for(i in 0 until listOfSTRNumbers!!.size step 1){
        var num=Integer.parseInt(listOfSTRNumbers.get(i))
        listOfNumbers.add(num)
    }
    findMaxInSlipperyWindow(listOfNumbers, sizeOfWindow)
}


fun findMaxInSlipperyWindow(list:MutableList<Int>, sizeOfWindow:Int){
    var stackInput:Stack<Int> = Stack()
    var stackOutput:Stack<Int> = Stack()
    var stBuild:StringBuilder= StringBuilder()
    for(i in 0 until sizeOfWindow step 1) {
        stackInput.push(list.get(i))
    }
    for(i in 0 until stackInput.size step 1) {
        stackOutput.push(stackInput.pop())
    }
    var maximum=stackOutput.max()
    stBuild.append(maximum).append(" ")

    for(i in sizeOfWindow until list.size step 1){
        stackInput.push(list.get(i))
        stackOutput.pop()
        if(!stackInput.isEmpty()&&!stackOutput.isEmpty()){
            if(stackInput.max()!!>stackOutput.max()!!){
                stBuild.append(stackInput.max()!!).append(" ")
            }
            else{
                stBuild.append(stackOutput.max()!!).append(" ")
            }
        }
        if(stackInput.isEmpty()){
            stBuild.append(stackOutput.max()).append(" ")
        }
        if(stackOutput.isEmpty()){
            for(i in 0 until stackInput.size step 1) {
                stackOutput.push(stackInput.pop())
            }
            stBuild.append(stackOutput.max()).append(" ")
        }
    }




    println(stBuild)

}

/*
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    var sizeOfTheString= Integer.parseInt(readLine())
    var string= readLine()
    var sizeOfWindow= Integer.parseInt(readLine())
    var listOfSTRNumbers = string?.split(" ")
    if(sizeOfTheString!=listOfSTRNumbers!!.size){
        println("Количество аргументов второй строки не совпадает с длиной")
        return
    }

    var listOfNumbers:MutableList<Int> = mutableListOf()
    for(i in 0 until listOfSTRNumbers!!.size step 1){
        var num=Integer.parseInt(listOfSTRNumbers.get(i))
        listOfNumbers.add(num)
    }
    findMaxInSlipperyWindow(listOfNumbers, sizeOfWindow)
}


fun findMaxInSlipperyWindow(list:MutableList<Int>, sizeOfWindow:Int){
    var list2:ArrayList<Int> = ArrayList()
    var stBuild:StringBuilder= StringBuilder()
    var maximum=list.get(0)
    for(i in 0 until sizeOfWindow step 1) {
        if(list.get(i)>maximum){
            maximum=list.get(i)
        }
        list2.add(list.get(i))
    }
    stBuild.append(maximum).append(" ")
    for(i in sizeOfWindow until list.size step 1){
        list2.add(list.get(i))
        list2.removeAt(0)
        if(list2.contains(maximum)){
            if(list.get(i)>maximum!!){
                maximum=list.get(i)
            }
        }
        else{
            maximum=list2.get(0)
            for(i in 0 until list2.size step 1){
                if(list2.get(i)>maximum){
                    maximum=list2.get(i)
                }
            }
        }
        stBuild.append(maximum).append(" ")
    }

    println(stBuild)

}
 */