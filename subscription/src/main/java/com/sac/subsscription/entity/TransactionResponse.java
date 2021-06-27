package com.sac.subsscription.entity;

public class TransactionResponse {
	
	private double amount;	
	private String transactionId;
	private String emailId;	
	private String paymentResponse;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPaymentResponse() {
		return paymentResponse;
	}
	public void setPaymentResponse(String paymentResponse) {
		this.paymentResponse = paymentResponse;
	}
	
	@Override
	public String toString() {
		return "TransactionResponse [amount=" + amount + ", transactionId=" + transactionId + ", emailId=" + emailId
				+ ", paymentResponse=" + paymentResponse + "]";
	}

}
