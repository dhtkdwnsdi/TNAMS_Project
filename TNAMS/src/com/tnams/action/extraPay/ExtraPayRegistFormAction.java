package com.tnams.action.extraPay;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;

public class ExtraPayRegistFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, Exception {
      String url = "/extraPay/register.jsp";

      System.out.println(url);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}