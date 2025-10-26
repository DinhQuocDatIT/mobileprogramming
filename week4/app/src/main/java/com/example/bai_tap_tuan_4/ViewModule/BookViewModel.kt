package com.example.bai_tap_tuan_4.ViewModule

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.bai_tap_tuan_4.Entity.Book
import com.example.bai_tap_tuan_4.Entity.ReferenceBook
import com.example.bai_tap_tuan_4.Entity.RomanceBook

class BookViewModel : ViewModel() {
    var bookList = mutableStateListOf<Book>()

    fun addBook(book:Book){
        bookList.add(book)
    }
    fun updateBookStatus(bookId: Int, newStatus: Boolean) {
        bookList.forEachIndexed { index, book ->
            if (book.id == bookId) {
                book.isBorrowed = newStatus
                // trigger recomposition
                bookList[index] = book
            }
        }
    }

}