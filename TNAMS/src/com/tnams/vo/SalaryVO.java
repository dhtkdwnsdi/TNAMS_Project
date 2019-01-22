package com.tnams.vo;

public class SalaryVO {

	private String salaryNum;
	private String salaryName;
	private String taxed;

	public String getSalaryNum() {
		return salaryNum;
	}

	public void setSalaryNum(String salaryNum) {
		this.salaryNum = salaryNum;
	}

	public String getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(String salaryName) {
		this.salaryName = salaryName;
	}

	public String getTaxed() {
		return taxed;
	}

	public void setTaxed(String taxed) {
		this.taxed = taxed;
	}

	@Override
	public String toString() {
		return "SalaryVO [salaryNum=" + salaryNum + ", salaryName=" + salaryName + ", taxed=" + taxed + "]";
	}

}