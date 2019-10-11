package ru.tinkoff


class Pet()  {
     var nickName:String=" "

      var age:Int=0

      var sex:Boolean?=null

    fun initPet1(nickName:String, age:Int, sex:Boolean) = this.apply{
        this.nickName=nickName
        this.age=age
        this.sex=sex
    }

    fun initPet2(nickName:String, age:Int, sex:Boolean) = with(this){
        this.nickName=nickName
        this.age=age
        this.sex=sex
    }

    fun initPet3(nickName:String, age:Int, sex:Boolean)=this.also {
        this.nickName=nickName
        this.age=age
        this.sex=sex
    }

    fun initPet4(nickName:String, age:Int, sex:Boolean)=this?.let {
        this.nickName=nickName
        this.age=age
        this.sex=sex
    }

    override fun toString():String{
        return "${this.nickName} ${this.age} ${this.sex}"
    }


}