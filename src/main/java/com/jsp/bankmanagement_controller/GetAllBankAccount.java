package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dao.CustomerDao;


public class GetAllBankAccount {
	public static void main(String[] args) {
		CustomerDao customerDao=new CustomerDao(); 
		customerDao.getAllBankAccounts();
	}
}
