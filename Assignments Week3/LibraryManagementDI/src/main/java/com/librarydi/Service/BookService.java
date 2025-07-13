package com.librarydi.service;

import com.librarydi.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addNewBook(String title) {
        bookRepository.addBook(title);
    }
    public List<String> listAllBooks() {
        return bookRepository.findAll();
    }
}
