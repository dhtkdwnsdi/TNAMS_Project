package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.AttendanceVO;
import com.tnams.vo.EmpVO;
import com.tnams.vo.ExtraPayVO;

public class ExtraPayDAO extends CommonDao{
   
   private static ExtraPayDAO instance;
   
   public static ExtraPayDAO getInstance() {
      if(instance == null) {
         instance = new ExtraPayDAO();
      }
      return instance;
   }
   
   //수당 조회
   public List<ExtraPayVO> listAllExtraPay() {
      
      String sql = "SELECT e.EMP_NUM AS empNum"
               +"      ,e.EMP_Name AS empName"
               +"      ,ep.EXTRA_PAY_NUM AS epNum"
               +"      ,s.SALARY_NUM AS salaryNum"
               +"      ,ep.PAYMENT_DATE AS paymentDate"
               +"      ,ep.PRICE AS price"
               +"      ,ep.EXTRA_PAY_REMARKS AS epRemarks"
               +"FROM TBL_EXTRA_PAY ep, TBL_EMP e, TBL_SALARY s "
               +"WHERE e.EMP_NUM = ep.EMP_NUM AND ep.SALARY_NUM = s.SALARY_NUM"
               +"ORDER BY EXTRA_PAY_NUM";
      
      List<ExtraPayVO> list = new ArrayList<ExtraPayVO>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            ExtraPayVO eVo = new ExtraPayVO();

            eVo.setExtraPayNum(rs.getString("epNum"));
            eVo.setEmpNum(rs.getString("empNum"));
            eVo.setSalaryNum(rs.getString("salaryNum"));
            eVo.setPaymentDate(rs.getString("paymentDate"));
            eVo.setPrice(rs.getInt("price"));
            eVo.setExtraPayRemarks(rs.getString("epRemarks"));
            list.add(eVo);
         }
         
      } catch (SQLException e) {
         
         e.printStackTrace();
         
      } finally {
         
         dbClose();
         
      }
      
      return list;
   }
   
   //수당 등록
   public void insertExtraPay(ExtraPayVO eVo) {
      String sql = "INSERT INTO TBL_EXTRA_PAY(EXTRA_PAY_NUM"
            + "                        ,EMP_NUM"
            +"                        ,SALARY_NUM"
            +"                        ,PAYMENT_DATE"
            +"                        ,PRICE"
            +"                        ,EXTRA_PAY_REMARKS"
            +"VALUES(EXTRA_PAY_SEQ.NEXTVAL,?,?,?,?,?)";
      // atten_item_seq.nextval

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
            
      
         stmt.setString(1, eVo.getExtraPayNum());
         stmt.setString(2, eVo.getEmpNum());
         stmt.setString(3, eVo.getSalaryNum());
         stmt.setString(4, eVo.getPaymentDate());
         stmt.setInt(5, eVo.getPrice());
         stmt.setString(6, eVo.getExtraPayRemarks());
         
         stmt.executeQuery();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }
   
   //사원 정보 등록하는 테이블 empRegist.jsp
         public void updateExtraPay(ExtraPayVO eVo) {
            
            String sql = "UPDATE TBL_EXTRA_PAY SET EXTRA_PAY_NUM = ?,"
                     + "                     EMP_NUM = ?,"
                     + "                     SALARY_NUM = ?,"
                     + "                     PAYMENT_DATE = ?,"
                     + "                     PRICE = ?,"
                     + "                     EXTRAPAYREMARKS = ?,"
                     + "        WHERE EXTRA_PAY_NUM = ?";

            Connection conn = null;
            PreparedStatement st = null   ;

            try {
               conn = getConnection();
               st = conn.prepareStatement(sql);
               
               st.executeUpdate();

               st.setString(1, eVo.getExtraPayNum());
               st.setString(2, eVo.getEmpNum());
               st.setString(3, eVo.getSalaryNum());
               st.setString(4, eVo.getPaymentDate());
               st.setInt(5, eVo.getPrice());
               st.setString(6, eVo.getExtraPayRemarks());

            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               dbClose();
            }
         }
         
         public void deleteExtraPay(ExtraPayVO eVo) {
            
            String sql = "DELETE TBL_EXTRA_PAY"
                  + "     WHERE EXTRA_PAY_NUM = ?";
            
            Connection conn = null;
            PreparedStatement st = null;
            
            try {
               conn = getConnection();
               st = conn.prepareStatement(sql);

               st.setString(1, eVo.getExtraPayNum());

               st.executeUpdate();
               
            } catch(SQLException e) {
               e.printStackTrace();
            } finally {
               dbClose();
            }
         }

   
   
}