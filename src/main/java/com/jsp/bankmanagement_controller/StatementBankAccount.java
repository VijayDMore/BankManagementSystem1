package com.jsp.bankmanagement_controller;



import com.jsp.bankmanagement_dto.BankStatement;
import com.jsp.bankmanagement_service.CustomerService;

public class StatementBankAccount {
	public static void main(String[] args) {
   CustomerService statement=new CustomerService();
     //enter bank Account id
   statement.bankAccountStatement(2);
   
	}

}
