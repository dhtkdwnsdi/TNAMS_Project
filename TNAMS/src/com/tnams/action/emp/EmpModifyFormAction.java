package com.tnams.action.emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.EmpDAO;
import com.tnams.vo.EmpVO;

public class EmpModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub

		String url = "emp/modify.jsp";

		EmpDAO eDao = EmpDAO.getInstance();

		String empNum = request.getParameter("empNum");

		request.setAttribute("empNum", empNum);

		System.out.println("empNum : " + empNum);


		EmpVO eVo = eDao.readEmp(empNum);

		request.setAttribute("eVo", eVo);

		System.out.println(eVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
