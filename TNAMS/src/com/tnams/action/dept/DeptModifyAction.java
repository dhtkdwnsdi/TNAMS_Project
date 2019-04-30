package com.tnams.action.dept;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;
import com.tnams.dao.DeptDAO;
import com.tnams.vo.DeptVO;

public class DeptModifyAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      String url = "/dept?command=deptListForm";


      String dept_num = request.getParameter("dept_num");
      String dept_name = request.getParameter("dept_name");
      String dept_phonenum = request.getParameter("dept_phonenum");

      System.out.println("dept_num :" + dept_num );
      System.out.println("dept_name :" + dept_name );
      System.out.println("dept_phonenum :" + dept_phonenum );
      
      DeptVO dVo = new DeptVO();
      
      //객체 셋팅
      dVo.setDept_num(dept_num);
      dVo.setDept_name(dept_name);
      dVo.setDept_phonenum(dept_phonenum);

      //request.setAttribute("DeptVO", dVo);

      System.out.println(dVo);
      
      //실제 데이터 Update DAO
      //DeptDAO.getInstance().updateDept(dVo);
      //request.setAttribute("msg", "부서를 수정했습니다");
   
      
      DeptDAO dDao = DeptDAO.getInstance();
      
       //request.setAttribute("DeptVO", dVo);
      
       dDao.updateDept(dVo);
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
       
       //new DeptListFormAction().execute(request, response);
      
   }



}
