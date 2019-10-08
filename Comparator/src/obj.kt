object SinglePerson : Comparator<Person> {
    var surname: String = "Naumov"
    var name: String = "Eduard"
    var age: Int = 26
    var index: Int = 390039
    var phone: Long = 8 - 900 - 908 - 74 - 59
    override fun compare(o1: Person?, o2: Person?): Int {
        return o1!!.name.compareTo(o2!!.name) //To change body of created functions use File | Settings | File Templates.
    }
}