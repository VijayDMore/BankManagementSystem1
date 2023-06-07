package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.BankManagerService;

public class CustomerApproved {
public static void main(String[] args) {
	BankManagerService  bankManagerService=new BankManagerService();
	
	//For approved all customers
			//Enter the bankManagerId
			//bankManagerService.approveCustomers(2);
			
			//For approved particular customer
			//Enter the customerId and bankManagerId
			bankManagerService.approvedCustomer(3, 2);
		}
	

}

