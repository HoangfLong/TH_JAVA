package com.example.TH_Buoi2;

import com.example.TH_Buoi2.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Book> getBooks() {
        List<Book> listBooks = new ArrayList<>();

        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Clean Code");
        book1.setAuthor("Robert");
        book1.setPrice(2000.0);
        book1.setCategory("Sofware Engineering");
        listBooks.add(book1);

        Book book2 = new Book(2,"Design Pattern","Erich",55.5,"Sofware");

//        Book book2 = Book.builder()
//                .id(2)
//                .title("Design Patterns: Elements of Reusuable Object-Oriented Software")
//                .author("Erich Gramma")
//                .price(55.0)
//                .category("Sofware Design")
//                .build();
//        listBooks.add(book2);

        Book book3 = Book.builder()
                .id(3)
                .title("Effective Java")
                .author("Joshua Bloch")
                .price(45.0)
                .category("Programming")
                .build();
        listBooks.add(book3);
        return listBooks;
    }
}
