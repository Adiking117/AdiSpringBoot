package com.adi.reviewms.review.dao;

import com.adi.reviewms.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDAO extends JpaRepository<Review,Long> {

}
