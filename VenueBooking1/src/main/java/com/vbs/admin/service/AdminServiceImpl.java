package com.vbs.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbs.admin.dao.AdminDao;
import com.vbs.admin.dao.AdminProfileDao;
import com.vbs.admin.exception.AdminAlreadyExistsException;
import com.vbs.admin.exception.AdminNotFoundException;
import com.vbs.admin.model.Admin;
import com.vbs.admin.model.AdminProfile;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminProfileDao adminProfileDao;
	
	@Override
	public boolean saveAdmin(Admin admin,AdminProfile adminProfile) {
		// TODO Auto-generated method stub
		String emailId = admin.getEmailId();
		boolean result = adminDao.existsById(emailId);
		if(!result) {
		adminDao.save(admin);
		adminProfileDao.save(adminProfile);
		}else {
			throw new AdminAlreadyExistsException("701","Admin Already Exists.");
		}
		
		return true;
	}

	@Override
	public Admin adminLogin(String emailId,String password) {
		// TODO Auto-generated method stub
		boolean result = adminDao.existsById(emailId);
		if(result) {
		Admin admin = adminDao.findById(emailId).get();
		if(admin.getEmailId().equalsIgnoreCase(emailId) && admin.getPassword().contentEquals(password)) {
			return admin;
		}
		return null;
		}else {
			throw new AdminNotFoundException("702","Admin Not Found Exception");
		}
	}

	@Override
	public AdminProfile saveAdminProfile(AdminProfile adminProfile) {
		// TODO Auto-generated method stub
		adminProfileDao.save(adminProfile);
		String emailId = adminProfile.getEmailId();
		AdminProfile adminProfile1 = adminProfileDao.findById(emailId).get();
		return adminProfile1;
	}

	@Override
	public boolean updateAdminPassword(String emailId, String newPassword) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.findById(emailId).get();
		admin.setPassword(newPassword);
		adminDao.save(admin);
		return true;
	}

	@Override
	public AdminProfile getAdminProfile(String emailId) {
		// TODO Auto-generated method stub
		AdminProfile adminProfile = adminProfileDao.findById(emailId).get();
		if(adminProfile != null) {
			return adminProfile;
		}
		return null;
	}

}
