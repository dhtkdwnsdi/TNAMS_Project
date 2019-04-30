package com.tnams.action.extraPay;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.ExtraPayDAO;
import com.tnams.vo.ExtraPayVO;


public class ExtraPayRegistAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, Exception {

	   String url= "/extraPay?command=extraPayListForm";
	   
      
      //String ExtraPayNum = request.getParameter("ExtraPayNum"); //시퀀스로 숫자 올림
       String empNum = request.getParameter("empNum");
       String salaryNum = request.getParameter("salaryNum");
       String paymentDate = request.getParameter("paymentDate");
       String price = request.getParameter("price");
       String extraPayRemarks = request.getParameter("extraPayRemarks");
       
       ExtraPayVO eVo = new ExtraPayVO();
      
       //eVo.setExtraPayNum(ExtraPayNum);
       eVo.setEmpNum(empNum);
       eVo.setSalaryNum(salaryNum);
       eVo.setPaymentDate(paymentDate);
       eVo.setPrice(price);
       eVo.setExtraPayRemarks(extraPayRemarks);
       
       //System.out.println("ExtraPayNum  : " + ExtraPayNum); //시퀀스로 숫자 올림
       System.out.println("EmpNum : " + eVo.getEmpNum());
       System.out.println("SalaryNum : " + eVo.getSalaryNum());
       System.out.println("PaymentDate : " + eVo.getPaymentDate());
       System.out.println("Price : " + eVo.getPrice());
       System.out.println("ExtraPayRemarks : " + eVo.getExtraPayRemarks());
       
       
       ExtraPayDAO eDao = ExtraPayDAO.getInstance();
       
       eDao.insertExtraPay(eVo);
      
       RequestDispatcher dispatcher = request.getRequestDispatcher(url);
       dispatcher.forward(request, response);

   }

}