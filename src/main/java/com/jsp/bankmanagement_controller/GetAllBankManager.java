package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.BankManagerService;

public class GetAllBankManager {
public static void main(String[] args) {
	BankManagerService bankManagerService=new BankManagerService();
	bankManagerService.getAllBankManager();
}
}
