package com.jsp.bankmanagement_service;

import java.util.List;

import com.jsp.bankmanagement_dao.BankManagerDao;
import com.jsp.bankmanagement_dto.BankManager;
import com.jsp.bankmanagement_dto.Customer;

public class BankManagerService {
	BankManagerDao bankManagerDao = new BankManagerDao();

	public BankManager saveBankManager(BankManager bankManager) {
		return bankManagerDao.saveBankManager(bankManager);

	}
	public BankManager deleteBankManager(int id) {
		return bankManagerDao.deleteBankManager(id);
		
	}
	  public BankManager updateBankManager(int id,String name) {
         return bankManagerDao.updateBankManager(id, name);
		  
}
	  public BankManager updateBankManagerGmail(int id, String gmail) {
		  return bankManagerDao.updateBankManagerGmail(id, gmail);
		  
	  }
	  public BankManager updateBankManagerCno(int id, long cno) {
		  return bankManagerDao.updateBankManagerCno(id, cno);
	  }
	  public BankManager getBankManager(int id) {
		  return bankManagerDao.getBankManager(id);
	  }
	  public List<BankManager> getAllBankManager() {
		  return bankManagerDao.getAllBankManager();
	  }
	  public List<Customer> approveCustomers(int bankManagerId) {
		  return bankManagerDao.approveCustomers(bankManagerId);
	  }
	  public Customer approvedCustomer(int customerId, int bankManagerId) {
		  return bankManagerDao.approvedCustomer(customerId, bankManagerId);
	  }	
}