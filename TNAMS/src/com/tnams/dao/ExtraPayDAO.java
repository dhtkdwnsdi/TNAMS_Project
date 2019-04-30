package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.tnams.vo.ExtraPayVO;

public class ExtraPayDAO extends CommonDao {

   private static ExtraPayDAO instance;

   public static ExtraPayDAO getInstance() {
      if (instance == null) {
         instance = new ExtraPayDAO();
      }
      return instance;
   }

   // 수당 조회
   public ArrayList<ExtraPayVO> listAllExtraPay() {
      String sql = "SELECT ep.EXTRA_PAY_NUM AS extraPayNum"
            + "      , e.EMP_NAME AS empNum"
            + "      , s.SALARY_NAME AS salaryNum"
            + "      , TO_CHAR(ep.PAYMENT_DATE,'YYYY/MM/DD') AS paymentDate"
            + "      , ep.PRICE AS price"
            + "      , ep.EXTRA_PAY_REMARKS AS extraPayRemarks"
            + "     FROM TBL_EXTRA_PAY ep, TBL_EMP e, TBL_SALARY s"
            + "    WHERE ep.EMP_NUM = e.EMP_NUM AND ep.SALARY_NUM = s.SALARY_NUM"
            + " ORDER BY EXTRA_PAY_NUM ASC";

      /*String sql = "select ep.extra_pay_num as extraPayNum, e.emp_num as empNum, s.salary_num as salaryNum, to_char(ep.payment_Date,'YYYY/MM/DD') as paymentDate"
            +"      , ep.price as price, ep.extra_pay_remarks as extraPayRemarks "
            +"   from tbl_extra_pay ep, tbl_emp e, tbl_salary s "
            +"  where ep.emp_num = e.emp_num and ep.salary_num = s.salary_num ";*/

      
         System.out.println(sql);

      ArrayList<ExtraPayVO> list = new ArrayList<ExtraPayVO>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            ExtraPayVO eVo = new ExtraPayVO();

            eVo.setExtraPayNum(rs.getString("extraPayNum"));
            eVo.setEmpNum(rs.getString("empNum"));
            /*eVo.setEmpName(rs.getString("empName"));*/
            eVo.setSalaryNum(rs.getString("salaryNum"));
            eVo.setPaymentDate(rs.getString("paymentDate"));
            eVo.setPrice(rs.getString("price"));
            eVo.setExtraPayRemarks(rs.getString("extraPayRemarks"));
            
            list.add(eVo);
         }

      } catch (SQLException e) {

         e.printStackTrace();

      } finally {

         dbClose();

      }

      return list;
   }

   // 수당 등록
   public void insertExtraPay(ExtraPayVO eVo) {
      String sql = "INSERT INTO TBL_EXTRA_PAY(EXTRA_PAY_NUM" 
            + "                        ,EMP_NUM"
            + "                        ,SALARY_NUM" 
            + "                        ,PAYMENT_DATE"
            + "                        ,PRICE" 
            + "                        ,EXTRA_PAY_REMARKS)"
            + " VALUES(EXTRA_PAY_SEQ.NEXTVAL,?,?,?,?,?)";
     

      Connection conn = null;
      PreparedStatement stmt = null;

      try {
         conn = getConnection();
         stmt = conn.prepareStatement(sql);

         stmt.setString(1, eVo.getEmpNum());
         stmt.setString(2, eVo.getSalaryNum());
         stmt.setString(3, eVo.getPaymentDate());
         stmt.setString(4, eVo.getPrice());
         stmt.setString(5, eVo.getExtraPayRemarks());

         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }

   // 사원 정보 등록하는 테이블 empRegist.jsp
   public void updateExtraPay(ExtraPayVO eVo) {

      String sql = "UPDATE TBL_EXTRA_PAY SET EMP_NUM = ?,"
            + "                     SALARY_NUM = ?,"
            + "                     PAYMENT_DATE = ?,"
            + "                     PRICE = ?," 
            + "                     EXTRAPAYREMARKS = ?,"
            + "        WHERE EXTRA_PAY_NUM = ?";

      Connection conn = null;
      PreparedStatement st = null;

      try {
         conn = getConnection();
         st = conn.prepareStatement(sql);

         st.executeUpdate();

         st.setString(1, eVo.getEmpNum());
         st.setString(2, eVo.getSalaryNum());
         st.setString(3, eVo.getPaymentDate());
         st.setString(4, eVo.getPrice());
         st.setString(5, eVo.getExtraPayRemarks());
         st.setString(6, eVo.getExtraPayNum());

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
   }

   public int deleteExtraPay(String extraPayNum) {

      String sql = "DELETE TBL_EXTRA_PAY" + "     WHERE EXTRA_PAY_NUM = ?";

      Connection conn = null;
      PreparedStatement st;

      try {
         conn = getConnection();
         st = conn.prepareStatement(sql);

         st.setString(1, (String)extraPayNum);

         st.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
         dbClose();
         return 0;
      
   }
   
   public ExtraPayVO readOnExtraPayByNum(String extraPayNum) {
      
      String sql = "Select * from tbl_extra_pay where extra_pay_num=?";
      
      Connection conn=null;
      PreparedStatement pstmt= null;
      ResultSet rs = null;
      ExtraPayVO eVo = new ExtraPayVO();
      
      try {
         conn = getConnection();
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, extraPayNum);
           rs = pstmt.executeQuery();
           
           while(rs.next()) {
              
              eVo.setExtraPayNum(rs.getString("extraPayNum"));
              eVo.setEmpNum(rs.getString("empNum"));
              eVo.setSalaryNum(rs.getString("salary"));
              eVo.setPaymentDate(rs.getString("paymentDate"));
              eVo.setPrice(rs.getString("price"));
              eVo.setExtraPayRemarks(rs.getString("extraPayRemarks"));
           }
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         
      }return eVo;
      
      
      
   }

}