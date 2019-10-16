package ru.tinkoff


class Pet()  {

    lateinit var nickName:String
    var age:Int=0;
    var sex:Boolean?=false

    override fun toString():String{
        return "${this.nickName} ${this.age} ${this.sex}"
    }


}