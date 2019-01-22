package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tnams.vo.SalaryVO;

public class SalaryDAO extends CommonDao {

   private static SalaryDAO instance;

   public static SalaryDAO getInstance() {
      if (instance == null) {
         instance = new SalaryDAO();
      }
      return instance;
   }

   // 급여 항목 목록 가져오기
   public ArrayList<SalaryVO> SalaryList() {

      ArrayList<SalaryVO> list = new ArrayList<SalaryVO>();

      Connection conn = getConnection();
      PreparedStatement st;
      ResultSet rs = null;
      String sql = "SELECT * FROM TBL_SALARY";
      //String sql = "SELECT * FROM TBL_SALARY ORDER BY salIndex DESC";

      
      try {
         st = conn.prepareStatement(sql);
         rs = st.executeQuery();

         while (rs.next()) {
            SalaryVO salVo = new SalaryVO();
            salVo.setSalaryNum(rs.getString("salaryNum"));
            salVo.setSalaryName(rs.getString("salaryName"));
            salVo.setTaxed(rs.getString("taxed"));
         

            list.add(salVo);

         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return list;
   }

   // 급여항목 , 급여항목 목록 가져오기, 급여항목 수정
   public ArrayList<SalaryVO> SalaryTotalList() {

      ArrayList<SalaryVO> list = new ArrayList<SalaryVO>();

      Connection conn = getConnection();
      PreparedStatement st;
      ResultSet rs = null;
      String sql = "SELECT salary_num AS salaryNum,"
            +    "salary_name AS salaryName,"
            +    "taxed AS taxed FROM TBL_SALARY";

      try {
         st = conn.prepareStatement(sql);
         rs = st.executeQuery();

         while (rs.next()) {
            SalaryVO salVo = new SalaryVO();
            salVo.setSalaryNum(rs.getString("salaryNum"));
            salVo.setSalaryName(rs.getString("salaryName"));
            salVo.setTaxed(rs.getString("taxed"));

            list.add(salVo);

         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return list;
   }

   public void insertStudent(SalaryVO salVo) {
      String sql = "insert into TBL_SALARY(salary_num" 
               +",                         salary_name"
            +",                          taxed)"
            +"                           values(?, ?, ?)";

      Connection conn = null;
      PreparedStatement st = null;

      try {
         conn = getConnection();
         st = conn.prepareStatement(sql);

         st.setString(1, salVo.getSalaryNum());
         st.setString(2, salVo.getSalaryName());
         st.setString(3, salVo.getTaxed());

         st.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();

      } finally {
         dbClose();
      }
   }

   public ArrayList<SalaryVO> getSalaryList() {
      ArrayList<SalaryVO> salaryList = new ArrayList<SalaryVO>();
      String sql = "select * from TBL_SALARY";

      Connection conn = null;
      PreparedStatement st = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         st = conn.prepareStatement(sql);
         rs = st.executeQuery();

         while (rs.next()) {
            SalaryVO salVo = new SalaryVO();
            salVo.setSalaryNum(rs.getString("salaryNum"));
            salVo.setSalaryName(rs.getString("salaryName"));
            salVo.setTaxed(rs.getString("taxed"));
            
            salaryList.add(salVo);

         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return salaryList;
   }

   public void updateSalary(SalaryVO salVo) {

      String sql = "update TBL_SALARY set salary_name = ?"
                 +",                      taxed = ? "
               +"where salary_num = ?";
      Connection conn = getConnection();
      PreparedStatement st;

      try {

         st = conn.prepareStatement(sql);

         st.setString(1, salVo.getSalaryNum());
         st.setString(2, salVo.getSalaryName());
         st.setString(3, salVo.getTaxed());

         st.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
   }

   public void deleteSalary(Object salaryNumIndivi) {

      String sql = "delete FROM TBL_SALARY where salary_num = ? ";
      Connection conn = null;
      PreparedStatement st;

      try {

         conn = getConnection();
         st = conn.prepareStatement(sql);

         st.setString(1, (String) salaryNumIndivi);
         st.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }

   }

   public int confirmSalaryNum(String salaryNum) {

      int result = -1;
      String sql = "SELECT salary_num "
               + "   FROM TBL_SALARY "
               + " WHERE salary_num = ?";
      Connection conn = null;
      PreparedStatement st = null;
      ResultSet rs = null;
      try {
         conn = getConnection();

         st = conn.prepareStatement(sql);

         st.setString(1, salaryNum);

         rs = st.executeQuery();

         if (salaryNum.equals("")) {
            // 데이터 NULL
            result = 0;

         } else if (rs.next()) {
            // 데이터 존재.
            result = 1;
            System.out.println(result + ":통과");

         } else {
            // 데이터 없음.
            result = -1;
         }
      } // 데이터 없음.
      catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return result;
   }

}
