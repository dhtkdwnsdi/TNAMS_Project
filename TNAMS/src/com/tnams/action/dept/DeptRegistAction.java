package com.tnams.action.dept;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.DeptDAO;
import com.tnams.vo.DeptVO;


public class DeptRegistAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      System.out.println("regist action");
        String url = "/dept?command=deptListForm";
      
        DeptVO dVo = new DeptVO();
         
         //필요한 필드값(요청받은 파라미터)을 String에 넣어준다.
         //String dept_num = request.getParameter("dept_num"); //시퀀스로 숫자 올림
         String dept_name = request.getParameter("dept_name");
         String dept_phonenum = request.getParameter("dept_phonenum");
         
         
         //파라미터 출력
         //System.out.println("Dept Num : " + dept_num); //시퀀스로 숫자 올림
         System.out.println("Dept Name : " + dept_name);
         System.out.println("Dept Phonenum : " + dept_phonenum);
         
         
         // 객체 세팅
         //dVo.setDept_num(dept_num);
         dVo.setDept_name(dept_name);
         dVo.setDept_phonenum(dept_phonenum);
         
         //DeptDAO로 인스턴스불러오기
         DeptDAO dDao = DeptDAO.getInstance();
         dDao.insertDept(dVo);
         
         //게시글 작성알림
         //request.setAttribute("msg", "부서가 등록되었습니다.");
         
         //new deptListAction().execute(request, response);
      
         RequestDispatcher dispatcher = request.getRequestDispatcher(url);
         dispatcher.forward(request, response);
      
      /*DeptVO dVo = new DeptVO();
      dVo.setDept_num(request.getParameter("dept_num"));
      dVo.setDept_name(request.getParameter("dept_name"));
      dVo.setDept_phonenum(request.getParameter("dept_phonenum"));
      DeptDAO dDao = DeptDAO.getInstance();
      dDao.registDept(dVo);
      new DeptListFormAction().execute(request, response);*/
      
      /*
      DeptVO dVo = new DeptVO();
      
      String dept_num = request.getParameter("dept_num"); //시퀀스로 숫자 올림
       String dept_name = request.getParameter("dept_name");
       String dept_phonenum = request.getParameter("dept_phonenum");
       
       dVo.setDept_num(dept_num);
       dVo.setDept_name(dept_name);
       dVo.setDept_phonenum(dept_phonenum);
       
       System.out.println("Dept Num : " + dept_num); //시퀀스로 숫자 올림
       System.out.println("Dept Name : " + dVo.getDept_name());
       System.out.println("Dept Phonenum : " + dVo.getDept_name());
       
       new DeptListFormAction().execute(request, response);
       
       DeptDAO dDao = DeptDAO.getInstance();
      dDao.registDept(dVo);
      */
   }

}