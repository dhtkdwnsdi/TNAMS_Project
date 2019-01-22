package com.tnams.action.attendItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

public class AttendItemListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/user/list.jsp";

		AttendItemDAO aDao = AttendItemDAO.getInstance();

		List<AttendItemVO> attendItemList = new ArrayList<AttendItemVO>();

		// 조회
		attendItemList = aDao.selectAllAttendItem();
		request.setAttribute("attendItemList", attendItemList);
		System.out.println(attendItemList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);// url을
		// 찍어줘야됨
		dispatcher.forward(request, response);
	
	
	}

}
