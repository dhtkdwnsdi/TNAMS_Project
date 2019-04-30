package com.tnams.action.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.EmpDAO;
import com.tnams.vo.EmpVO;

public class EmpSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String url = "/apply/searchEmp.jsp";
		
		EmpDAO eDao = EmpDAO.getInstance();
		
		String empName = request.getParameter("empName");
		
		request.setAttribute("empName", empName);

		System.out.println("empName : " + empName);
		
		List<EmpVO> empList = eDao.searchEmp(empName);
		
		request.setAttribute("empList", empList);
		
		System.out.println(empList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
