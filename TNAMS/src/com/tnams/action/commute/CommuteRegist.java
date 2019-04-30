package com.tnams.action.commute;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.CommuteDAO;
import com.tnams.vo.CommuteVO;

public class CommuteRegist implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub


		String goToWorkTime = request.getParameter("goToWorkTime");
		String offWokrTime = request.getParameter("offWokrTime");
		String commuteRemarks = request.getParameter("commuteRemarks");
		
		String LoginUser = (String)request.getSession().getAttribute("LoginUser");
		
		CommuteVO cVo = new CommuteVO();
		cVo.setEmpName(LoginUser);
		cVo.setGoToWorkTime(goToWorkTime);
		cVo.setOffWorkTime(offWokrTime);
		cVo.setCommuteRemarks(commuteRemarks);
		
		
		CommuteDAO.getInstance().insertCommute(cVo);;
		
		
		new CommuteListFormAction().execute(request, response);
	}

}
