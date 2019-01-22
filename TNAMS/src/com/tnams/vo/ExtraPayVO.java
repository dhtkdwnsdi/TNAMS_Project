package com.tnams.vo;

public class ExtraPayVO {
   
   private String ExtraPayNum;
   private String EmpNum;
   private String SalaryNum;
   private String PaymentDate;
   private int Price;
   private String ExtraPayRemarks;
   
   public String getExtraPayNum() {
      return ExtraPayNum;
   }
   public void setExtraPayNum(String extraPayNum) {
      ExtraPayNum = extraPayNum;
   }
   public String getEmpNum() {
      return EmpNum;
   }
   public void setEmpNum(String empNum) {
      EmpNum = empNum;
   }
   public String getSalaryNum() {
      return SalaryNum;
   }
   public void setSalaryNum(String salaryNum) {
      SalaryNum = salaryNum;
   }
   public String getPaymentDate() {
      return PaymentDate;
   }
   public void setPaymentDate(String paymentDate) {
      PaymentDate = paymentDate;
   }
   public int getPrice() {
      return Price;
   }
   public void setPrice(int price) {
      Price = price;
   }
   public String getExtraPayRemarks() {
      return ExtraPayRemarks;
   }
   public void setExtraPayRemarks(String extraPayRemarks) {
      ExtraPayRemarks = extraPayRemarks;
   }
   @Override
   public String toString() {
      return "ExtraPayVO [ExtraPayNum=" + ExtraPayNum + ", EmpNum=" + EmpNum + ", SalaryNum=" + SalaryNum
            + ", PaymentDate=" + PaymentDate + ", Price=" + Price + ", ExtraPayRemarks=" + ExtraPayRemarks + "]";
   }
   
   

}