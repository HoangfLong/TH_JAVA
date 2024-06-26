package com.example.TH_buoi3.services;

import com.example.TH_buoi3.entity.Book;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TH_buoi3.repository.IBookRepository;

import java.util.List;

@Service
public class BookService {
//  @Autowired là một annotation trong Spring dùng để tự động tiêm (inject) các bean vào các thuộc tính, constructor hoặc phương thức trong một class
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book) { bookRepository.save(book); }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
