package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_service.AdminService;

public class DeleteAdmin {
public static void main(String[] args) {
	AdminService  adminService=new AdminService();
	adminService.deleteAdmin(1);
}
}
