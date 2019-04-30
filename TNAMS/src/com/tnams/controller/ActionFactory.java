
package com.tnams.controller;

import com.tnams.action.Action;
import com.tnams.action.MainAction;
import com.tnams.action.attend.AttendDeleteAction;
import com.tnams.action.attend.AttendListAction;
import com.tnams.action.attend.AttendRegAction;
import com.tnams.action.attend.AttendRegFormAction;
import com.tnams.action.attendItem.AttendItemDeleteAction;
import com.tnams.action.attendItem.AttendItemListAction;
import com.tnams.action.attendItem.AttendItemRegAction;
import com.tnams.action.attendItem.AttendItemRegFormAction;
import com.tnams.action.attendItem.AttendItemSearchAction;
import com.tnams.action.attendItem.AttendItemSearchFormAction;
import com.tnams.action.attendItem.AttendItemUpdateAction;
import com.tnams.action.attendItem.AttendItemUpdateFormAction;
import com.tnams.action.commute.CommuteListFormAction;
import com.tnams.action.commute.CommuteRegist;
import com.tnams.action.commute.CommuteRegistFormAction;
import com.tnams.action.dept.DeptDeleteAction;
import com.tnams.action.dept.DeptListFormAction;
import com.tnams.action.dept.DeptModifyAction;
import com.tnams.action.dept.DeptModifyFormAction;
import com.tnams.action.dept.DeptRegistAction;
import com.tnams.action.dept.DeptRegistFormAction;
import com.tnams.action.emp.EmpDeleteAction;
import com.tnams.action.emp.EmpListFormAction;
import com.tnams.action.emp.EmpModifyAction;
import com.tnams.action.emp.EmpModifyFormAction;
import com.tnams.action.emp.EmpModifySelfAction;
import com.tnams.action.emp.EmpRegistAction;
import com.tnams.action.emp.EmpRegistFormAction;
import com.tnams.action.emp.EmpSearchAction;
import com.tnams.action.emp.EmpSearchFormAction;
import com.tnams.action.empself.EmpModifySelfFormAction;
import com.tnams.action.extraPay.ExtraPayDeleteAction;
import com.tnams.action.extraPay.ExtraPayListFormAction;
import com.tnams.action.extraPay.ExtraPayModifyAction;
import com.tnams.action.extraPay.ExtraPayModifyFormAction;
import com.tnams.action.extraPay.ExtraPayRegistAction;
import com.tnams.action.extraPay.ExtraPayRegistFormAction;
import com.tnams.action.salary.SalaryCheckAction;
import com.tnams.action.salary.SalaryDeleteAction;
import com.tnams.action.salary.SalaryListFormAction;
import com.tnams.action.salary.SalaryModifyAction;
import com.tnams.action.salary.SalaryModifyFormAction;
import com.tnams.action.salary.SalaryRegistAction;
import com.tnams.action.salary.SalaryRegistFormAction;
import com.tnams.action.salary.SalarySearchAction;
import com.tnams.action.salary.SalarySearchFormAction;

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

		} else if (command.equals("empModifySelfForm")) {

			action = new EmpModifySelfFormAction();

		}
		else if (command.equals("empModifySelf")) {

			action = new EmpModifySelfAction();

		}else if (command.equals("commuteListForm")) {

			action = new CommuteListFormAction();

		} else if (command.equals("empSearchForm")) {

			action = new EmpSearchFormAction();

		} else if (command.equals("empSearch")) {

			action = new EmpSearchAction();

		} else if (command.equals("empDelete")) {

			action = new EmpDeleteAction();

		}else if (command.equals("attendItemSearchForm")) {

			action = new AttendItemSearchFormAction();

		}else if (command.equals("attendItemSearch")) {

			action = new AttendItemSearchAction();

		} else if (command.equals("commuteRegistForm")) {

			action = new CommuteRegistFormAction();

		} else if(command.equals("commuteRegist")){
			
			action = new CommuteRegist();
			
		}


		/**
		 * @author 이유진
		 */

		else if (command.equals("deptModify")) {

			action = new DeptModifyAction();

		} else if (command.equals("deptDelete")) {

			action = new DeptDeleteAction();

		} else if (command.equals("deptRegist")) {

			action = new DeptRegistAction();

		} else if (command.equals("deptListForm")) {

			action = new DeptListFormAction();

		} else if (command.equals("deptModifyForm")) {

			action = new DeptModifyFormAction();

		} else if (command.equals("deptRegistForm")) {

			action = new DeptRegistFormAction();

		} else if (command.equals("extraPayListForm")) {

			action = new ExtraPayListFormAction();

		} else if (command.equals("extraPayModify")) {

			action = new ExtraPayModifyAction();

		} else if (command.equals("extraPayModifyForm")) {

			action = new ExtraPayModifyFormAction();

		} else if (command.equals("extraPayRegist")) {

			action = new ExtraPayRegistAction();

		} else if (command.equals("extraPayRegistForm")) {

			action = new ExtraPayRegistFormAction();

		} else if (command.equals("extraPayDelete")) {

			action = new ExtraPayDeleteAction();

		}

		/**
		 * @author 박주희
		 */

		else if (command.equals("salaryListForm")) {
			action = new SalaryListFormAction();

		} else if (command.equals("salaryRegistForm")) {
			action = new SalaryRegistFormAction();

		} else if (command.equals("salaryRegist")) {
			action = new SalaryRegistAction();

		} else if (command.equals("salaryNumCheck")) {
			action = new SalaryCheckAction();

		} else if (command.equals("salaryModifyForm")) {
			action = new SalaryModifyFormAction();

		} else if (command.equals("salaryDelete")) {
			action = new SalaryDeleteAction();

		} else if (command.equals("salaryModify")) {
			action = new SalaryModifyAction();
			
		} else if (command.equals("salarySearchForm")) {
			action = new SalarySearchFormAction();
			
		} else if (command.equals("salarySearch")) {
			action = new SalarySearchAction();
			
		} 

		/**
		 * @강문정
		 */

		// 근태항목 조회 리스트
	      if (command.equals("attendItemList")) {

	         action = new AttendItemListAction();

	         // 근태항목 등록폼
	      } else if (command.equals("attendItemRegForm")) {
	         action = new AttendItemRegFormAction();

	         // 근태항목 등록
	      } else if (command.equals("attendItemReg")) {

	         action = new AttendItemRegAction();

	         // 메인화면
	      } else if (command.equals("main")) {

	         action = new MainAction();

	         // 근태항목 수정폼
	      } else if (command.equals("attendItemUpdateForm")) {

	         action = new AttendItemUpdateFormAction();

	         // 근태항목 수정
	      } else if (command.equals("attendItemUpdate")) {

	         action = new AttendItemUpdateAction();

	         // 근태(attend) 조회 리스트
	      } else if (command.equals("attendList")) {

	         action = new AttendListAction();

	         // 근태(attend) 등록 폼
	      } else if (command.equals("attendRegForm")) {

	         action = new AttendRegFormAction();

	         // 근태(attend) 등록
	      } else if (command.equals("attendReg")) {

	         action = new AttendRegAction();

	         // 근태 항목 삭제
	      } else if (command.equals("attendItemDelete")) {

	         action = new AttendItemDeleteAction();

	         // 근태(attend) 삭제
	      } else if (command.equals("attendDelete")) {

	         action = new AttendDeleteAction();

	      } /*else if (command.equals("attendRegForm")) {

       action = new AttendRegFormAction();

       // 근태(attend) 등록
    } else if (command.equals("attendReg")) {

       action = new AttendRegAction();

       // 근태 항목 삭제
    }*/ else if (command.equals("attendDelete")) {

       action = new AttendDeleteAction();

    }
		
		
		return action;

	}}