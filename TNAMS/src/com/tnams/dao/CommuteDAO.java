package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.CommuteVO;
import com.tnams.vo.EmpVO;

public class CommuteDAO extends CommonDao {

	private static CommuteDAO instance;

	// EmpDAO 객체 리턴하는 메소드 [싱글턴]
	public static CommuteDAO getInstance() {
		if (instance == null) {
			instance = new CommuteDAO();
		}
		return instance;
	}

	// 일자, 사원명, 출근일시, 퇴근일시, 비고 출력하는 commute/list.jsp
	public List<CommuteVO> selectCommute(String empNum) {

		String sql = "SELECT C.COMMUTE_NUM AS commuteNum,"
				+ "			 TO_CHAR(C.WORK_DATE, 'YYYY-MM-DD') AS workDate, " 
				+ "			 E.EMP_NAME AS empName, "
				+ "			 TO_CHAR(C.GO_TO_WORK_TIME, 'YYYYMMDDHHMI') AS goToWorkTime," + 
				"			 TO_CHAR(C.OFF_WORK_TIME, 'YYYYMMDDHHMI') AS offWorkTime, "
				+ "			 C.COMMUTE_REMARKS AS commuteRemarks" + 
				"		FROM TBL_COMMUTE C, TBL_EMP E"
				+ "		WHERE E.EMP_NUM = C.EMP_NUM AND  E.EMP_NUM= ?";

		List<CommuteVO> list = new ArrayList<CommuteVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, empNum);
			rs = stmt.executeQuery();
			

			while (rs.next()) {
				CommuteVO cVo = new CommuteVO();

				cVo.setCommuteNum(rs.getString("commuteNum"));
				cVo.setWorkDate(rs.getString("workDate"));
				cVo.setEmpName(rs.getString("empName"));
				cVo.setGoToWorkTime(rs.getString("goToWorkTime"));
				cVo.setWorkDate(rs.getString("workDate"));
				cVo.setCommuteRemarks(rs.getString("commuteRemarks"));
				list.add(cVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();

		}
		return list;
	}
	
	
	
	public void insertCommute(CommuteVO cVo) {
        
        String sql = "INSERT INTO TBL_COMMUTE(COMMUTE_NUM"
        		+ "					   , GO_TO_WORK_TIME"
              + "                      , OFF_WORK_TIME"
              + "                      , COMMUTE_REMARKS"
              + "                      , EMP_NUM"
              + "                   , WORK_DATE)"
              + "   VALUES(commute_seq.nextval, TO_DATE(?,'YYYY-MM-DD HH:MI:SS'), TO_DATE(?,'YYYY-MM-DD HH:MI:SS') , ? , ? , sysdate)";

        Connection conn = null;
        PreparedStatement st = null   ;

        System.out.println(sql);
        
        try {
           conn = getConnection();
           st = conn.prepareStatement(sql);

           st.setString(1, cVo.getGoToWorkTime());
           st.setString(2, cVo.getOffWorkTime());
           st.setString(3, cVo.getCommuteRemarks());
           st.setString(4, cVo.getEmpName());

           st.executeUpdate();
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           dbClose();
        }
     }
	
	
}
