package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dto.BankAccount;
import com.jsp.bankmanagement_service.CustomerService;

public class SaveBankAccount {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();

		// Enter the account number
		bankAccount.setAccount_no(45465632);

		// Enter the ifsc_code
		bankAccount.setIfsc("MAHB9825");

		// Enter the amount
		bankAccount.setBalance(5215);

		CustomerService customerService = new CustomerService();

		// Enter the bankAccount and customerId
		customerService.saveBankAccount(bankAccount, 4);
	}
}
