
package com.tnams.vo;

public class CommuteVO {

	private String workDate;
	private String empNum;
	private String goToWorkTime;
	private String offWorkTime;
	private String commuteRemarks;
	
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
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
		return "CommuteVO [workDate=" + workDate + ", empNum=" + empNum + ", goToWorkTime=" + goToWorkTime
				+ ", offWorkTime=" + offWorkTime + ", commuteRemarks=" + commuteRemarks + "]";
	}
	

}
