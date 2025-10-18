package com.example.bai_tap_tuan_4.Entity

class RomanceBook(id:Int,nameBook:String,isBorrowed: Boolean): Book(id,nameBook,isBorrowed) {
    override fun categoryBook(): String {
        return "ngôn tình"
    }
}