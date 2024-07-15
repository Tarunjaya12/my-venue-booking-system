package com.vbs.admin.service;

import com.vbs.admin.model.Admin;
import com.vbs.admin.model.AdminProfile;

public interface AdminService {

	Admin adminLogin(String emailId, String password);

	boolean saveAdmin(Admin admin, AdminProfile adminProfile);

	public AdminProfile saveAdminProfile(AdminProfile adminProfile);

	boolean updateAdminPassword(String emailId, String newPassword);

	public AdminProfile getAdminProfile(String emailId);

}
