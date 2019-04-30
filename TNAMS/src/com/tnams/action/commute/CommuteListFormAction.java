package com.tnams.action.commute;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.CommuteDAO;
import com.tnams.vo.CommuteVO;

public class CommuteListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String url = "/commute/list.jsp";
		
		CommuteDAO cDao = CommuteDAO.getInstance();
		String LoginUser = (String)request.getSession().getAttribute("LoginUser");
		
		List<CommuteVO> commuteList = cDao.selectCommute(LoginUser);
		
		request.setAttribute("commuteList", commuteList);
		
		System.out.println(commuteList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
