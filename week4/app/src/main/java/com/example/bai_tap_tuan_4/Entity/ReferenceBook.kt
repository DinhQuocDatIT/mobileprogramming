package com.example.bai_tap_tuan_4.Entity

class ReferenceBook(id:Int,nameBook:String,isBorrowed: Boolean): Book(id, nameBook, isBorrowed ) {
    override fun categoryBook() :String{
        return "tham khảo"
    }
}