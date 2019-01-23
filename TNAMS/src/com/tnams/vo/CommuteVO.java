
package com.tnams.vo;

public class CommuteVO {
	
	private String commuteNum;
	private String workDate;
	private String empName;
	private String goToWorkTime;
	private String offWorkTime;
	private String commuteRemarks;
	
	
	public String getCommuteNum() {
		return commuteNum;
	}
	public void setCommuteNum(String commuteNum) {
		this.commuteNum = commuteNum;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGoToWorkTime() {
		return goToWorkTime;
	}
	public void setGoToWorkTime(String goToWorkTime) {
		this.goToWorkTime = goToWorkTime;
	}
	public String getOffWorkTime() {
		return offWorkTime;
	}
	public void setOffWorkTime(String offWorkTime) {
		this.offWorkTime = offWorkTime;
	}
	public String getCommuteRemarks() {
		return commuteRemarks;
	}
	public void setCommuteRemarks(String commuteRemarks) {
		this.commuteRemarks = commuteRemarks;
	}
	@Override
	public String toString() {
		return "CommuteVO [commuteNum=" + commuteNum + ", workDate=" + workDate + ", empName=" + empName
				+ ", goToWorkTime=" + goToWorkTime + ", offWorkTime=" + offWorkTime + ", commuteRemarks="
				+ commuteRemarks + "]";
	}
	
	
	

}
