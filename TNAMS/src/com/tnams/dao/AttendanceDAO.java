package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.AttendanceVO;

public class AttendanceDAO extends CommonDao {
   private static AttendanceDAO instance;

   public static AttendanceDAO getInstance() {
      if (instance == null) {
         instance = new AttendanceDAO();

      }
      return instance;
   }

   // 근태(attendance) 조회
   public List<AttendanceVO> selectAllAttend() {

      String sql = "SELECT attendance_num" 
                 + "     , attend_item_num" 
               + "     , emp_num" 
                 + "     , start_date" 
               + "     , end_date"
                 + "     , attendance_remarks"
               + "     , approved"
               + " FROM tbl_attendance ORDER BY attend_item_num DESC";

      List<AttendanceVO> list = new ArrayList<AttendanceVO>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            AttendanceVO aVo = new AttendanceVO();

            aVo.setAttendance_num(rs.getString("attendance_num"));
            aVo.setAttend_item_num(rs.getString("attend_item_num"));
            aVo.setEmp_num(rs.getString("emp_num")); // VO 데이터 타입이 Number
            aVo.setStart_date(rs.getDate("start_date"));
            aVo.setEnd_date(rs.getDate("end_date"));
            aVo.setAttendance_remarks(rs.getString("attendance_remarks"));
            aVo.setApproved(rs.getInt("approved"));
            
            list.add(aVo);
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
    *화면설계 확인해서 sql문 수정
    * @param aVo
    */
   public void insertAttend(AttendanceVO aVo) {
      String sql = "insert into tbl_attendance(attendance_num" 
                  + "                   , attend_item_num"
               + "                   , emp_num" 
                  + "                   , start_date"
                  + "                   , end_date"
                  + "                   , attendance_remarks"
                  + "                   , approved)"
               + "values (?, ?, ?, ?, ?, ?, ?)";
      // atten_item_seq.nextval

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
            
      
         stmt.setString(1, aVo.getAttendance_num());
         stmt.setString(2, aVo.getAttend_item_num());
         stmt.setString(3, aVo.getEmp_num());
         stmt.setDate(4, aVo.getStart_date());
         stmt.setDate(5, aVo.getEnd_date());
         stmt.setString(6, aVo.getAttendance_remarks());
         stmt.setInt(7, aVo.getApproved());
         
         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }

   // 근태 수정
   /**
    * 어떤걸 불러와서 수정해야하는지 화면설계 확인
    * @param aVo
    */
   public void updateAttend(AttendanceVO aVo) {
      String sql = "update tbl_attendance set attend_item_num=?, emp_num=?, start_date=?, end_date=?, attendance_remarks=?, approved=? where attendance_num=?";
   

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, aVo.getAttend_item_num());
         stmt.setString(2, aVo.getEmp_num());
         stmt.setDate(3, aVo.getStart_date());
         stmt.setDate(4, aVo.getEnd_date());
         stmt.setString(5, aVo.getAttendance_remarks());
         stmt.setInt(6, aVo.getApproved());
         stmt.setString(7,aVo.getAttendance_num());
         

         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }

   }

   // 근태(attend) 삭제
   public void deleteAttend(String attendance_num) {
      String sql = "delete tbl_attendance WHERE attendance_num=?";

      Connection conn = null;
      PreparedStatement stmt = null;
      try {

         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, attendance_num);

         // 쿼리문실행해주는것.
         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}