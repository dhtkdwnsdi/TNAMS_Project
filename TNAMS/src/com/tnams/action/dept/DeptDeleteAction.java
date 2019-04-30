package com.tnams.action.dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.DeptDAO;
import com.tnams.vo.DeptVO;

public class DeptDeleteAction implements Action{

   private Object deptNumIndivi;
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      System.out.println("진입");
      
      String[] deptCheck = request.getParameterValues("deptCheck");
      
      for (String string : deptCheck) {
         System.out.println("부서번호 : " + string);
      }
      
      String deptNumIndivi ="";

      DeptDAO dDao = DeptDAO.getInstance();
      
      
         for(int i=0; i<deptCheck.length; i++) {   
         
            
         System.out.println("deptCheck : " + deptCheck[i]);
         deptNumIndivi = deptCheck[i];
         
         
         //객체 셋팅
         DeptVO dVo = new DeptVO();
         dVo.setDept_num((String)deptNumIndivi);
      
         int res = dDao.deleteDept(deptNumIndivi);
         
         if(res == 1) {
            request.setAttribute("msg", "SUCCESS");
         }else {
            request.setAttribute("msg", "FAIL");
         }
      }
         
         
         new DeptListFormAction().execute(request, response);
      
   }
   
   

}
