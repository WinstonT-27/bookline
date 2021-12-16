package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Review;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public boolean alreadyReviewed(String userId, Book book){
        if(book.getBookReview().isEmpty()){
            return false;
        }
        for(Review review: book.getBookReview()){
            if(review.getUserId().equals(userId)){
                return true;
            }
        }
        return false;
    }
}
