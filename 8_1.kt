fun main(args: Array<String>) {
    listOf("three", "two", "one").forEach {

        if(it == "one") {

            return@forEach

        }

        println(it)

    }

    println("boom!")
}
// при вызове оператора return из лямбды происходит выход из функции высшего порядка, чтобы произошел выход из
//лямбды, нужно использовать метку @