package com.adi.jobapp.review.service;

import com.adi.jobapp.company.model.Company;
import com.adi.jobapp.job.model.Job;
import com.adi.jobapp.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(long id);
    Review createReview(Review review);

    Review updateReview(long id,Review review);
    boolean deleteReview(long id);
}
