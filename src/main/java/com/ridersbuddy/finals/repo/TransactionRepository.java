package com.ridersbuddy.finals.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ridersbuddy.finals.model.Transactions;

public interface TransactionRepository extends MongoRepository<Transactions, String>{

}
