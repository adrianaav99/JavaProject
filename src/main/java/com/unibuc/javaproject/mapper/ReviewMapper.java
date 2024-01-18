package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.ReviewRequest;
import com.unibuc.javaproject.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review map(ReviewRequest reviewRequest){
        Review review = new Review();
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());
        review.setEvent(reviewRequest.getEvent());
        review.setParticipant(reviewRequest.getParticipant());
        return review;
    }
}
