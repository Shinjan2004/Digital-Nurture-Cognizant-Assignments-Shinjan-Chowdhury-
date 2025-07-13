package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx =
                 new ClassPathXmlApplicationContext("applicationContext.xml")) {

            BookService svc = ctx.getBean("bookService", BookService.class);

            svc.addNewBook("Domain-Driven Design");
            svc.addNewBook("Clean Code");

            System.out.println("Books in library:");
            svc.listAllBooks().forEach(System.out::println);
        }
    }
}
