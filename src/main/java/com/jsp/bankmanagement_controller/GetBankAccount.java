package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dao.CustomerDao;
import com.jsp.bankmanagement_dto.Customer;
import com.jsp.bankmanagement_service.CustomerService;

public class GetBankAccount {
	public static void main(String[] args) {
   CustomerDao  customerDao=new CustomerDao();
  customerDao.getBankAccount(2);
    
	}
}
