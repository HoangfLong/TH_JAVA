package com.example.TH_buoi3.controller;

import com.example.TH_buoi3.entity.Book;
import com.example.TH_buoi3.services.BookService;
import com.example.TH_buoi3.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "book/list";
    }
    //Thêm 1 cuốn sách
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBookForm(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Xử lý các lỗi xác thực ở đây (ví dụ: trả về trang nhập liệu với thông báo lỗi)
            return "book/add";
        }
        // Nếu không có lỗi xác thực, thực hiện thêm sách vào cơ sở dữ liệu
        bookService.addBook(book);
        return "redirect:/books";
    }
}
