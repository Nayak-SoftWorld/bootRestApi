package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(2, "Book2", "xyz2"));
    // list.add(new Book(3, "Book3", "xyz3"));
    // list.add(new Book(4, "Book4", "xyz4"));
    // list.add(new Book(5, "Book5", "xyz5"));
    // }

    // getAllBooks
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // getSingleBook by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // addBook
    public Book addBook(Book b) {
        // list.add(b);
        Book result = this.bookRepository.save(b);
        return result;
    }

    // delete book by bookId
    public void deleteBook(int bId) {

        // list = list.stream().filter(book -> book.getId() !=
        // bId).collect(Collectors.toList());

        bookRepository.deleteById(bId);

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
        // list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }

}
