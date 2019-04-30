
package com.tnams.vo;

public class DeptVO {

   private String dept_num;
   private String dept_name;
   private String dept_phonenum;

   public String getDept_num() {
      return dept_num;
   }

   public void setDept_num(String dept_num) {
      this.dept_num = dept_num;
   }

   public String getDept_name() {
      return dept_name;
   }

   public void setDept_name(String dept_name) {
      this.dept_name = dept_name;
   }

   public String getDept_phonenum() {
      return dept_phonenum;
   }

   public void setDept_phonenum(String dept_phonenum) {
      this.dept_phonenum = dept_phonenum;
   }

   @Override
   public String toString() {
      return "DeptVO [dept_num=" + dept_num + ", dept_name=" + dept_name + ", dept_phonenum=" + dept_phonenum + "]";
   }

}