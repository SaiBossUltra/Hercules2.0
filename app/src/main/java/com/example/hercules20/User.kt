package com.example.hercules20

class User {
    lateinit var name:String; lateinit var lastMessage:String; lateinit var lastMsgTime:String; lateinit var phoneNo:String; lateinit var country:String
    var imageId: Int = 0
    fun User(name: String, lastMessage: String, lastMsgTime: String, phoneNo: String, country: String, imageId: Int){
        this.name=name
        this.lastMessage=lastMessage
        this.lastMsgTime=lastMsgTime
        this.phoneNo=phoneNo
        this.country=country
        this.imageId=imageId
    }
}