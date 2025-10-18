package com.example.bai_tap_tuan_4.Entity

abstract class Book(
    id:Int,
    nameBook:String,
    isBorrowed: Boolean) {
    protected var _id = id
    protected var _nameBook = nameBook
    protected var _isBorrowed = isBorrowed

    init {
        require(id >= 0) { "ID không được âm" }
    }
    public var id: Int
        get()=_id
        set(value) {
            _id=value
        }
    public var nameBook: String
        get()=_nameBook
        set(value) {
            _nameBook=value
        }
    public var isBorrowed: Boolean
        get()= _isBorrowed
        set(value) {
            _isBorrowed= value
        }
    abstract fun categoryBook(): String
}