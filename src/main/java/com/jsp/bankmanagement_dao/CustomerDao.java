package com.jsp.bankmanagement_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagement_dto.BankAccount;
import com.jsp.bankmanagement_dto.BankStatement;
import com.jsp.bankmanagement_dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vijay");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	BankStatement bankStatement=new BankStatement();
	//save Customer
	public Customer saveCustomer(Customer customer) {
		String sql="Select c From Customer c";
		Query query=entityManager.createQuery(sql) ;
		List<Customer> customers=query.getResultList();
		for(Customer c: customers) {
			if(c.getAdhar_no() == customer.getAdhar_no()) {
				System.out.println("customer alredy exists");
				return null;
			}
		}
		customer.setStatus("unapproved");
		entityTransaction.begin();
		entityManager.persist(customer														);
		entityTransaction.commit();
		System.out.println("customer saved successfully");
		return customer;
	}

		//delete customer
  public Customer deleteCustomer(int id) {
	  Customer customer=entityManager.find(Customer.class, id);
	  if (customer!=null) {
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		System.out.println("Customer deleted successfully");
	  }else {
		  System.out.println("customer not exist");
	  }
	  return customer;
	}
  
  //update customer name
  public Customer updateCustomerName(int id,String name) {
	  Customer customer=entityManager.find(Customer.class,id);
	  customer.setName(name);
	  if(customer!=null) {
		  entityTransaction.begin();
		  entityManager.merge(customer);
		  entityTransaction.commit();
	  }
	  return customer;
	  
	  }
  
  // update customer email
	public Customer updateCustomerEmail(int id, String Email) {
		Customer c = entityManager.find(Customer.class, id);
		c.setEmail(Email);
		if (c != null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}

	// update customer contact number
	public Customer updateCustomerCno(int id, long cno) {
		Customer c = entityManager.find(Customer.class, id);
		c.setC_no(cno);
		if (c != null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
		}
		return c;
	}

	// get particular customer details
	public Customer getCustomer(int id) {
		Customer c = entityManager.find(Customer.class, id);
		if (c != null) {
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getEmail());
			System.out.println(c.getC_no());
			System.out.println(c.getStatus());
		} else {
			System.out.println("Customer not exist");
		}
		return c;
	}

	// get all customers details
	public List<Customer> getAllCustomer() {
		String sql = "Select c from Customer c";
		Query query = entityManager.createQuery(sql);
		List<Customer> customers = query.getResultList();

		for (Customer c : customers) {
			System.out.println("====================");
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getEmail());
			System.out.println(c.getC_no());
			System.out.println(c.getStatus());
		}
		return customers;
	}

	// save bankAccount
	public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
		Customer c = entityManager.find(Customer.class, customerId);
		bankAccount.setCustomer(c);
		bankAccount.setAccount_no(45465632 + customerId); // For unique account number

		String sql = "Select b from BankAccount b";
		Query query = entityManager.createQuery(sql);
		List<BankAccount> bankAccounts = query.getResultList();
		for (BankAccount b : bankAccounts) {
			if (b.getAccount_no() == bankAccount.getAccount_no()) {
				System.out.println("BankAccount already exist for this customer");
				return null;
			}
	}
		if (c.getStatus().equals("Approved")) {
			if (bankAccount.getBalance() > 499) {
				entityTransaction.begin();
				entityManager.persist(bankAccount);
				entityTransaction.commit();
				System.out.println("BankAccount added Successfully");
			}else {
				System.out.println("Minimum 500 should be deposit for create bankAccount");
			}
		} else {
			System.out.println("Customer is not Approved");
		}
		return bankAccount;
	}

	// delete bankAccount
	public BankAccount deleteBankAccount(int id) {
		BankAccount b = entityManager.find(BankAccount.class, id);
		if (b != null) {
			entityTransaction.begin();
			entityManager.remove(b);
			entityTransaction.commit();
			System.out.println("BankAccount deleted successfully");
		} else {
			System.out.println("BankAccount not exist");
		}
		return b;
	}

	// get particular bankAccount details
	public BankAccount getBankAccount(int id) {
		BankAccount b = entityManager.find(BankAccount.class, id);
		if (b != null) {
			System.out.println(b.getId());
			System.out.println(b.getAccount_no());
			System.out.println(b.getIfsc());
			System.out.println(b.getBalance());
		} else {
			System.out.println("BankAccount not exist");
		}
		return b;
	}

	// get all bankAccounts details
	public List<BankAccount> getAllBankAccounts() {
		String sql = "Select b from BankAccount b";
		Query query = entityManager.createQuery(sql);
		List<BankAccount> bankAccount = query.getResultList();
		for (BankAccount b : bankAccount) {
			System.out.println("=====================");
			System.out.println(b.getId());
			System.out.println(b.getAccount_no());
			System.out.println(b.getIfsc());
			System.out.println(b.getBalance());
		}
		return bankAccount;
	}
	// deposit amount
		public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
			Customer c = entityManager.find(Customer.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (amount > 0) {
					b.setBalance(b.getBalance() + amount);
				    bankStatement.setBid(bankAccountId);
					bankStatement.setDetails("Deposited : Rs." + amount + " to your Account no:" + b.getAccount_no());

					entityTransaction.begin();
					entityManager.merge(b);
					entityManager.persist(bankStatement);
					entityTransaction.commit();
					System.out.println("Amount deposited successfully");
				} else {
					System.out.println("Invalid amount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}
		
		// credit amount
		public BankAccount creditAmount(int customerId, int bankAccountId, double amount) {
			Customer c = entityManager.find(Customer.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (b.getCustomer().getId() == customerId) {
					if (amount < b.getBalance() && amount > 0) {
						b.setBalance(b.getBalance() - amount);
						bankStatement.setBid(bankAccountId);
						bankStatement.setDetails("Credited : Rs." + amount + " from your Account no:" + b.getAccount_no());

						entityTransaction.begin();
						entityManager.merge(b);
						entityManager.persist(bankStatement);
						entityTransaction.commit();
						System.out.println("Amount credited successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}
		
		// transfer amount
		public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
			Customer c = entityManager.find(Customer.class, customerId);
			BankAccount b1 = entityManager.find(BankAccount.class, creditorId);
			BankAccount b2 = entityManager.find(BankAccount.class, depositorId);
			if (c.getStatus().equals("Approved")) {
				if (b1.getCustomer().getId() == customerId) {
					if (amount > 0 && b1.getBalance() > amount) {
						b1.setBalance(b1.getBalance()- amount);
						bankStatement.setBid(creditorId);
						bankStatement.setDetails("Credited  : Rs." + amount + " from your Account no:" + b1.getAccount_no());
						
						b2.setBalance(b2.getBalance()+ amount);
						BankStatement bankStatement=new BankStatement();
						bankStatement.setBid(depositorId);
						bankStatement.setDetails("Deposited : Rs." + amount + " by Account no :" + b1.getAccount_no());
						
						entityTransaction.begin();
						entityManager.merge(b1);
						entityManager.merge(b2);
						entityManager.persist(bankStatement);
						entityManager.persist(bankStatement);
						entityTransaction.commit();
						System.out.println("Amount transfer successfully");
					}else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return  b1;
		}

	// statement of bankAccounts
	public List<BankStatement> bankAccountStatement(int bankAccountId) {
		String sql = "Select s from BankStatement s";
		Query query = entityManager.createQuery(sql);

		List<BankStatement> s = query.getResultList();
		System.out.println("Statement of BankAccount Id : "+bankAccountId);
		for (BankStatement res : s) {
			if(bankAccountId == res.getBid()) {
				System.out.println(res.getDetails());
			}
		}
		return s;

	}
}


  
  

  



	

