class Owner<T:Pet>(val pet:T) {
    fun feed(){
        println("Домашнее животное ${pet.nickname} накормлено")
    }
}
