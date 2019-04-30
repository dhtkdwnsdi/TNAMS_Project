package com.tnams.action.emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.EmpDAO;
import com.tnams.vo.EmpVO;

public class EmpModifySelfAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String url ="/login.do";
		
		String empPw = request.getParameter("empPw");
		request.setAttribute("empPw", empPw);
		
		String empNum = request.getParameter("empNum");
		request.setAttribute("empNum", empNum);
		
		String empName = request.getParameter("empName");
		request.setAttribute("empName", empName);
		
		String deptNum = request.getParameter("deptNum");
		request.setAttribute("deptNum", deptNum);
		
		String empPosition = request.getParameter("empPosition");
		request.setAttribute("empPosition", empPosition);
		
		String birthday = request.getParameter("birthday");
		request.setAttribute("birthday", birthday);
		
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		
		String hp = request.getParameter("hp");
		request.setAttribute("hp", hp);
		
		String startWork = request.getParameter("startWork");
		request.setAttribute("startWork", startWork);
		
		String endWork = request.getParameter("endWork");
		request.setAttribute("endWork", endWork);
		
		String zipCode = request.getParameter("zipCode");
		request.setAttribute("zipCode", zipCode);
		
		String frontAddr = request.getParameter("frontAddr");
		request.setAttribute("frontAddr", frontAddr);
		
		String rearAddr = request.getParameter("rearAddr");
		request.setAttribute("rearAddr", rearAddr);
		
		String finalEducation = request.getParameter("finalEducation");
		request.setAttribute("finalEducation", finalEducation);
		
		String finalSchool = request.getParameter("finalSchool");
		request.setAttribute("finalSchool", finalSchool);
		
		System.out.println("empPw :" + empPw );
		System.out.println("empNum :" + empNum );
		System.out.println("empName :" + empName );
		System.out.println("deptNum :" + deptNum );
		System.out.println("empPosition :" + empPosition );
		System.out.println("birthday :" + birthday );
		System.out.println("email :" + email );
		System.out.println("hp :" + hp );
		System.out.println("startWork :" + startWork );
		System.out.println("endWork :" + endWork );
		System.out.println("zipCode :" + zipCode );
		System.out.println("frontAddr :" + frontAddr );
		System.out.println("rearAddr :" + rearAddr );
		System.out.println("finalEducation :" + finalEducation );
		System.out.println("finalSchool :" + finalSchool );
		
		EmpVO eVo = new EmpVO();
		
		
		eVo.setEmpPw(empPw);
		eVo.setEmpNum(empNum);
		eVo.setEmpName(empName);
		eVo.setDeptNum(deptNum);
		eVo.setEmpPosition(empPosition);
		eVo.setBirthday(birthday);
		eVo.setEmail(email);
		eVo.setHp(hp);
		eVo.setStartWork(startWork);
		eVo.setEndWork(endWork);
		eVo.setZipCode(zipCode);
		eVo.setFrontAddr(frontAddr);
		eVo.setRearAddr(rearAddr);
		eVo.setFinalEducation(finalEducation);
		eVo.setFinalSchool(finalSchool);
		
		
		EmpDAO eDao = EmpDAO.getInstance();
		eDao.updateEmpSelf(eVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
