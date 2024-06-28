package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    private static ArrayList<Book> list = new ArrayList<>();

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
}
