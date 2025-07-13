package com.librarydi;

import com.librarydi.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementDiApplication {
    public static void main(String[] args) {
        try (var ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            BookService svc = ctx.getBean("bookService", BookService.class);
            svc.addNewBook("Refactoring");
            svc.addNewBook("Spring Recipes");
            System.out.println("Library books:");
            svc.listAllBooks().forEach(System.out::println);
        }
    }
}
