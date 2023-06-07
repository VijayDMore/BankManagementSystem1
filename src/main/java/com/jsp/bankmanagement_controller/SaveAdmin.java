package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dto.Admin;
import com.jsp.bankmanagement_service.AdminService;

public class SaveAdmin {
public static void main(String[] args) {
	Admin admin=new Admin();
	admin.setName("kisan");
	admin.setEmail("kisanchorge@gmail.com");
	admin.setC_no(622452456l);
	admin.setName("vijay");
	admin.setEmail("vijbdgvd@124");
	admin.setC_no(25415247);
	AdminService adminService=new AdminService();
	adminService.saveAdmin(admin);
}
}
