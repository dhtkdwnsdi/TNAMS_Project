package com.tnams.action.salary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;

public class SalaryModifyFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String url = "/salary/modify.jsp";

      String salaryNum = request.getParameter("salaryNum");
      request.setAttribute("salaryNum", salaryNum);

      String salaryName = request.getParameter("salaryName");
      request.setAttribute("salaryName", salaryName);

      String taxed = request.getParameter("taxed");
      request.setAttribute("taxed", taxed);

      System.out.println("salaryNum :" + salaryNum + " salaryName: " + salaryName + " taxed: " + taxed);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}