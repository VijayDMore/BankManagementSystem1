package com.jsp.bankmanagement_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bankmanagement_dto.Admin;
import com.jsp.bankmanagement_dto.BankManager;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vijay");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//To save Admin
	public Admin saveAdmin(Admin admin) {
		if (admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
		}
		return admin;
	}
	
	// To update admin name
		public Admin updateAdminName(int id, String name) {
			Admin admin = entityManager.find(Admin.class, id);
			admin.setName(name);

			if (admin != null) {
				entityTransaction.begin();
				entityManager.merge(admin);
				entityTransaction.commit();

				System.out.println("name update successfully");
			}
			return admin;
		}
		
		// update Admin Email
		public Admin updateAdminEmail(int id, String email) {
			Admin admin = entityManager.find(Admin.class, id);
			admin.setEmail(email);

			if (admin != null) {
				entityTransaction.begin();
				entityManager.merge(admin);
				entityTransaction.commit();
				System.out.println("Updated successfully");
			}
			return admin;
		}

		// To update admin contact number
				public Admin updateAdminCno(int id, long c_no) {
					Admin admin = entityManager.find(Admin.class, id);
					admin.setC_no(c_no);
					if (admin != null) {
						entityTransaction.begin();
						entityManager.merge(admin);
						entityTransaction.commit();

						System.out.println("contact number updated successfully");
					}
					return admin;
				}
				
				//To delete admin
				public boolean deleteAdmin(int id) {
					Admin admin=entityManager.find(Admin.class,id);
					if(admin!=null) {
						entityTransaction.begin();
						entityManager.remove(admin);
						entityTransaction.commit();
						System.out.println("Admin with above id deleted");
					return true;
				}else {
					System.out.println("no such id found");
					return false;
				}
				}
					
					//To get admin by id
					public Admin getById(int id) {
						Admin admin=entityManager.find(Admin.class,id);
						if(admin!=null) {
							System.out.println(admin.getId());
							System.out.println(admin.getName());
							System.out.println(admin.getC_no());
							System.out.println(admin.getEmail());
						}else
							System.out.println("no such id found");
					return admin;
}

					
					
					//To get all admin
					public List<Admin> getAllAdmin(){
						String sql="select a from Admin a";
						Query query=entityManager.createQuery(sql);
						List<Admin> admins=query.getResultList();
						for (Admin a: admins) {
							System.out.println(a.getId());
							System.out.println(a.getName());
							System.out.println(a.getC_no());
							System.out.println(a.getEmail());
						}
						return admins;
					}

					
					//approved all managers
					public List<BankManager> approvedAllManager(int adminId){
						String sql="select m from BankManager m";
						Query query=entityManager.createQuery(sql);
						List<BankManager> bankManagers=query.getResultList();
						
					Admin admin=entityManager.find(Admin.class, adminId);
					if(admin!=null) {
						for (BankManager m:bankManagers) {
							if(m.getStatus().equals("unapproved")) {
								m.setStatus("Approved");
								m.setAdmin(admin);
								
								entityTransaction.begin();
								entityManager.merge(m);
								entityTransaction.commit();
							}
						}
					}else {
						System.out.println("Admin not exists");
					}
					return bankManagers;
			}
						
			 //approved particular manager
			 public BankManager approvedBankManager(int bankManagerId,int adminId) {
				 BankManager bankManager=entityManager.find(BankManager.class,bankManagerId);
				 Admin admin=entityManager.find(Admin.class,adminId);
				 if(admin!=null) {
					 if(bankManager.getStatus().equals("unapproved")) {
						bankManager.setStatus("Approved");
						bankManager.setAdmin(admin);
						entityTransaction.begin();
						entityManager.merge(bankManager);
						entityTransaction.commit();
						System.out.println("Approved successfully");
					 }else {
						 System.out.println("Bank Manager already Approved");
					 }
				 }else {
					System.out.println("Admin not exist");
					 }
			     return bankManager;
			 }
}
