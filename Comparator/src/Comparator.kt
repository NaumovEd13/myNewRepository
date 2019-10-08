data class Person(var surname:String, var name:String, var age:Int, var index:Int, var phone:Long) {
    companion object : Comparator<Person.Companion> {
        var surname: String = "Naumov"
        var name: String = "Eduard"
        var age: Int = 26
        var index: Int = 390039
        var phone: Long = 8 - 900 - 908 - 74 - 59
        override fun compare(o1: Person.Companion?, o2: Person.Companion?): Int {
            return o1!!.name.compareTo(o2!!.name) //To change body of created functions use File | Settings | File Templates.
        }


    }
}

fun main(args: Array<String>) {
    var Companion2= Person.Companion
    var Companion = Person.Companion
    if ((Companion.compare(Companion2,Companion))==0) {
        println("${Companion.name} идентичен ${Companion.name}")
    } else {
        println("Не идентичны")
    }

    var pers1=Person("Ivanov","Ivan",20,390039,89105323043)
    var pers2=Person("Ivanov","Ivan",20,390039,89105323043)
    var Ed=SinglePerson
    if (Ed.compare(pers1,pers2 )==0) {
        println("${pers1.name} идентичен ${pers2.name}")
    } else {
        println("Не идентичны")
    }


}