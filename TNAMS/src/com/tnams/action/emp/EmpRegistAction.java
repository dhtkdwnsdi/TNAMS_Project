package com.tnams.action.emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.EmpDAO;
import com.tnams.vo.EmpVO;

public class EmpRegistAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String url = "/emp?command=empListForm";
		
		// regist.jsp 에서 Parameter 가져오기
		String empName = request.getParameter("empName");
		String deptNum = request.getParameter("deptNum");
		String empPosition = request.getParameter("empPosition");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String hp = request.getParameter("hp");
		String startWork = request.getParameter("startWork");
		String zipCode = request.getParameter("zipCode");
		String frontAddr = request.getParameter("frontAddr");
		String rearAddr = request.getParameter("rearAddr");
		String finalEducation = request.getParameter("finalEducation");
		String finalSchool = request.getParameter("finalSchool");
		
		//Parameter 출력
		System.out.println("empName : " + empName);
		System.out.println("deptNum : " + deptNum);
		System.out.println("empPosition : " + empPosition);
		System.out.println("birthday : " + birthday);
		System.out.println("email : " + email);
		System.out.println("hp : " + hp);
		System.out.println("startWork : " + startWork);
		System.out.println("zipCode : " + zipCode);
		System.out.println("frontAddr : " + frontAddr);
		System.out.println("rearAddr : " + rearAddr);
		System.out.println("finalEducation : " + finalEducation);
		System.out.println("finalSchool : " + finalSchool);
		
		// EmpVO 객체 생성
		EmpVO eVo = new EmpVO();
		
		// 객체 세팅
		eVo.setEmpName(empName);
		eVo.setDeptNum(deptNum);
		eVo.setEmpPosition(empPosition);
		eVo.setBirthday(birthday);
		eVo.setEmail(email);
		eVo.setHp(hp);
		eVo.setStartWork(startWork);
		eVo.setZipCode(zipCode);
		eVo.setFrontAddr(frontAddr);
		eVo.setRearAddr(rearAddr);
		eVo.setFinalEducation(finalEducation);
		eVo.setFinalSchool(finalSchool);
		
		// EmpDAO 싱글톤패턴 객체 생성
		EmpDAO eDao = EmpDAO.getInstance();
		
		// eVo 객체 eDao 객체의 메소드에 담기
		eDao.insertEmp(eVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
