package com.tnams.action.salary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.SalaryDAO;
import com.tnams.vo.SalaryVO;

public class SalaryRegistAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String url = "/salary?command=salaryListForm";

      // 요청 된 jsp 에서 Parameter 가져오기
      // String salaryNum = request.getParameter("salaryNum");
      String salaryName = request.getParameter("salaryName");
      String taxed = request.getParameter("taxed");

      // Parameter 출력
      // System.out.println("salaryNum : " + salaryNum);
      System.out.println("salaryName : " + salaryName);
      System.out.println("taxed : " + taxed);

      // SalaryVO 객체 생성
      SalaryVO salVo = new SalaryVO();

      // 객체 세팅
      // salVo.setSalaryNum(salaryNum);
      salVo.setSalaryName(salaryName);
      salVo.setTaxed(taxed);

      SalaryDAO salDao = SalaryDAO.getInstance();

      salDao.insertSalary(salVo);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }

}