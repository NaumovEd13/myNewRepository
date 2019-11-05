import java.lang.Math.max

var list:List<String> = mutableListOf<String>()

fun main(){
    var size:Int= Integer.parseInt(readLine())
    var tree = readLine()
    list = tree!!.split(" ")
    if(list.size==size) {
        var topOfTree = list.indexOf("-1")
        println(findTheDepth(list, topOfTree))
    }
}

fun findTheDepth(list:List<String>, top:Int):Int{
    var height=1
    for(i in 0 until list.size step 1){
        if(list.get(i).toInt()==top)
            height= max(height, 1+findTheDepth(list, i))
    }
    return height
}

