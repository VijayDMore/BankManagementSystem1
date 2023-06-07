package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class UpdateCustomer {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();

		// enter the customerId and update field
		customerService.updateCustomerName(1, "sahil");
		customerService.updateCustomerEmail(1, "sahilmore@gmail.com");
		customerService.updateCustomerCno(1, 8935245445l);

	}
}
