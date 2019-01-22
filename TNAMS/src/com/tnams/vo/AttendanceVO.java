package com.tnams.vo;

import java.sql.Date;


public class AttendanceVO {

   private String attendance_num;
   private String attend_item_num;
   private String emp_num;
   private Date start_date;
   private Date end_date;
   private String attendance_remarks;
   private int approved;
   
   
   public String getAttendance_num() {
      return attendance_num;
   }
   public void setAttendance_num(String attendance_num) {
      this.attendance_num = attendance_num;
   }
   public String getAttend_item_num() {
      return attend_item_num;
   }
   public void setAttend_item_num(String attend_item_num) {
      this.attend_item_num = attend_item_num;
   }
   public String getEmp_num() {
      return emp_num;
   }
   public void setEmp_num(String emp_num) {
      this.emp_num = emp_num;
   }
   public Date getStart_date() {
      return start_date;
   }
   public void setStart_date(Date start_date) {
      this.start_date = start_date;
   }
   public Date getEnd_date() {
      return end_date;
   }
   public void setEnd_date(Date end_date) {
      this.end_date = end_date;
   }
   public String getAttendance_remarks() {
      return attendance_remarks;
   }
   public void setAttendance_remarks(String attendance_remarks) {
      this.attendance_remarks = attendance_remarks;
   }
   public int getApproved() {
      return approved;
   }
   public void setApproved(int approved) {
      this.approved = approved;
   }
   
   
   
   
   @Override
   public String toString() {
      return "AttendanceVO [attendance_num=" + attendance_num + ", attend_item_num=" + attend_item_num + ", emp_num="
            + emp_num + ", start_date=" + start_date + "]";
   }
   
   
   
}