

fun main(args: Array<String>) {
    var cat:Cat=Cat("кот",3, true)
    var dog:Dog=Dog("собака",3, true)
    var owner:Owner<Dog>
    owner=Owner(dog)
    owner.feed()
}



