package com.jsp.bankmanagement_service;

import java.util.List;

import com.jsp.bankmanagement_dao.CustomerDao;
import com.jsp.bankmanagement_dto.BankAccount;
import com.jsp.bankmanagement_dto.BankStatement;
import com.jsp.bankmanagement_dto.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();

	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);

	}

	public Customer deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}

	public Customer updateCustomerName(int id, String name) {
		return customerDao.updateCustomerName(id, name);
	}

	public Customer updateCustomerEmail(int id, String email) {
		return customerDao.updateCustomerEmail(id, email);
	}

	public Customer updateCustomerCno(int id, long cno) {
		return customerDao.updateCustomerCno(id, cno);
	}

	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
		return customerDao.saveBankAccount(bankAccount, customerId);
	}

	public BankAccount deleteBankAccount(int id) {
		return customerDao.deleteBankAccount(id);
	}

	public BankAccount getBankAccount(int id) {
		return customerDao.getBankAccount(id);
	}

	public List<BankAccount> getAllBankAccounts() {
		return customerDao.getAllBankAccounts();
	}

	public List<BankStatement> bankAccountStatement(int bankAccountId) {
		return customerDao.bankAccountStatement(bankAccountId);
	}

	public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.depositAmount(customerId, bankAccountId, amount);
	}

	public BankAccount creditAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.creditAmount(customerId, bankAccountId, amount);
	}

	public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
		return customerDao.transferAmount(customerId, creditorId, depositorId, amount);
	}

}
