package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.CustomerService;

public class DeleteBankAccount {
	public static void main(String[] args) {
	CustomerService customerService=new CustomerService();
	
	//Enter the bankAccountId
	customerService.deleteBankAccount(1);
}
}
