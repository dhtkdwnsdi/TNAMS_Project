package com.tnams.action.extraPay;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.ExtraPayDAO;
import com.tnams.vo.ExtraPayVO;

public class ExtraPayModifyFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, Exception {
      
	   
	  String url = "/extraPay/modify.jsp";

	  ExtraPayDAO epDao = ExtraPayDAO.getInstance();
	  
      String extraPayNum = request.getParameter("extraPayNum");

      request.setAttribute("extraPayNum", extraPayNum);

      ExtraPayVO epVo = epDao.readOnExtraPayByNum(extraPayNum);
      
      request.setAttribute("epVo", epVo);
      
     

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}