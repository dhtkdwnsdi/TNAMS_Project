package com.tnams.action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.DeptDAO;
import com.tnams.dao.EmpDAO;
import com.tnams.vo.DeptVO;
import com.tnams.vo.EmpVO;

public class EmpDeleteAction implements Action {

   private Object empNumIndivi;

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      System.out.println("진입");

      String[] empCheck = request.getParameterValues("empCheck");

      for (String string : empCheck) {
         System.out.println("직원번호 : " + string);
      }

      String empNumIndivi = "";

      EmpDAO eDao = EmpDAO.getInstance();

      for (int i = 0; i < empCheck.length; i++) {

         System.out.println("empCheck : " + empCheck[i]);
         empNumIndivi = empCheck[i];

         // 객체 셋팅
         EmpVO eVo = new EmpVO();
         eVo.setEmpNum((String) empNumIndivi);

         int res = eDao.deleteEmp(empNumIndivi);

         if (res == 1) {
            request.setAttribute("msg", "SUCCESS");
         } else {
            request.setAttribute("msg", "FAIL");
         }
      }

      new EmpListFormAction().execute(request, response);

   }

}