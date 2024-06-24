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
import java.util.Optional;
import java.util.UUID;

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

    @PutMapping("/authors/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable(value = "id")UUID id, @RequestBody @Valid AuthorDTO authorDTO){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        Author author = optionalAuthor.get();
        BeanUtils.copyProperties(authorDTO,author);
        return ResponseEntity.status(HttpStatus.OK).body(authorRepository.save(author));
    }


}
