package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class GetAllCustomer {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();

		customerService.getAllCustomer();
	}
}
