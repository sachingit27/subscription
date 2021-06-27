package com.sac.subscription.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sac.subscription.dao.Subsdao;
import com.sac.subsscription.entity.Order;
import com.sac.subsscription.entity.Payment;
import com.sac.subsscription.entity.TransactionRequest;
import com.sac.subsscription.entity.TransactionResponse;
import com.sac.subsscription.entity.Userprofile;

@Service
public class Subsservice {
	
	private Logger logger = LogManager.getLogger(Subsservice.class);

	@Autowired
	private Subsdao dao;

	@Autowired
	private RestTemplate template;

	public String addUserProfile(Userprofile usr) throws ClassNotFoundException, SQLException {
		logger.info("Add user Metho invoked");
		String serviceresult = dao.addUserProfile(usr);
		return serviceresult;
	}

	public List<Userprofile> showUsers() {
		logger.info("Show user Method invoked");
		List<Userprofile> userlist = dao.showUsers();
		return userlist;
	}

	public String enrollMember(TransactionRequest request) {
		logger.info("Enroll Member Method invoked");

		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setAmount(49.00);
		payment.setEmailid(order.getEmailid());

		TransactionResponse tranResponse = template.postForObject("http://localhost:9091//subs/payment", payment, TransactionResponse.class);

		String newtime = "23:59:59";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime now = LocalDateTime.now();

		String startdt = dtf.format(now);

		LocalDate newdate = LocalDate.now().plusMonths(6);

		String enddt = newdate + newtime;

		order.setStartDate(startdt);
		order.setEndDate(enddt);
		
		System.out.println("Payment Status :" +tranResponse.getPaymentResponse());
		
		if (tranResponse.getPaymentResponse().equals("Success")) {

			String memberstatus = dao.enrollMember(order);
			return memberstatus;
		} else {
			return "Failure in Payment process";
		}

	}

}
