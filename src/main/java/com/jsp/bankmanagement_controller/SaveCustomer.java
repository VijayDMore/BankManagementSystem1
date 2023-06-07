package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dto.Customer;
import com.jsp.bankmanagement_service.BankManagerService;
import com.jsp.bankmanagement_service.CustomerService;

public class SaveCustomer {
	public static void main(String[] args) {
		Customer customer = new Customer();

		customer.setStatus("Approved");
		customer.setName("arbaz");
		customer.setEmail("arbazdesai@gmail.com");
		customer.setC_no(8098723544l);
		customer.setAdhar_no(253652654855l);

		CustomerService customerService = new CustomerService();
		customerService.saveCustomer(customer);

	}
}
