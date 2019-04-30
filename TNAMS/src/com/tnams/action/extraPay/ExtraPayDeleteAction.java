package com.tnams.action.extraPay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.ExtraPayDAO;
import com.tnams.vo.ExtraPayVO;
public class ExtraPayDeleteAction implements Action{

   private Object extraPayIndivi;
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, Exception {
      
String[] extraPayCheck = request.getParameterValues("extraPayCheck");
      
      for (String string : extraPayCheck) {
         System.out.println("수당 번호 : " + string);
      }
      
      String extraPayNumIndivi ="";

      ExtraPayDAO eDao = ExtraPayDAO.getInstance();
      
      
         for(int i=0; i<extraPayCheck.length; i++) {   
         
            
         System.out.println("extraPayCheck : " + extraPayCheck[i]);
         extraPayNumIndivi = extraPayCheck[i];
         
         
         //객체 셋팅
         ExtraPayVO eVo = new ExtraPayVO();
         eVo.setExtraPayNum(extraPayNumIndivi);
      
         
         int res = eDao.deleteExtraPay(extraPayNumIndivi);
         
         if(res == 1) {
            request.setAttribute("msg", "SUCCESS");
         }else {
            request.setAttribute("msg", "FAIL");
         }
      }
         
         
         new ExtraPayListFormAction().execute(request, response);
      
   }
   

}