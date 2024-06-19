package com.bookstore.controller;

import com.bookstore.dto.PublisherDTO;
import com.bookstore.model.Publisher;
import com.bookstore.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }


    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return ResponseEntity.status(HttpStatus.OK).body(publisherRepository.findAll());
    }

    @PostMapping("/publishers")
    public ResponseEntity<Publisher>savePublishers(@RequestBody @Valid PublisherDTO publisherDTO){
        Publisher publisher = new Publisher();
        BeanUtils.copyProperties(publisherDTO,publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherRepository.save(publisher));

    }
}
