package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.AttendVO;

public class AttendDAO extends CommonDao {
   private static AttendDAO instance;

   public static AttendDAO getInstance() {
      if (instance == null) {
         instance = new AttendDAO();

      }
      return instance;
   }

   // 근태(attendance) 조회
   public List<AttendVO> selectAllAttend() {

      System.out.println("근태 조회  DAO 진입!");


      String sql = "select ad.attendance_num as attendanceNum "
               +"      , ai.attend_name as attendName "
               +"      , e.emp_num as empNum "
               +"      , to_char(ad.start_date,'YYYY/MM/DD') as startDate "
               +"       , to_char(ad.end_date,'YYYY/MM/DD') as endDate "
               +"       , ad.attendance_remarks as remarks "
               +"       , ad.approved as approved "
               +"from tbl_attendance ad, tbl_emp e, tbl_attend_item ai "
               +"where ad.emp_num = e.emp_num and ai.attend_item_num = ad.attendance_num";

      
      /*   String sql = "SELECT attendance_num " 
              + "     , attend_item_num " 
            + "     , emp_num " 
              + "     , start_date "
            + "     , end_date " 
              + "     , attendance_remarks " 
            + "     , approved "
            + "FROM tbl_attendance ORDER BY attend_item_num DESC";
*/
      List<AttendVO> list = new ArrayList<AttendVO>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            AttendVO aVo = new AttendVO();

            aVo.setAttendanceNum(rs.getString("attendanceNum"));
            aVo.setAttendItemNum(rs.getString("attendName"));
         /*   aVo.setAttendItemNum(rs.getString("attend_item_num"));*/
            aVo.setEmpNum(rs.getString("empNum")); // 
            aVo.setStartDate(rs.getString("startDate"));
            aVo.setEndDate(rs.getString("endDate"));
            aVo.setAttendanceRemarks(rs.getString("remarks"));
            aVo.setApproved(rs.getString("approved"));

            list.add(aVo);

            System.out.println("DAO getset까지 왔음");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return list;
   }

   // 근태(attend) 등록
   /**
    * 
    * 화면설계 확인해서 sql문 수정
    * 
    * @param aVo
    */
   public void insertAttend(AttendVO aVo) {
      System.out.println("근태 등록 DAO 진입!!");

      String sql = "INSERT INTO TBL_ATTENDANCE(ATTENDANCE_NUM" 
              + "                   , ATTEND_ITEM_NUM"
            + "                   , EMP_NUM" 
            + "                   , START_DATE" 
            + "                   , END_DATE"
            + "                   , ATTENDANCE_REMARKS" 
            + "                   , APPROVED)"
            + "VALUES(ATTEND_SEQ.NEXTVAL, ?,  ?, to_date('?', 'yyyy-mm-dd), to_date('?', 'yyyy-mm-dd), ?, ?)";
      // attend_seq.nextval

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

   
         stmt.setString(1, aVo.getAttendItemNum());
         stmt.setString(2, aVo.getEmpNum());
         stmt.setString(3, aVo.getStartDate());
         stmt.setString(4, aVo.getEndDate());
         stmt.setString(5, aVo.getAttendanceRemarks());
         stmt.setString(6, aVo.getApproved());

         stmt.executeQuery();

         System.out.println("DAO 왔다....");
      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }

   // 근태 수정
   /**
    * 어떤걸 불러와서 수정해야하는지 화면설계 확인
    * 
    * @param aVo
    */
   public void updateAttend(AttendVO aVo) {
      String sql = "update tbl_attendance set attend_item_num=?, emp_num=?, start_date=?, end_date=?, attendance_remarks=?, approved=? where attendance_num=?";

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, aVo.getAttendItemNum());
         stmt.setString(2, aVo.getEmpNum());
         stmt.setString(3, aVo.getStartDate());
         stmt.setString(4, aVo.getEndDate());
         stmt.setString(5, aVo.getAttendanceRemarks());
         stmt.setString(7, aVo.getAttendanceNum());
         stmt.setString(6, aVo.getApproved());

         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }

   }

   // 근태 삭제
   public int deleteAttend(Object attendNumIndivi) {
      String sql = "delete from tbl_attendance WHERE attendance_num=?";

      Connection conn = null;
      PreparedStatement stmt = null;
      try {

         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, (String)attendNumIndivi);

         // 쿼리문실행해주는것.
         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      dbClose();
      return 0;
   }

   
}