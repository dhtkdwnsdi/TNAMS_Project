package com.tnams.action.emp;

/**
 * @author OSJ
 */

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tnams.action.Action;
import com.tnams.dao.EmpDAO;
import com.tnams.vo.EmpVO;


public class EmpListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/emp/list.jsp";	
		
		EmpDAO eDao = EmpDAO.getInstance();
		
		List<EmpVO> empList = eDao.selectEmp();
		
		request.setAttribute("empList", empList);
		
		System.out.println(empList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
