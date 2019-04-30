package com.tnams.action.salary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.SalaryDAO;

public class SalaryCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "salary/check.jsp";
		String salaryNum = null;

		// 한글로 입력 받았을 때 받을 수 있도록 하기 위함
		if (request.getParameter("popup").equals("yes")) {

			salaryNum = request.getParameter("salaryNum");

		} else {
			salaryNum = new String(request.getParameter("salaryNum").getBytes("8859_1"), "UTF-8");

		}

		System.out.println("레그넘 = " + salaryNum);
		SalaryDAO sDao = SalaryDAO.getInstance();

		int result = sDao.confirmSalaryNum(salaryNum);

		System.out.println(result);
		request.setAttribute("salaryNum", salaryNum);
		request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
