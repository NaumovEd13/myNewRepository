fun main(){
    var list:List<String> = mutableListOf("Хрюша", "Степаша", "Филя", "Олег Монгол")
    var max: String? = list.get(0)
    var prevMax=max
    for(name in list){
       max = list.find { it.length>max!!.length }
        if(max==null){
            max=prevMax
        }
        else{
            prevMax=max
        }
    }
    println(max)
}
