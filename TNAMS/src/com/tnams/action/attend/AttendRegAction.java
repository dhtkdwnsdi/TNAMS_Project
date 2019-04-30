package com.tnams.action.attend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnams.action.Action;

public class AttendRegAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub

		String url = "/attend?command=attendListForm";

		String empNum = request.getParameter("empNum");
		String salaryNum = request.getParameter("salaryNum");
		String paymentDate = request.getParameter("paymentDate");
		String price = request.getParameter("price");
		String extraPayRemarks = request.getParameter("extraPayRemarks");

	}

}
