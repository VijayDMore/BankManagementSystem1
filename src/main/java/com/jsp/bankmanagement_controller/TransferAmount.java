package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class TransferAmount {
public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	
	//enter the customer id,creditor id,depositor id and amount
	customerService.transferAmount(1, 1, 2, 1000);
}
}
