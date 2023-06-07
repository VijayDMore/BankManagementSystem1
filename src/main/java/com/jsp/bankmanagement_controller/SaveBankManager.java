package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dto.BankManager;
import com.jsp.bankmanagement_service.BankManagerService;

public class SaveBankManager {
public static void main(String[] args) {
	BankManager bankManager=new BankManager();
	
	bankManager.setName("ajay");
	bankManager.setGmail("ajaybhau@gmail.com");

	bankManager.setCno(1245485754);
	bankManager.setStatus("Approved");

	
	BankManagerService bankManagerService=new BankManagerService();
	
	//bankManagerService.saveBankManager(bankManager);
	
	BankManager bankManager2=bankManagerService.saveBankManager(bankManager);
if (bankManager2!=null) {
	System.out.println("BankManager saved successfully");
	}else {
		System.out.println("BankManager not saved");
		
		
	}
}
}

