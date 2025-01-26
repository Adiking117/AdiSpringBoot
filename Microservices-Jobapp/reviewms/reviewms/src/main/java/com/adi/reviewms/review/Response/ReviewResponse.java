package com.adi.reviewms.review.Response;


import com.adi.reviewms.review.model.Review;

public class ReviewResponse {
    private String message;
    private Review review;

    public ReviewResponse(String message, Review review) {
        this.message = message;
        this.review = review;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "message='" + message + '\'' +
                ", review=" + review +
                '}';
    }
}
