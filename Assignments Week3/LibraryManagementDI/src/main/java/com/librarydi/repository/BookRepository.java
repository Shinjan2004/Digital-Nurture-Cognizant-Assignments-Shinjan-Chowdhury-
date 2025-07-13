package com.librarydi.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<String> books = new ArrayList<>();
    public void addBook(String title) { books.add(title); }
    public List<String> findAll() { return books; }
}
