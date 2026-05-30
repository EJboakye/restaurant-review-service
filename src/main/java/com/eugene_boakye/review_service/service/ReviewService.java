package com.eugene_boakye.review_service.service;

import com.eugene_boakye.review_service.model.Review;
import com.eugene_boakye.review_service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review review = getReviewById(id);

        review.setComment(updatedReview.getComment());
        review.setRating(updatedReview.getRating());
        review.setRestaurantName(updatedReview.getRestaurantName());

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        getReviewById(id);
        reviewRepository.deleteById(id);
    }
}