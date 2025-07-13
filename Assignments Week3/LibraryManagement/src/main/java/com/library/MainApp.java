package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the service bean
        BookService service = context.getBean("bookService", BookService.class);

        // Test it
        service.addNewBook("Effective Java");
        service.addNewBook("Clean Code");
        System.out.println("Books in library:");
        service.listAllBooks().forEach(System.out::println);

        context.close();
    }
}
