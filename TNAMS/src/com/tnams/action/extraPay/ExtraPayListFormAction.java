package com.tnams.action.extraPay;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.ExtraPayDAO;
import com.tnams.vo.ExtraPayVO;

public class ExtraPayListFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, Exception {

      System.out.println("출력!");
      String url = "/extraPay/list.jsp";

      ExtraPayDAO eDao = ExtraPayDAO.getInstance();

      List<ExtraPayVO> extraPayList = eDao.listAllExtraPay();

      request.setAttribute("list", extraPayList);

      System.out.println(extraPayList);

      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}