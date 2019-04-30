
package com.tnams.action.salary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.SalaryDAO;
import com.tnams.vo.SalaryVO;

public class SalaryDeleteAction implements Action {

   private Object salaryNumIndivi;

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      System.out.println("진입");

      String[] salaryCheck = request.getParameterValues("salaryCheck");

      for (String string : salaryCheck) {
         System.out.println("급여항목번호 : " + string);
      }

      String salaryNumIndivi = "";

      SalaryDAO salDao = SalaryDAO.getInstance();

      for (int i = 0; i < salaryCheck.length; i++) {

         System.out.println("salaryCheck : " + salaryCheck[i]);
         salaryNumIndivi = salaryCheck[i];

         // 객체 셋팅
         SalaryVO salVo = new SalaryVO();
         salVo.setSalaryNum((String) salaryNumIndivi);

         int res = salDao.deleteSalary(salaryNumIndivi);

         if (res == 1) {
            request.setAttribute("msg", "SUCCESS");
         } else {
            request.setAttribute("msg", "FAIL");
         }
      }

      new SalaryListFormAction().execute(request, response);

   }

   //

   public Object getSalaryNumIndivi() {
      return salaryNumIndivi;
   }

   public void setSalaryNumIndivi(Object salaryNumIndivi) {
      this.salaryNumIndivi = salaryNumIndivi;
   }

}