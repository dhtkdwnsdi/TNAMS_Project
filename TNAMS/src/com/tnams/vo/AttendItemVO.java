package com.tnams.vo;

public class AttendItemVO {

   /**
    * 근태 항목 번호, 근태명, 휴가여부, 유/무급
    * 
    */
   private String attendItemNum;
   private String attendName;
   private String vacation; //number 0/1
   private String paid;

   public String getAttendItemNum() {
      return attendItemNum;
   }

   public void setAttendItemNum(String attendItemNum) {
      this.attendItemNum = attendItemNum;
   }

   public String getAttendName() {
      return attendName;
   }

   public void setAttendName(String attendName) {
      this.attendName = attendName;
   }

   public String getVacation() {
      return vacation;
   }

   public void setVacation(String vacation) {
      this.vacation = vacation;
   }

   public String getPaid() {
      return paid;
   }

   public void setPaid(String paid) {
      this.paid = paid;
   }

   @Override
   public String toString() {
      return "AttendItemVO [attendItemNum=" + attendItemNum + ", attendName=" + attendName + ", vacation="
            + vacation + ", paid=" + paid + "]";
   }

}