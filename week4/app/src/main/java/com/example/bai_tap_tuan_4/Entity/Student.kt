package com.example.bai_tap_tuan_4.Entity

class Student(id:Int,nameStudent: String){
    private  var _id = id
    private  var _nameStudent = nameStudent
    private  var listBook = listOf<Book>()

    public fun  getListBook() : List<Book>{
        return listBook
    }

    init {
        require(id >= 0) { "ID không được âm" }
    }
    public  var id:Int
        get()=_id
        set(value) {
            _id=value
        }
    public  var nameStudent:String
        get() = _nameStudent
        set(value) {
            _nameStudent = value
        }

}