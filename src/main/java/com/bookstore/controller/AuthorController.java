package com.bookstore.controller;

import com.bookstore.dto.AuthorDTO;
import com.bookstore.model.Author;
import com.bookstore.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorController {

    private final AuthorRepository authorRepository;
    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> saveAuthor(@RequestBody @Valid AuthorDTO authorDTO){
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO,author);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorRepository.save(author));
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findAll());

    }


}
