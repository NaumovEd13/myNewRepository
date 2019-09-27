fun main(args: Array<String>) {
    val numbers: Array<Int> = arrayOf(2, 5, 4, 1, 3)
    for(n in numbers){
        print("$n ")
    }
    println()
    sortedArr(numbers)
    for(n in numbers){
        print("$n ")
    }
    println()

}

fun sortedArr(arr:Array<Int>){
    var i:Int
   for(i in 0 until arr.size step 1){
       for(j in i+1 until arr.size step 1){
           if(arr[j]<arr[i]){
               var buf=arr[j]
               arr[j]=arr[i]
               arr[i]=buf;
           }
       }
   }
}

