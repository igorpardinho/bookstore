package com.bookstore.controller;

import com.bookstore.dto.BookDTO;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
    }


    @PostMapping("/books")
    public ResponseEntity<Book> saveBooks(@RequestBody @Valid BookDTO bookDTO){
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO,book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepository.save(book));
    }


}
