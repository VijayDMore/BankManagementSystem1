package com.jsp.bankmanagement_service;

import java.util.List;

import com.jsp.bankmanagement_dao.AdminDao;
import com.jsp.bankmanagement_dto.Admin;
import com.jsp.bankmanagement_dto.BankManager;

public class AdminService {
	AdminDao admindao = new AdminDao();

	public Admin saveAdmin(Admin admin) {
		return admindao.saveAdmin(admin);

	}
	public Admin updateAdminName(int id, String name) {
        return admindao.updateAdminName(id,name);
	}
	
	public Admin updateAdminEmail(int id,String email) {
		return admindao.updateAdminEmail(id, email);

	}
	public Admin updateAdminCno(int id, long c_no) {
		return admindao.updateAdminCno(id, c_no);
	}
	public boolean deleteAdmin(int id) {
		return admindao.deleteAdmin(id);
	}
	public Admin getById(int id) {
		return admindao.getById(id);
	}
	public List<Admin> getAllAdmin(){
		return admindao.getAllAdmin();
	}
	public List<BankManager> approvedAllManager(int adminId){
		return admindao.approvedAllManager(adminId);
		
	}
	 public BankManager approvedBankManager(int bankManagerId,int adminId) {
		 return admindao.approvedBankManager(bankManagerId, adminId);
	 }
	
	
}