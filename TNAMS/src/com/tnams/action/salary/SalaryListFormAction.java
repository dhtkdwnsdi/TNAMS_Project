package com.tnams.action.salary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.SalaryDAO;
import com.tnams.vo.SalaryVO;

public class SalaryListFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/salary/list.jsp";

      SalaryDAO dao = SalaryDAO.getInstance();

      ArrayList<SalaryVO> salaryList = dao.getSalaryList();

      request.setAttribute("salaryList", salaryList);

      System.out.println(salaryList);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }
}