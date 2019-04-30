package com.tnams.vo;

public class EmpLoginVO {

	private String EmpId;
	private String EmpPw;
	
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpPw() {
		return EmpPw;
	}
	public void setEmpPw(String empPw) {
		EmpPw = empPw;
	}
	
	@Override
	public String toString() {
		return "EmpLoginVO [EmpId=" + EmpId + ", EmpPw=" + EmpPw + "]";
	}
	
	

	
}

