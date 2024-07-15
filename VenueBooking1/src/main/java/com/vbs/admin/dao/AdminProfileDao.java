package com.vbs.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbs.admin.model.AdminProfile;

public interface AdminProfileDao extends JpaRepository<AdminProfile,String> {

}
