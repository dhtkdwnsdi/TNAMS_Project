package com.tnams.action.attendItem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

public class AttendItemUpdateAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String url = "attendItem?command=attendItemList";
      
      System.out.println("attendItemUpdate 액션 진입");
      // registerAction과유사.

      String attendItemNum = request.getParameter("attendItemNum");
      request.setAttribute("attendItemNum", attendItemNum);

      String attendName = request.getParameter("attendName");
      request.setAttribute("attendName", attendName);

      String vacation = request.getParameter("vacation");
      request.setAttribute("vacation", vacation);

      String paid = request.getParameter("paid");
      request.setAttribute("paid", paid);

      System.out.println(
            "attendItemNum:" + attendItemNum + "attendName:" + attendName + "vacation:" + vacation + "paid" + paid);

      AttendItemVO aVo = new AttendItemVO();

      aVo.setAttendItemNum(attendItemNum);
      aVo.setAttendName(attendName);
      aVo.setVacation(vacation);
      aVo.setPaid(paid);

      AttendItemDAO aDao = AttendItemDAO.getInstance();

      request.setAttribute("AttendItemVO", aVo);

      aDao.updateAttendItem(aVo);
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}