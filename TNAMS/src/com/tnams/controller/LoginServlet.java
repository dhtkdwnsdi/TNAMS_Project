package com.tnams.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.dao.EmpLoginDAO;
import com.tnams.vo.EmpLoginVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 화면으로 이동
		doPost(request,response);
		/*String url = "index.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//아이디 비밀번호 받은 후 Mapping
		
		String url = "main?command=main";
		
		
		if(request.getSession().getAttribute("LoginUser") != null) {
			
			System.out.println("======> " + request.getSession().getAttribute("LoginUser"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	
		} else {
			//아이디 비밀번호 받아서 처리
			EmpLoginVO eVo = new EmpLoginVO();
			EmpLoginDAO eDao = EmpLoginDAO.getInstance();
			
			eVo.setEmpId(request.getParameter("empId"));
			eVo.setEmpPw(request.getParameter("empPw"));
			
			System.out.println(eDao.loginCheck(eVo));
			
			switch (eDao.loginCheck(eVo)) {
			
				case 1: 
				{
					request.getSession().setAttribute("LoginUser", eVo.getEmpId());
					url = "main?command=main";
					break;
				}
				
				
				case 0: {
					request.setAttribute("message", "비밀번호를 확인하세요"); 
					url = "main?command=loginForm";
					break;
				}
				case -1: {					
					request.setAttribute("message", "존재하지 않는 회원입니다");
					url = "main?command=loginForm";
					break;
				}
				
				default : request.setAttribute("message", "오류가 발생했습니다");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	}
		
		
		
		
	}

