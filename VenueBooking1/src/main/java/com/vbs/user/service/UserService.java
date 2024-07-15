package com.vbs.user.service;



import com.vbs.user.model.User;
import com.vbs.user.model.UserProfile;

public interface UserService {
	
	public boolean saveUser(User user, UserProfile profile);
	
	public User userLogin(String emailId,String password);
	
	public UserProfile saveProfile(UserProfile profile);
	
	public boolean updatePassword(String emailId,String newPassword);

	public UserProfile getUserProfile(String emailId);

}
