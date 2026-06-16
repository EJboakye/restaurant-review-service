package com.eugene_boakye.review_service.controller;
import com.eugene_boakye.review_service.model.Review;
import com.eugene_boakye.review_service.service.ReviewService;

import tools.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    
    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();

    }
    
    @GetMapping("/{id}")
    public Review getReview(@PathVariable Long id){
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review){
        return reviewService.createReview(review);

    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview){
        return reviewService.updateReview(id, updatedReview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }

}
