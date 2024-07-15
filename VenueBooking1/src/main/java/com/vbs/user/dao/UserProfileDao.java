package com.vbs.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbs.user.model.UserProfile;

public interface UserProfileDao extends JpaRepository<UserProfile,String> {

}
