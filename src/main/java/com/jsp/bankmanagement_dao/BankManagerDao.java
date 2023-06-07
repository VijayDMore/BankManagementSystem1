package com.jsp.bankmanagement_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagement_dto.BankManager;
import com.jsp.bankmanagement_dto.Customer;

public class BankManagerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vijay");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//to save bankmanager
	public BankManager saveBankManager(BankManager bankManager) {
		bankManager.setStatus("unapproved");
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		return bankManager;

	}

//to delete bankmanager
	public BankManager deleteBankManager(int id) {
		BankManager bankManager = entityManager.find(BankManager.class, id);
		if (bankManager != null) {
			entityTransaction.begin();
			entityManager.remove(bankManager);
			entityTransaction.commit();
			System.out.println("bank manager delete");
		} else {
			System.out.println("bank manager not exist");
		}
		return bankManager;

	}

	// to update bank manager
	public BankManager updateBankManager(int id, String name) {
		BankManager bankManager = entityManager.find(BankManager.class, id);
		bankManager.setName(name);

		if (bankManager != null) {
			entityTransaction.begin();
			entityManager.merge(bankManager);
			entityTransaction.commit();
			System.out.println("updated successfully");

		}
		return bankManager;
	}

	// to update bankManager gmail
	public BankManager updateBankManagerGmail(int id, String gmail) {
		BankManager bankManager = entityManager.find(BankManager.class, id);
		bankManager.setGmail(gmail);

		if (bankManager != null) {
			entityTransaction.begin();
			entityManager.merge(bankManager);
			entityTransaction.commit();
			System.out.println("Updated successfully");
		}
		return bankManager;
	}

	// update bankManager contact number
	public BankManager updateBankManagerCno(int id, long cno) {
		BankManager bankManager = entityManager.find(BankManager.class, id);
		bankManager.setCno(cno);

		if (bankManager != null) {
			entityTransaction.begin();
			entityManager.merge(bankManager);
			entityTransaction.commit();
			System.out.println("Updated successfully");
		}
		return bankManager;

	}

	// get perticular bank manager details
	public BankManager getBankManager(int id) {
		BankManager bankManager = entityManager.find(BankManager.class, id);
		if (bankManager != null) {
			System.out.println(bankManager.getName());
			System.out.println(bankManager.getId());
			System.out.println(bankManager.getCno());
			System.out.println(bankManager.getGmail());
			System.out.println(bankManager.getStatus());
		} else {
			System.out.println("object not found");
		}
		return bankManager;

	}

	// get all bank managers details
	public List<BankManager> getAllBankManager() {
		String sql = "Select m FROM BankManager m ";
		Query query = entityManager.createQuery(sql);
		List<BankManager> BankManagers = query.getResultList();

		for (BankManager a : BankManagers) {
			System.out.println("=====================");
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getGmail());
			System.out.println(a.getCno());
			System.out.println(a.getStatus());
		}
		return BankManagers;
	}

	// approve all customer
	public List<Customer> approveCustomers(int bankManagerId) {
		String Sql = "Select c FROM Customer c";
		Query query = entityManager.createQuery(Sql);
		List<Customer> customers = query.getResultList();

		BankManager bankManager = entityManager.find(BankManager.class, bankManagerId);
		if (bankManager.getStatus().equals("Approved")) {
			for (Customer c : customers) {
				if (c.getStatus().equals("unapproved")) {
					c.setStatus("Approved");
					c.setBankManager(bankManager);
					entityTransaction.begin();
					entityManager.merge(c);
					entityTransaction.commit();
				}
			}

		} else {
			System.out.println("bank manager not approved");
		}
		return customers;
	}

//approve particular customer
	public Customer approvedCustomer(int customerId, int bankManagerId) {
		Customer c = entityManager.find(Customer.class, customerId);
		BankManager b = entityManager.find(BankManager.class, bankManagerId);
		if (b.getStatus().equals("Approved")) {
			if (c.getStatus().equals("unapproved")) {
				c.setStatus("Approved");
				c.setBankManager(b);
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
				System.out.println("Approved Successfully");
			} else {
				System.out.println("Customer already approved");
			}
		} else {
			System.out.println("Bankmanager is not Approved");
		}
		return c;
	}
}
