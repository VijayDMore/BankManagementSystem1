package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class DepositeAmount {
public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	
	
	//Enter the customerId , bankAccountId and amount
			customerService.depositAmount(2, 1, 10000);
	
}
}
