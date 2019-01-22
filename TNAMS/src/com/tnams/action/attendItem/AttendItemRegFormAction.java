package com.tnams.action.attendItem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

/*
 * 근태항목번호, 근태명, 휴가여부, 유/무급
 *화면설계 확인해서 Form수정 완료
 */

public class AttendItemRegFormAction implements Action {

	 public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      
	   String url = "/user/register.jsp";
	      
	   AttendItemVO aVo = new AttendItemVO();
	      
	   //입력받아온 name과 파라미터
	      
	      aVo.setAttendItemNum(request.getParameter("setAttendItemNum"));
	      aVo.setAttendName(request.getParameter("setAttendName"));
	      aVo.setVacation(request.getIntHeader("setVacation"));
	      aVo.setPaid(request.getIntHeader("paid"));


	      AttendItemDAO aDao = AttendItemDAO.getInstance();
	      aDao.insertAttendItem(aVo);
	   
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	   }

	
}
	 
