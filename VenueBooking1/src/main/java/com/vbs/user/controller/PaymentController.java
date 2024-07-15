package com.vbs.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vbs.user.model.Payment;
import com.vbs.user.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	private PaymentService ps;
	
	
	@RequestMapping("paymentPage")
	public String paymentPage(HttpServletRequest request,Model model) {
		  String bookingId= request.getParameter("bookingId"); 
		  String venueName= request.getParameter("venueName"); 
		  String eventDate = request.getParameter("eventDate");
		  HttpSession session = request.getSession();
		  session.setAttribute("venueName", venueName);
		  session.setAttribute("bookingId", bookingId);
		  int advancePayment = ps.bookingPayment(request);
		  session.setAttribute("advancepayment", advancePayment);
		  model.addAttribute("advanceAmount",advancePayment);
		  model.addAttribute("bookingid",bookingId);
		  model.addAttribute("eventDate",eventDate);
		  return "paymentpage";
	  }
	
	@RequestMapping("makePayment")
	  public String makePayment(HttpServletRequest request,Payment payment,Model m) {
		Payment payment1 = ps.makePayment(request, payment);
		m.addAttribute("pay",payment1);
		  return "paymentSuccess";
	  }

}
