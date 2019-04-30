package com.tnams.action.salary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.SalaryDAO;
import com.tnams.vo.SalaryVO;

public class SalaryModifyAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String url = "/salary?command=salaryListForm";

      String salaryNum = request.getParameter("salaryNum");
      request.setAttribute("salaryNum", salaryNum);

      String salaryName = request.getParameter("salaryName");
      request.setAttribute("salaryName", salaryName);

      String taxed = request.getParameter("taxed");
      request.setAttribute("taxed", taxed);

      System.out.println("salaryNum :" + salaryNum);
      System.out.println("salaryName :" + salaryName);
      System.out.println("taxed :" + taxed);

      SalaryVO salVo = new SalaryVO();
      salVo.setSalaryNum(salaryNum);

      salVo.setSalaryName(salaryName);
      salVo.setTaxed(taxed);

      SalaryDAO salDao = SalaryDAO.getInstance();

//      request.setAttribute("salarytVO", salVo);

      salDao.updateSalary(salVo);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}