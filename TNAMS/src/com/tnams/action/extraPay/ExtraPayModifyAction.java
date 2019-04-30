package com.tnams.action.extraPay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.action.dept.DeptListFormAction;
import com.tnams.dao.ExtraPayDAO;
import com.tnams.vo.ExtraPayVO;

public class ExtraPayModifyAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, Exception {
      String url = "/extraPay?command=extraPayListForm";

      ExtraPayVO eVo = new ExtraPayVO();

      String extraPayNum = request.getParameter("extraPayNum");
      String empNum = request.getParameter("empNum");
      String salaryNum = request.getParameter("salaryNum");
      String paymentDate = request.getParameter("paymentDate");
      String price = request.getParameter("price");
      String extraPayRemarks = request.getParameter("extraPayRemarks");

       System.out.println("extraPayNum  : " + eVo.getExtraPayNum());
       System.out.println("empNum : " + eVo.getEmpNum());
       System.out.println("salaryNum : " + eVo.getSalaryNum());
       System.out.println("paymentDate : " + eVo.getPaymentDate());
       System.out.println("price : " + eVo.getPrice());
       System.out.println("extraPayRemarks : " + eVo.getExtraPayRemarks());
      
      
      //객체 셋팅
       eVo.setExtraPayNum(extraPayNum);
       eVo.setEmpNum(empNum);
       eVo.setSalaryNum(salaryNum);
       eVo.setPaymentDate(paymentDate);
       eVo.setPrice(price);
       eVo.setExtraPayRemarks(extraPayRemarks);

      request.setAttribute("ExtraPayVO", eVo);

      System.out.println(eVo);
      
      //실제 데이터 Update DAO
      ExtraPayDAO.getInstance().updateExtraPay(eVo);
      request.setAttribute("msg", "부서를 수정했습니다");

      
      
      request.setAttribute("ExtraPayVO", eVo);
      
      
      new DeptListFormAction().execute(request, response);
      
   }
   


}