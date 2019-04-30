//로그인 DAO
package com.tnams.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import com.tnams.vo.EmpLoginVO;


public class EmpLoginDAO extends CommonDao {

	private static EmpLoginDAO instance = new EmpLoginDAO();

	public static EmpLoginDAO getInstance() {
		if (instance == null) {
			instance = new EmpLoginDAO();
		}
		return instance;
	}



	public int loginCheck(EmpLoginVO eVo) {

		String sql = "SELECT emp_num, emp_pw " 
				   + "     FROM tbl_emp " 
				   + "    WHERE emp_num = '" 
				   + eVo.getEmpId() 
				   + "'";

		System.out.println(eVo.getEmpPw());
		System.out.println(eVo.getEmpId());
		
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				System.out.println(rs.getString("emp_num"));
				if (rs.getString("emp_pw") != null && rs.getString("emp_pw").equals(eVo.getEmpPw())) {
					return 1; // 로그인 성공
				} else {
					return 0; // 로그인 실패
				}
			} else {

				return -1;

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			dbClose();

		}

		return -1;
	}

	public EmpLoginVO getAdminInfo(EmpLoginVO tempVo) {

		String sql = "SELECT empId " 
			       + "  FROM tbl_empLogin " 
				   + " WHERE empId = '" + tempVo.getEmpId() + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		EmpLoginVO eVo = new EmpLoginVO();

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				eVo.setEmpId(rs.getString("empId"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			dbClose();

		}
		return eVo;
	}

}