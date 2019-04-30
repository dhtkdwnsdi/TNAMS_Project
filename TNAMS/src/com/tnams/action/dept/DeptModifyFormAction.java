package com.tnams.action.dept;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;

public class DeptModifyFormAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String url = "/dept/modify.jsp";
      
      String dept_num = request.getParameter("dept_num");
      request.setAttribute("dept_num", dept_num);
      
      
      String dept_name = request.getParameter("dept_name");
      request.setAttribute("dept_name", dept_name);
      
      String dept_phonenum = request.getParameter("dept_phonenum");
      request.setAttribute("dept_phonenum", dept_phonenum);
      
      System.out.println("dept_num :" + dept_num + " dept_name: " + dept_name + " dept_phonenum: " + dept_phonenum);
      
      
      
      
      
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
      
   }
   
   

}