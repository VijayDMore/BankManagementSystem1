package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class CreditAmount {
public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	
	//Enter the customerId , bankAccountId and amount
	customerService.creditAmount(1, 1, 1500);
}
}
