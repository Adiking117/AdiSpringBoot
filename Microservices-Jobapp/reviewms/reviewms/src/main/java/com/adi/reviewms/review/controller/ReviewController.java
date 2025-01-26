package com.adi.reviewms.review.controller;

import com.adi.reviewms.review.Response.ReviewResponse;
import com.adi.reviewms.review.model.Review;
import com.adi.reviewms.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

    private ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewsOfComapany(@RequestParam long companyId){
        return ResponseEntity.ok(reviewService.getReviewsByComapny(companyId));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable long reviewId){
        return ResponseEntity.ok(new ReviewResponse("Review Fetched",reviewService.getReviewById(reviewId)));
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<ReviewResponse> addReview(@RequestBody Review review){
        if(reviewService.createReview(review) != null){
            return ResponseEntity.ok(new ReviewResponse("Review added",review));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{reviewId}/update")
    public ResponseEntity<ReviewResponse> updateReview(@PathVariable long reviewId, @RequestBody Review review){
        if(reviewService.updateReview(reviewId,review) != null){
            return ResponseEntity.ok(new ReviewResponse("Review has been updated",review));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{reviewId}/delete")
    public ResponseEntity<String> deleteCompany(@PathVariable long reviewId){
        if(reviewService.deleteReview(reviewId)){
            return ResponseEntity.ok("Review has been deleted");
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
