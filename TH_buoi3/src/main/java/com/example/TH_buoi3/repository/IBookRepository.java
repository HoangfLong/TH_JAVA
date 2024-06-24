package com.example.TH_buoi3.repository;

import com.example.TH_buoi3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository là một interface trong Spring Data JPA cung cấp các phương thức CRUD cơ bản
public interface IBookRepository extends JpaRepository<Book, Long> {

}