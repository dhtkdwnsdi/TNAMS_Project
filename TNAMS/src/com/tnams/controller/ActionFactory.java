
package com.tnams.controller;

import com.tnams.action.Action;
import com.tnams.action.MainAction;
import com.tnams.action.commute.CommuteListFormAction;
import com.tnams.action.dept.DeptListFormAction;
import com.tnams.action.emp.EmpListFormAction;
import com.tnams.action.emp.EmpModifyAction;
import com.tnams.action.emp.EmpModifyFormAction;
import com.tnams.action.emp.EmpRegistAction;
import com.tnams.action.emp.EmpRegistFormAction;


//package 모든 액션 받음

/**
 * request로 받아온 매개변수의 command의 값으로 각 기능을 수행할 액션을 분기하는 클래스 <br>
 * action추가 시 최대한 기능별로 정렬될 수 있도록 한다. 수정이 잦은 class이므로 주의하여 편집!!
 * 
 * @author cho
 *
 */
public class ActionFactory {

   private static ActionFactory instance = new ActionFactory();

   private ActionFactory() {
      super();
   }

   public static ActionFactory getInstance() {
      return instance;
   }

   public Action getAction(String command) {
      Action action = null;

      System.out.println("ActionFactory : " + command);

      if (command.equals("main")) {

         action = new MainAction();

      } else if (command.equals("empListForm")) {

         action = new EmpListFormAction();

      } else if (command.equals("empRegistForm")) {

          action = new EmpRegistFormAction();

      } else if (command.equals("empRegist")) {

          action = new EmpRegistAction();

      } else if (command.equals("empModifyForm")) {

          action = new EmpModifyFormAction();

      } else if (command.equals("empModify")) {

          action = new EmpModifyAction();

      } else if (command.equals("commuteListForm")) {

          action = new CommuteListFormAction();

      }
      
      else if (command.equals("deptListForm")) {
    	  
    	  action = new DeptListFormAction();
    	  
      }
     /* else if (command.equals("salaryListForm")) {
         action = new SalaryListFormAction();
         
      } else if (command.equals("salaryRegistForm")) {
         action = new SalaryRegistFormAction();
         
      } else if (command.equals("salaryRegist")) {
         action = new SalaryRegistAction();
         
      } else if (command.equals("salaryNumCheck")) {
         action = new SalaryCheckAction();
         
      }else if (command.equals("salaryModifyForm")) {
         action = new SalaryModifyFormAction();
         
      } else if (command.equals("salaryDelete")) {
         action = new SalaryDeleteAction();
         
      } else if (command.equals("salaryModify")) {
         action = new SalaryModifyAction();
      }
*/
      return action;

   }
}