package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.BankManagerService;

public class GetBankManager {
	public static void main(String[] args) {
		BankManagerService bankManagerService = new BankManagerService();
		bankManagerService.getBankManager(1);
	}
}