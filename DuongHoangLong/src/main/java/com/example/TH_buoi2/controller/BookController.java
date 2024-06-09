package com.example.TH_buoi2.controller;
import com.example.TH_buoi2.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private List<Book> listBook;

    @GetMapping("/")
    public String showAllBooks(Model model) {
        model.addAttribute("listBook", listBook);
        model.addAttribute("title", "Danh sách cuốn sách");

        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "book/add";
        }
        listBook.add(book);
        return "redirect:/";
    }
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @Valid @ModelAttribute("book") Book updatedBook, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Trả về trang chỉnh sửa với thông tin cuốn sách và thông báo lỗi nếu có
            model.addAttribute("book", updatedBook);
            return "book/edit";
        }
        // Tìm cuốn sách cần chỉnh sửa trong danh sách hoặc từ cơ sở dữ liệu
        for (Book book : listBook) {
            if (book.getId() == (id)) {
                // Cập nhật thông tin cuốn sách
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setCategory(updatedBook.getCategory());
                // Lưu thay đổi và chuyển hướng về trang chủ
                return "redirect:/";
            }
        }
        // Nếu không tìm thấy cuốn sách, trả về lỗi 404 hoặc xử lý theo cách khác
        return "error-404"; // Hoặc thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn
    }
}
