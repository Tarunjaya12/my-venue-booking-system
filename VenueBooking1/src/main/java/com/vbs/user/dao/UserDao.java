package com.vbs.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbs.user.model.User;

public interface UserDao extends JpaRepository<User,String> {



}
