package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.AdminService;

public class BankManagerApproved {
	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		
		//enter the adminId for approve all manager
		//adminService.approvedAllManager(2);
		
		//enter the bank manager id and admin id for approve particular bank manager
	adminService.approvedBankManager(1, 2);
	}
	

}
	