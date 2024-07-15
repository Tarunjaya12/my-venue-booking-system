package com.vbs.user.service;

import javax.servlet.http.HttpServletRequest;

import com.vbs.user.model.Payment;

public interface PaymentService {
	

	public Payment makePayment(HttpServletRequest request,Payment payment);

	public int bookingPayment(HttpServletRequest request);

}
