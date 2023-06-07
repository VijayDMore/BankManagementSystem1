package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.BankManagerService;

public class UpdateBankManager {
	public static void main(String[] args) {
		BankManagerService bankManagerService = new BankManagerService();

		bankManagerService.updateBankManager(1, "rahul");
		bankManagerService.updateBankManagerGmail(1, "rahulmore@gmail.com");
		bankManagerService.updateBankManagerCno(1, 2564711544l);
	}
}
