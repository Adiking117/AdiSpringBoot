package com.adi.reviewms.review.service;


import com.adi.reviewms.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(long id);
    Review createReview(Review review);
    List<Review> getReviewsByComapny(long companyId);
    Review updateReview(long id,Review review);
    boolean deleteReview(long id);
}
