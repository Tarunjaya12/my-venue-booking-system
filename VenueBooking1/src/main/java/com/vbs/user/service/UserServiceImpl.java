package com.vbs.user.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbs.user.dao.UserDao;
import com.vbs.user.dao.UserProfileDao;
import com.vbs.user.exception.UserAlreadyExistsException;
import com.vbs.user.exception.UserNotFoundException;
import com.vbs.user.model.User;
import com.vbs.user.model.UserProfile;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserProfileDao userProfileDao; 
	
	@Override
	public boolean saveUser(User user,UserProfile profile) {
		// TODO Auto-generated method stub
		String emailId = user.getEmailId();
		boolean result = userDao.existsById(emailId);
		if(!result) {
		userDao.save(user);
		userProfileDao.save(profile);
		return true;
		}else {
			throw new UserAlreadyExistsException("703","User Already Exists.");
		}
		
		
	}

	@Override
	public User userLogin(String emailId,String password) {
		// TODO Auto-generated method stub
		boolean result = userDao.existsById(emailId);
		if(result) {
		User user = userDao.findById(emailId).get();
		System.out.println(user.getPassword());
		System.out.println(user.getPassword().contentEquals(password));
		if(user.getEmailId().equalsIgnoreCase(emailId) && user.getPassword().contentEquals(password)) {
			return user;
		}else {
		return null;}
		}
		else {
			throw new UserNotFoundException("704","User Not Found.");
		}
		
	}

	@Override
	public UserProfile saveProfile(UserProfile profile) {
		// TODO Auto-generated method stub
		userProfileDao.save(profile);
		String emailId = profile.getEmailId();
		UserProfile userProfile = userProfileDao.findById(emailId).get();
		return userProfile;
	}

	@Override
	public boolean updatePassword(String emailId, String newPassword) {
		// TODO Auto-generated method stub
		User user = userDao.findById(emailId).get();
		user.setPassword(newPassword);
		userDao.save(user);
		return true;
	}

	@Override
	public UserProfile getUserProfile(String emailId) {
		// TODO Auto-generated method stub
		UserProfile userProfile = userProfileDao.findById(emailId).get();
		if(userProfile != null) {
			return userProfile;
		}
		return null;
	}

		
}
