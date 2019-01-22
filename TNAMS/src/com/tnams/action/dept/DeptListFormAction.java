package com.tnams.action.dept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.DeptDAO;
import com.tnams.vo.DeptVO;

public class DeptListFormAction implements Action{

   
   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
      System.out.println("deptListForm액션 진입!!");

      
      String url = "/dept/list.jsp";
      
      DeptDAO dDao = DeptDAO.getInstance();
      
      ArrayList<DeptVO> deptList = (ArrayList<DeptVO>) dDao.selectDept();
      
      request.setAttribute("list", deptList);
      
      System.out.println(deptList);
      
      
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
      
   }
   
   

}