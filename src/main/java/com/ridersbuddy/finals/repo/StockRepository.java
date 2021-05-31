package com.ridersbuddy.finals.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.ridersbuddy.finals.model.Stock;

public interface StockRepository extends MongoRepository<Stock, String>
{
	//List<Stock> findByStatus(String bikestatus);
}
