package com.ridersbuddy.finals.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ridersbuddy.finals.model.Customer;
import com.ridersbuddy.finals.model.Stock;
import com.ridersbuddy.finals.model.Transactions;
import com.ridersbuddy.finals.repo.CustomerRepository;
import com.ridersbuddy.finals.repo.StockRepository;
import com.ridersbuddy.finals.repo.TransactionRepository;

@Service
public class CustomerService {
	private static CustomerRepository customerrepository;
	private static StockRepository stockrepository;
	private static TransactionRepository transactionrepository;
	
	//----	CUSTOMER	----
	public CustomerService(CustomerRepository customerrepository, StockRepository stockrepository, TransactionRepository transactionrepository)
	{
		CustomerService.customerrepository = customerrepository;
		CustomerService.stockrepository = stockrepository;
		CustomerService.transactionrepository = transactionrepository;
	}

	//addCustomer
	public static Customer addCustomer(Customer customer)
	{
		Customer _customer = customerrepository.save(new Customer(customer.getLastname(),customer.getFirstname(),customer.getUsername(),customer.getPassword(),customer.getEmail(),false));
		return _customer;
	}

	//get all Customer
	public static List<Customer> getAllCustomers()
	{
		return customerrepository.findAll();
		
	}
	
	//delete Customer
	public static void deleteCustomer(String id) {
		customerrepository.deleteById(id);
	}
	
	//update customer
	public static Customer updateCustomer(String id, Customer customer) {
		Optional customerData = customerrepository.findById(id);
		
		Customer _customer = (Customer) customerData.get();
		_customer.setLastname(customer.getLastname());
		_customer.setFirstname(customer.getFirstname());
		_customer.setUsername(customer.getUsername());
		_customer.setPassword(customer.getPassword());
		_customer.setEmail(customer.getEmail());
		return _customer;
		
	}
	
	
	//----	STOCK	----
	//addStock
	public static Stock addStock(Stock stock)
	{
		Stock _stock = stockrepository.save(new Stock(stock.getBiketype(),stock.getQuantity(),stock.getPrice()));
		return _stock;
	}
	//get All Stocks
	public static List<Stock> getAllStocks()
	{
		return stockrepository.findAll();
	}
	//delete stock
	public static void deleteStock(String id)
	{		
		stockrepository.deleteById(id);
	}

	//update Stock
	//UPDATE NAKA AYAW KALIMOT!
	public static Stock updateStock(String id, Stock stock)
	{
		Optional stockData = stockrepository.findById(id);
		Stock _stock = (Stock) stockData.get();
		_stock.setQuantity(stock.getQuantity());
		_stock.setPrice(stock.getPrice());
		return stock;
		
		
	}
	
	//----- TRANSACTION ------
	//addtransaction
	public static void addTransaction(Transactions transactions) {
		transactionrepository.insert(transactions);

		
	}
	//updatetransaction
	public static void updateTransaction(Transactions transactions) {
		Transactions transaction_update = transactionrepository.findById(transactions.getId())
				.orElseThrow(()-> new RuntimeException(String.format("Cannot find ID %s", transactions.getId())));
		
		transaction_update.setStartTime(transactions.getStartTime());
		transaction_update.setEndTime(transactions.getStartTime());
		transaction_update.setDuration(transactions.getDuration());
		transaction_update.setQty(transactions.getQty());
		
		transactionrepository.save(transactions);
		
	}
	//getAlltransaction
	public static List<Transactions> getAllTransactions(){
		return transactionrepository.findAll();
	}
	
}
