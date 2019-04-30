package com.tnams.action.attendItem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

public class AttendItemUpdateFormAction implements Action{

   
     @Override
      public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        System.out.println("attendItemUpdateForm 액션 진입!!");
        
         String url = "/user/modify.jsp";
         
       
         String attendItemNum = request.getParameter("attendItemNum");
         
         System.out.println("attendItemNum :" + attendItemNum);
         
         AttendItemVO aVo= AttendItemDAO.getInstance().selectAttendItem(attendItemNum);
         
         request.setAttribute("aVo", aVo);
         
         System.out.println(aVo);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher(url);
         dispatcher.forward(request, response);
   
     }
}