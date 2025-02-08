package com.adi.library.customer.DAO;

import com.adi.library.customer.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends MongoRepository<Customer,String> {
}
