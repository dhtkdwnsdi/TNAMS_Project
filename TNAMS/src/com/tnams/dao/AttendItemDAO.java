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

      String sql = "SELECT attend_item_num" 
                 + "     , attend_name" 
               + "     , vacation" 
                 + "     , paid"
               + "  FROM tbl_attend_item ORDER BY attend_item_num DESC";

      List<AttendItemVO> list = new ArrayList<AttendItemVO>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            
            AttendItemVO aVo = new AttendItemVO();

            aVo.setAttendItemNum(rs.getString("attendItemNum"));
            aVo.setAttendName(rs.getString("attendName"));
            aVo.setVacation(rs.getInt("vacation")); // VO 데이터 타입이 Number
            aVo.setPaid(rs.getInt("paid"));

            list.add(aVo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return list;
   }

   // 근태항목 등록
   public void insertAttendItem(AttendItemVO aVo) {
      String sql = "insert into tbl_attend_item(attend_item_num" 
                   + "                   , attend_name"
               + "                   , vacation"
                  + "                   , paid)"
               + "values  (atten_item_seq.nextval, ? ,? ,?)";
      // atten_item_seq.nextval

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, aVo.getAttendItemNum());
         stmt.setString(2, aVo.getAttendName());
         stmt.setInt(3, aVo.getVacation());
         stmt.setInt(4, aVo.getPaid());

         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }

   // 근태항목 수정
   public void updateAttendItem(AttendItemVO aVo) {
      String sql = "update tbl_attend_item set attend_item_num=?, attend_name=?, vacation=?, paid=? where attend_item_num=?";
      // atten_item_seq.nextval

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, aVo.getAttendItemNum());
         stmt.setString(2, aVo.getAttendName());
         stmt.setInt(3, aVo.getVacation());
         stmt.setInt(4, aVo.getPaid());

         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }

   }

   // 근태항목 삭제
   public void deleteAttendItem(String tbl_attend_item) {
      String sql = "delete tbl_attend_item WHERE attend_item_num=?";

      Connection conn = null;
      PreparedStatement stmt = null;
      try {

         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, tbl_attend_item);

         // 쿼리문실행해주는것.
         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}