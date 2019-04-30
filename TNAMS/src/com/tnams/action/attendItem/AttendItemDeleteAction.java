
package com.tnams.action.attendItem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.AttendItemDAO;
import com.tnams.vo.AttendItemVO;

public class AttendItemDeleteAction implements Action {

   private Object attendItemNumIndivi;

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub

      System.out.println("근태 항목 삭제 액션진입");

      String[] attendItemCheck = request.getParameterValues("attendItemCheck");

      for (String string : attendItemCheck) {

         System.out.println("근태항목번호 : " + string);
      }


      AttendItemDAO aDao = AttendItemDAO.getInstance();

      int res = 0;

      for (String attendNum : attendItemCheck) {

         res = aDao.deleteAttendItem(attendNum);

      }
      
      System.out.println("res =" + res);

      if (res == 1) {
         request.setAttribute("msg", "SUCCESS");
      } else {
         request.setAttribute("msg", "FAIL");
      }

      /*
       * if(res == 1) { request.setAttribute("msg", "SUCCESS"); }else {
       * request.setAttribute("msg", "FAIL"); }
       * 
       * for(int i=0; i<attendItemCheck.length; i++) {
       * 
       * 
       * System.out.println("attendItemCheck : " + attendItemCheck[i]);
       * 
       * attendItemNumIndivi = attendItemCheck[i];
       * 
       * 
       * //객체 셋팅 AttendItemVO aVo = new AttendItemVO();
       * aVo.setAttendItemNum((String) attendItemNumIndivi);
       * 
       * 
       * int res= aDao.deleteAttendItem(attendItemNumIndivi);
       * 
       * 
       * if(res == 1) { request.setAttribute("msg", "SUCCESS"); }else {
       * request.setAttribute("msg", "FAIL"); }
       */

      new AttendItemListAction().execute(request, response);

   }

   //

   public Object getAttendItemNumIndivi() {
      return attendItemNumIndivi;
   }

   public void setAttendItemNumIndivi(Object AttendItemNumIndivi) {
      this.attendItemNumIndivi = AttendItemNumIndivi;
   }

}