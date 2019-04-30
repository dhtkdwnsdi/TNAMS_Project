package com.tnams.action.attend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendDAO;
import com.tnams.vo.AttendVO;

public class AttendDeleteAction implements Action {

	private Object attendNumIndivi;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("근태  삭제 액션 진입");

		String[] attendCheck = request.getParameterValues("attendCheck");

		for (String string : attendCheck) {

			System.out.println("근태 번호 : " + string);
		}

		String attendNumIndivi = "";

		AttendDAO aDao = AttendDAO.getInstance();

		for (int i = 0; i < attendCheck.length; i++) {

			System.out.println("attendCheck : " + attendCheck[i]);

			attendNumIndivi = attendCheck[i];

			// 객체 셋팅
			AttendVO aVo = new AttendVO();
			aVo.setAttendanceNum((String) attendNumIndivi);

			int res = aDao.deleteAttend(attendNumIndivi);

			if (res == 1) {
				request.setAttribute("msg", "SUCCESS");
			} else {
				request.setAttribute("msg", "FAIL");
			}
		}

		new AttendListAction().execute(request, response);

	}

	//

	public Object getAttendNumIndivi() {
		return attendNumIndivi;
	}

	public void setAttendItemNumIndivi(Object AttendItemNumIndivi) {
		this.attendNumIndivi = AttendItemNumIndivi;
	}

}