package com.tnams.action.attendItem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;


/*
 * 근태항목번호, 근태명, 휴가여부, 유/무급
 *화면설계 확인해서 Form수정 완료
 */

public class AttendItemRegFormAction implements Action {
   
   
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // TODO Auto-generated method stub
         System.out.println("attendItemRegForm 액션 진입!!");
         System.out.println("userItem/register.jsp");
       
           String url = "user/register.jsp";
         
         

         RequestDispatcher dispatcher = request.getRequestDispatcher(url);
         dispatcher.forward(request, response);
      }

   
}
    