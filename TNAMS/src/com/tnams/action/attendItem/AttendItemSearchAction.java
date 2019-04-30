package com.tnams.action.attendItem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

public class AttendItemSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
	
		String url = "/apply/searchAttendItem.jsp";
		
		AttendItemDAO aiDao = AttendItemDAO.getInstance();
		
		String attendName = request.getParameter("attendName");
		
		request.setAttribute("attendName", attendName);
		
		List<AttendItemVO> list = aiDao.searchAttendItem(attendName);
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
