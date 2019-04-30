package com.tnams.action.attend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendDAO;
import com.tnams.vo.AttendVO;

public class AttendListAction implements Action{

   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      System.out.println("attendList 액션 진입!!");
      
      String url = "attend/list.jsp";

      AttendDAO aDao = AttendDAO.getInstance();

      List<AttendVO> attendList = new ArrayList<AttendVO>();

      // 조회
      attendList = aDao.selectAllAttend();
      request.setAttribute("attendList", attendList);
      System.out.println(attendList);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);// url을
      // 찍어줘야됨
      dispatcher.forward(request, response);
   
   
   }
   
}