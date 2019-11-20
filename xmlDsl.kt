open class Tag(private val name: String) {
    private val children = mutableListOf<Tag>()
    private var field: String = String()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    operator fun String.unaryPlus() {
        field = this
    }

    override fun toString() =
        "<$name>$field${children.joinToString("")}</$name>\n"
}


class Name : Tag("name")
class Surname : Tag("surname")
class Birthdate : Tag("birthDate")
class Adress : Tag("address")
class Adresses : Tag("addresses") {
    fun address(init: Adress.() -> Unit) = doInit(Adress(), init)
}
class Obj : Tag("object") {
    fun name(init: Name.() -> Unit) {
        doInit(Name(), init)
    }

    fun surname(init: Surname.() -> Unit) = doInit(Surname(), init)
    fun birthDate(init: Birthdate.() -> Unit) = doInit(Birthdate(), init)
    fun addresses(init: Adresses.() -> Unit) = doInit(Adresses(), init)
}



fun table(init: Obj.() -> Unit) = Obj().apply(init)



fun main() {
    var obj=table {
        name {
            +"Иван"
        }
        surname {
            +"Иванов"
        }
        birthDate {
            +"01.01.1980"
        }
        addresses {
            address {
                +"Рязань, Бирюзова 28"
            }
            address {
                +"Москва, Озерная 19"
            }
            address {
                +"Рязань, Октябрьская 58"
            }
        }
    }
    print(obj)
}