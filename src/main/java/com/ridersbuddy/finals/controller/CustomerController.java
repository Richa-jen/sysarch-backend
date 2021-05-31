package com.ridersbuddy.finals.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridersbuddy.finals.model.BikeCategory;
import com.ridersbuddy.finals.model.Customer;
import com.ridersbuddy.finals.model.Stock;
import com.ridersbuddy.finals.model.Transactions;
import com.ridersbuddy.finals.repo.CustomerRepository;
import com.ridersbuddy.finals.repo.StockRepository;
import com.ridersbuddy.finals.repo.TransactionRepository;
import com.ridersbuddy.finals.service.CustomerService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
@Autowired
	CustomerRepository customerRepository;
@Autowired	
	StockRepository stockrepository;
@Autowired
	TransactionRepository transactionrepository;

//add CUSTOMER
@PostMapping("/customers")
public Customer createCustomer(@RequestBody Customer customer) {
	return CustomerService.addCustomer(customer);
}

//get All customers
@GetMapping("/customers")
public ResponseEntity<List<Customer>> getAllCustomers()
{
	return ResponseEntity.ok(CustomerService.getAllCustomers());
	
}
//delete Customer
@DeleteMapping("/customer/{id}")
public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id)
{	
	System.out.println("Delete Customer with ID = " + id + "...");
	customerRepository.deleteById(id);
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
}
//update Customer
@PutMapping("/customer/{id}")
public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer)
{
	Optional<Customer> customerData = customerRepository.findById(id);
	
	if(customerData.isPresent())
	{
		return new ResponseEntity<>(customerRepository.save(CustomerService.updateCustomer(id, customer)), HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
//get specific customer
@GetMapping("/customer/{id}")
public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id)
{
	Optional<Customer> customerData = customerRepository.findById(id);
	if(customerData.isPresent())
	{
		return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}

}

@GetMapping("/customer/lastname/{lastname}")
public List findByLastname(@PathVariable String lastname)
{
	List customers = customerRepository.findByLastname(lastname);
	return customers;
	
}

@GetMapping("/customer/firstname/{firstname}")
public List findByFirstname(@PathVariable String firstname)
{
	List customers = customerRepository.findByFirstname(firstname);
	return customers;
	
}

//STOCK
//add STOCK
@PostMapping("/stock")
public Stock createStock(@RequestBody Stock stock)
{
	return CustomerService.addStock(stock);
	
}
//get All Stocks
@GetMapping("/stocks")
public ResponseEntity<List<Stock>> getAllStocks()
{
	return ResponseEntity.ok(CustomerService.getAllStocks());
	
}
//delete Stock
@DeleteMapping("/stock/{id}")
public ResponseEntity<HttpStatus> deleteStock(@PathVariable("id") String id)
{
	System.out.println("Delete Stock with ID = " + id + "...");
	stockrepository.deleteById(id);
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
}

//update Stock
@PutMapping("/stock/{id}")
ResponseEntity<Stock> updateStock(@PathVariable("id") String id, @RequestBody Stock stock)
{
Optional<Stock> stockData = stockrepository.findById(id);
	
	if(stockData.isPresent())
	{
		return new ResponseEntity<>(stockrepository.save(CustomerService.updateStock(id, stock)), HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

//find stock by id
@GetMapping("/stock/{id}")
public ResponseEntity<Stock> getStockById(@PathVariable("id") String id)
{
	Optional<Stock> stockData = stockrepository.findById(id);
	if(stockData.isPresent())
	{
		return new ResponseEntity<>(stockData.get(), HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
}

//addTransaction
@PostMapping("/transaction")
public ResponseEntity insertTransaction(@RequestBody Transactions transactions) {
	CustomerService.addTransaction(transactions);
	return ResponseEntity.status(HttpStatus.CREATED).build();
}
@PutMapping
public ResponseEntity updateTransactions(@RequestBody Transactions transactions) {
	CustomerService.updateTransaction(transactions);
	return ResponseEntity.ok().build();
}
@GetMapping
public ResponseEntity<List<Transactions>> getTransactions(){
	return ResponseEntity.ok(CustomerService.getAllTransactions());
}

@GetMapping("/transaction/{id}")
public ResponseEntity<Transactions> getTransactById(@PathVariable("id") String id){
	Optional<Transactions> transactData = transactionrepository.findById(id);
	if(transactData.isPresent())
	{
		return new ResponseEntity<>(transactData.get(), HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

}


