package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // get all books handler methods
    @GetMapping("/books")
    public List<Book> getBook() {
        return this.bookService.getAllBooks();
    }

    // get single book handler methods
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    // add new book handler method
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }

    // delete book handler method
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {

        this.bookService.deleteBook(bookId);

    }

    // update book handler method
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        this.bookService.updateBook(book, bookId);
        return book;
    }

}
