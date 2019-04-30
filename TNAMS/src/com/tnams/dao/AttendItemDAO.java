package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.AttendItemVO;

public class AttendItemDAO extends CommonDao {
   private static AttendItemDAO instance;

   public static AttendItemDAO getInstance() {
      if (instance == null) {
         instance = new AttendItemDAO();

      }
      return instance;
   }

   // 근태항목 조회
   public List<AttendItemVO> selectAllAttendItem() {
      System.out.println("AttendItemDAO 조회 진입");

      String sql = "SELECT ATTEND_ITEM_NUM " + "       , ATTEND_NAME " + "       , VACATION " + "       , PAID "
            + "FROM TBL_ATTEND_ITEM ORDER BY ATTEND_ITEM_NUM DESC";

      /*
       * String sql = "SELECT attend_item_num" + "     , attend_name" +
       * "     , vacation" + "     , paid" +
       * "  ORDER BY attend_item_num DESC";
       */

      List<AttendItemVO> list = new ArrayList<AttendItemVO>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);

         rs = pstmt.executeQuery(sql);

         while (rs.next()) {

            AttendItemVO aVo = new AttendItemVO();

            aVo.setAttendItemNum(rs.getString("attend_item_num")); // DB가져오기
            aVo.setAttendName(rs.getString("attend_name"));
            aVo.setVacation(rs.getString("vacation")); // VO 데이터 타입이 Number
            aVo.setPaid(rs.getString("paid"));

            list.add(aVo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return list;
   }

   // 상세항목 가져오기
   public AttendItemVO selectAttendItem(String num) {

      String sql = "SELECT ATTEND_ITEM_NUM " + "       , ATTEND_NAME " + "       , VACATION " + "       , PAID "
            + "FROM TBL_ATTEND_ITEM WHERE ATTEND_ITEM_NUM =?";

      AttendItemVO aVo = new AttendItemVO();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, num);

         rs = pstmt.executeQuery();

         if (rs.next()) {

            aVo.setAttendItemNum(rs.getString("attend_item_num")); // DB가져오기
            aVo.setAttendName(rs.getString("attend_name"));
            aVo.setVacation(rs.getString("vacation")); // VO 데이터 타입이 Number
            aVo.setPaid(rs.getString("paid"));

         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return aVo;
   }

   // 근태항목 등록
   public void insertAttendItem(AttendItemVO aVo) {
      System.out.println("AttendItemDAO 등록 진입");

      String sql = "INSERT INTO tbl_attend_item(attend_item_num " + "                    , attend_name "
            + "                    , vacation " + "                    , paid) "
            + "  values(atten_item_seq.nextval, ?, ?, ?)"; // 시퀀스 확인하기

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, aVo.getAttendName());
         stmt.setString(2, aVo.getVacation());
         stmt.setString(3, aVo.getPaid());

         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }

   // 근태항목 수정
   public void updateAttendItem(AttendItemVO aVo) {
      String sql = "update tbl_attend_item set attend_name=?" + ", vacation=?" + ", paid=? "
            + "where attend_item_num=?";
      // atten_item_seq.nextval

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, aVo.getAttendName());
         stmt.setString(2, aVo.getVacation());
         stmt.setString(3, aVo.getPaid());
         stmt.setString(4, aVo.getAttendItemNum());

         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }

   }
   
   public List<AttendItemVO> searchAttendItem(String attendName) {
	      
	      String sql = "SELECT ATTEND_ITEM_NUM AS attendItemNum,"
	            + "            ATTEND_NAME AS attendName,"
	            + "            VACATION AS vacation,"
	            + "            PAID AS paid "
	            + "       FROM TBL_ATTEND_ITEM"
	            + "      WHERE ATTEND_NAME = '" + attendName + "'";
	            
	            
	            
	      List<AttendItemVO> list = new ArrayList<AttendItemVO>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery(sql);

	         if (rs.next()) {
	            AttendItemVO aVo = new AttendItemVO();
	            
	            aVo.setAttendItemNum(rs.getString("attendItemNum"));
	            aVo.setAttendName(rs.getString("attendName"));
	            aVo.setVacation(rs.getString("vacation"));
	            aVo.setPaid(rs.getString("paid"));
	            list.add(aVo);
	            
	         }
	         
	      } catch (SQLException e) {
	         
	         e.printStackTrace();
	         
	      } finally {
	         
	         dbClose();
	         
	      }
	      return list;
	      }

   // 근태항목 삭제
   public int deleteAttendItem(String attendItemNumIndivi) {
      System.out.println("근태 항목 삭제 DAO 진입");
      
      String sql = "delete from tbl_attend_item WHERE attend_item_num=?";
      
      System.out.println(sql);

      int res = 0;

      Connection conn = getConnection();
      PreparedStatement stmt = null;
      try {

         stmt = conn.prepareStatement(sql);

         stmt.setString(1, attendItemNumIndivi);

         // 쿼리문실행해주는것.
         res = stmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Exception");

      } finally {
         dbClose();
      }

      return res;

   }
}