package com.tnams.action.attendItem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

public class AttendItemRegAction implements Action {

	 @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	 
	          System.out.println("근태항목 등록 액션 진입");
	         // AttendItemVO 객체 생성
	         AttendItemVO aVo = new AttendItemVO();
	         
	         //파라미터의 이름과 id는 같아야한다. register.jsp
	         String attendItemNum = request.getParameter("attendItemNum");
	         String attendName = request.getParameter("attendName");
	         int vacation = Integer.parseInt("vacation"); //Int형 형변환
	         int paid = Integer.parseInt("paid");
	      
	         // 객체 세팅
	         aVo.setAttendItemNum(attendItemNum);
	         aVo.setAttendName(attendName);
	         aVo.setVacation(vacation);
	         aVo.setPaid(paid);
	        
	         
	         AttendItemDAO aDao = AttendItemDAO.getInstance();
	         
	         aDao.insertAttendItem(aVo);
	         
	         new AttendItemListAction().execute(request, response);

	         
	      }
	
	
}
