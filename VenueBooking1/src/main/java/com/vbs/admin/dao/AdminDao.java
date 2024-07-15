package com.vbs.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbs.admin.model.Admin;

public interface AdminDao extends JpaRepository<Admin,String> {

}
