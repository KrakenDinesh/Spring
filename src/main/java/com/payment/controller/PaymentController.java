package com.payment.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.repository.CustomersRepository;
import com.payment.repository.TransactionRepository;
import com.payment.domain.Customers;
import com.payment.domain.Transaction;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private final CustomersRepository customerRepo;
	private final TransactionRepository transactionRepo;

	public PaymentController(CustomersRepository customerRepo, TransactionRepository transactionRepo) {
		super();
		this.customerRepo = customerRepo;
		this.transactionRepo = transactionRepo;
	}

	@GetMapping("/customers")
	public List<Customers> getCustomers() {
		return customerRepo.findAll();
	}
	@GetMapping("/transactions")
	public List<Transaction> getTranasactions() {
		return transactionRepo.findAll();
	}

	@GetMapping("/customer/{id}")
	public Customers getCustomer(@PathVariable String id) {
		return customerRepo.findById(id).orElseThrow(RuntimeException::new);

	}

	// update
	@PutMapping("/customer/{id}")
	public ResponseEntity updateCustomers(@PathVariable String id, @RequestBody Customers customer) {
		Customers currentCustomers = customerRepo.findById(id).orElseThrow(RuntimeException::new);
		currentCustomers.setClearbalance(customer.getClearbalance());
		return ResponseEntity.ok(currentCustomers);
	}

	// delete
	@DeleteMapping("/{id}")
	public String deleteCustomers(@PathVariable String id) {
		customerRepo.deleteById(id);
		return "Deleted";
	}

	@PutMapping("/{id1}-&&-{id2}/{amount}")
	public ResponseEntity transaction(@PathVariable String id1, @PathVariable String id2, @PathVariable Double amount) {
		Customers sender = customerRepo.findById(id1).orElseThrow(RuntimeException::new);
		Customers receiver = customerRepo.findById(id2).orElseThrow(RuntimeException::new);
		debit(sender, amount);
		credit(receiver, amount);
		customerRepo.save(sender);
		customerRepo.save(receiver);
		return saveTransaction(sender, receiver);
	}
	private ResponseEntity saveTransaction(Customers sender,Customers receiver) {
		Transaction currentTransaction = new Transaction();
		currentTransaction.setCustomerId(sender.getCustomerid());
		currentTransaction.setReceiverAccountHolderName(receiver.getAccountholdername());
		currentTransaction.setReceiverAccountHolderNumber(receiver.getCustomerid());
		currentTransaction.setTrasferDate(new Date(System.currentTimeMillis()));
		transactionRepo.save(currentTransaction);
		return ResponseEntity.ok(currentTransaction);
	}

	private void debit(Customers customer, double amount) {
		 double balance = customer.getClearbalance();
		if (customer.isOverdraftflag() || balance >= amount) {
			balance -= amount;
			customer.setClearbalance(balance);
		}
	}

	private void credit(Customers customer, double amount) {
		double balance = customer.getClearbalance();
		balance += amount;
		customer.setClearbalance(balance);
	}
}
