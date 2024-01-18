package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.exception.NotFoundException;
import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Review;
import com.unibuc.javaproject.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review){ return reviewRepository.save(review);}

    public Review getById(Long id){
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()){
            throw new EntityNotFoundException("Review", id);
        }
        return reviewOptional.get();
    }

    public List<Review> getAll(){ return reviewRepository.findAll();}

    public Double getAverageRatingOfEvent(Event event){
        Optional<Double> avg = reviewRepository.getAverageRatingOfEvent(event.getId());
        if(avg.isEmpty())
            throw new NotFoundException("Nu exista ratinguri pentru Event cu id " + event.getId());
        return avg.get();
    }
}
