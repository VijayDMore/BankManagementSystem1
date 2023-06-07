package com.jsp.bankmanagement_controller;

import com.jsp.bankmanagement_dto.Admin;
import com.jsp.bankmanagement_service.AdminService;

public class GetByIdAdmin {
	public static void main(String[] args) {

		AdminService adminService = new AdminService();
		adminService.getById(4);

	}
}
