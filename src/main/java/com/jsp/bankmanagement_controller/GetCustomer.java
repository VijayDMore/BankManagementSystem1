package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class GetCustomer {
public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	
	//enter the customer id
	customerService.getCustomer(2);
}
}
