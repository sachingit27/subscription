package com.sac.subsscription.entity;

public class Payment {

	private int paymentid;
	private double amount;
	private String transactionid;
	private String emailid;

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", amount=" + amount + ", transactionid=" + transactionid
				+ ", emailid=" + emailid + "]";
	}

}
