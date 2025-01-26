package com.adi.reviewms.review.service;

import com.adi.reviewms.review.dao.ReviewDAO;
import com.adi.reviewms.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewDAO reviewDAO;

    @Override
    public List<Review> getAllReviews() {
        return reviewDAO.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return reviewDAO.findById(id).orElse(null);
    }



    @Override
    public Review createReview(Review review) {
        reviewDAO.save(review);
        return review;
    }

    @Override
    public List<Review> getReviewsByComapny(long companyId) {
        return getAllReviews().stream().filter(r -> r.getCompanyId() == companyId).toList();
    }

    @Override
    public Review updateReview(long id, Review review) {
        Optional<Review> reviewToUpdate = reviewDAO.findById(id);
        if(reviewToUpdate.isPresent()){
            Review r = reviewToUpdate.get();
            r.setName(review.getName());
            r.setDescription(review.getDescription());
            r.setRating(review.getRating());
            reviewDAO.save(r);
            return r;
        }
        return null;
    }

    @Override
    public boolean deleteReview(long id) {
        try {
            reviewDAO.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
