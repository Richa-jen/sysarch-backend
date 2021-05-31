package com.ridersbuddy.finals.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ridersbuddy.finals.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String>{
List<Customer> findByLastname(String lastname);
List<Customer> findByFirstname(String firstname);

}

