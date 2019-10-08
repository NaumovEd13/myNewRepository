
 data class Person(var surname:String, var name:String, var age:Int, var index:Int, var phone:Long){

 }

 fun main(args: Array<String>){
     var Ivan=Person("Ivanov", "Ivan", 20, 390039, 8-900-900-77-77)
     var Vasily=Person("Vasiliev", "Vasily", 21, 360936, 8-920-976-12-23)
     var Ivan2=Ivan.copy()
    if(Ivan.equals(Vasily)){
        println("${Ivan.name} идентичен ${Vasily.name}")
    }
     if(Ivan.equals(Ivan2)){
         println("${Ivan.name} идентичен ${Ivan2.name}")
     }

 }