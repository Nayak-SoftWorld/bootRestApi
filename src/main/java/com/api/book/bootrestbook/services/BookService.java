package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(2, "Book2", "xyz2"));
        list.add(new Book(3, "Book3", "xyz3"));
        list.add(new Book(4, "Book4", "xyz4"));
        list.add(new Book(5, "Book5", "xyz5"));
    }

    // getAllBooks

    public List<Book> getAllBooks() {
        return list;
    }

    // getSingleBook by id
    public Book getBookById(int id) {

        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    // addBook
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // delete book by bookId
    public void deleteBook(int bId) {

        list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());

        // ========== Or =========== //

        // list = list.stream().filter(book -> {
        // if (book.getId() != bId) {
        // return true;
        // } else {
        // return false;
        // }
        // }).collect(Collectors.toList());

    }

    // update book by id
    public void updateBook(Book book, int bookId) {
        list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
