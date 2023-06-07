package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.BankManagerService;

public class DeleteBankManager {
public static void main(String[] args) {
	BankManagerService bankManagerService=new BankManagerService();
	bankManagerService.deleteBankManager(5);
}
}
