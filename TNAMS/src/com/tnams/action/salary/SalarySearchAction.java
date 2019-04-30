package com.tnams.action.salary;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.SalaryDAO;
import com.tnams.vo.SalaryVO;

public class SalarySearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String url = "/apply/searchSalary.jsp";
		
		SalaryDAO salDao = SalaryDAO.getInstance();
		
		String salaryName = request.getParameter("salaryName");
		
		request.setAttribute("salaryName", salaryName);

		System.out.println("salaryName : " + salaryName);
		
		List<SalaryVO> list = salDao.searchSalary(salaryName);
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
