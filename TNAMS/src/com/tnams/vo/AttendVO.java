package com.tnams.vo;



public class AttendVO {

   

   private String attendanceNum;
   private String attendItemNum;
   private String empNum;
   private String startDate;
   private String endDate;
   private String attendanceRemarks;
   private String approved;

   
   public String getAttendanceNum() {
      return attendanceNum;
   }

   public void setAttendanceNum(String attendanceNum) {
      this.attendanceNum = attendanceNum;
   }

   public String getAttendItemNum() {
      return attendItemNum;
   }

   public void setAttendItemNum(String attendItemNum) {
      this.attendItemNum = attendItemNum;
   }

   public String getEmpNum() {
      return empNum;
   }

   public void setEmpNum(String empNum) {
      this.empNum = empNum;
   }

   public String getStartDate() {
      return startDate;
   }

   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }

   public String getEndDate() {
      return endDate;
   }

   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }

   public String getAttendanceRemarks() {
      return attendanceRemarks;
   }

   public void setAttendanceRemarks(String attendanceRemarks) {
      this.attendanceRemarks = attendanceRemarks;
   }

   public String getApproved() {
      return approved;
   }

   public void setApproved(String approved) {
      this.approved = approved;
   }

   
   
   
   @Override
   public String toString() {
      return "AttendanceVO [attendanceNum=" + attendanceNum + ", attendItemNum=" + attendItemNum + ", empNum="
            + empNum + ", startDate=" + startDate + ", approved=" + approved + "]";
   }

}