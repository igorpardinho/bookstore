package com.bookstore.controller;

import com.bookstore.dto.ReviewDTO;
import com.bookstore.model.Review;
import com.bookstore.repository.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(){
        return ResponseEntity.status(HttpStatus.OK).body(reviewRepository.findAll());
    }

    @PostMapping("/review")
    public ResponseEntity<Review> saveReview(@RequestBody @Valid ReviewDTO reviewDTO){
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO,review);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewRepository.save(review));
    }

}
