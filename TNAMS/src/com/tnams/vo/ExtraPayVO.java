package com.tnams.vo;

public class ExtraPayVO {

	private String extraPayNum;
	private String empNum;
	private String salaryNum;
	private String paymentDate;
	private String price;
	private String extraPayRemarks;
	public String getExtraPayNum() {
		return extraPayNum;
	}
	public void setExtraPayNum(String extraPayNum) {
		this.extraPayNum = extraPayNum;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getSalaryNum() {
		return salaryNum;
	}
	public void setSalaryNum(String salaryNum) {
		this.salaryNum = salaryNum;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getExtraPayRemarks() {
		return extraPayRemarks;
	}
	public void setExtraPayRemarks(String extraPayRemarks) {
		this.extraPayRemarks = extraPayRemarks;
	}
	@Override
	public String toString() {
		return "ExtraPayVO [extraPayNum=" + extraPayNum + ", empNum=" + empNum + ", salaryNum=" + salaryNum
				+ ", paymentDate=" + paymentDate + ", price=" + price + ", extraPayRemarks=" + extraPayRemarks + "]";
	}

	
}