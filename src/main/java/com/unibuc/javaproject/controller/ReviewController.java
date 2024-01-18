package com.unibuc.javaproject.controller;

import com.unibuc.javaproject.dto.ReviewRequest;
import com.unibuc.javaproject.mapper.ReviewMapper;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Review;
import com.unibuc.javaproject.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@Validated
@RequestMapping("reviews")
public class ReviewController {
    private ReviewService reviewService;
    private ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper){
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewRequest reviewRequest){
        Review review = reviewMapper.map(reviewRequest);
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity
                .created(URI.create("/reviews/" + createdReview.getId()))
                .body(createdReview);
    }
    @GetMapping()
    public List<Review> getAll(){return reviewService.getAll();}

    @GetMapping("/id/{id}")
    public Review getReview(@PathVariable Long id) {
        return reviewService.getById(id);
    }

    @GetMapping("/avgRating")
    public Double getAverageRatingOfEvent(@RequestBody Event event){ return reviewService.getAverageRatingOfEvent(event);}
}
