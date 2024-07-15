package com.vbs.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbs.user.model.Payment;

public interface PaymentDao extends JpaRepository<Payment,String> {

}
