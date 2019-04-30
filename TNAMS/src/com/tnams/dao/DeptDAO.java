package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.DeptVO;

public class DeptDAO extends CommonDao{
   
   /*list 조회, modify 수정, regist등록 delete 삭제 read검색*/

private DeptDAO() {
      
   }
   
   public static DeptDAO instance = new DeptDAO();
   
   public static DeptDAO getInstance() {
      if(instance == null) {
         instance = new DeptDAO();
      }
      return instance;
   }
   
   //조회
   public List<DeptVO> selectDept() {
      
      String sql = "SELECT DEPT_NUM"
                  + "         ,DEPT_NAME"
                  + "         ,DEPT_PHONENUM"
                  + "       FROM TBL_DEPT"
                  + " ORDER BY DEPT_NUM" ;
      
      /*String sql = "select * from tbl_dept order by dept_num desc";*/
      List<DeptVO> list = new ArrayList<DeptVO>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);

            while (rs.next()) {
               DeptVO dVo = new DeptVO();

               dVo.setDept_num(rs.getString("Dept_num"));
               dVo.setDept_name(rs.getString("Dept_name"));
               dVo.setDept_phonenum(rs.getString("Dept_phonenum"));

               list.add(dVo);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
         return list;
      }
   

   public ArrayList<DeptVO> getDeptList() throws Exception {
      ArrayList<DeptVO> deptList = new ArrayList<DeptVO>();
      String sql = "select * from TBL_DEPT ORDER BY DEPT_NUM DESC";

      Connection conn = null;
      PreparedStatement st = null;
      ResultSet rs = null;

      try {
         conn = getConnection();
         st = conn.prepareStatement(sql);
         rs = st.executeQuery();

         while (rs.next()) {
            DeptVO dVo = new DeptVO();
            dVo.setDept_num(rs.getString("dept_num"));
            dVo.setDept_name(rs.getString("dept_name"));
            dVo.setDept_phonenum(rs.getString("Dept_phonenum"));
            deptList.add(dVo);

         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //dbClose();
      }
      return deptList;
   }   
   
   //등록
   public void insertDept(DeptVO dVo) {
        
         String sql = "insert into TBL_DEPT (dept_num, dept_name, dept_phonenum) values(dept_seq.nextval,?,?)";

         Connection conn = getConnection();
         PreparedStatement pstmt;

         try {

            pstmt = conn.prepareStatement(sql);

            //pstmt.setString(1, dVo.getDept_num());
            pstmt.setString(1, dVo.getDept_name());
            pstmt.setString(2, dVo.getDept_phonenum());
            pstmt.executeUpdate();

         } catch (SQLException e) {
            e.printStackTrace();

         } finally {
            dbClose();
         }
   }
   
   //수정
   public void updateDept(DeptVO dVo) throws Exception{
         String sql = "UPDATE TBL_DEPT SET DEPT_NAME=?, DEPT_PHONENUM=? WHERE DEPT_NUM=?";
         Connection conn = null;
         PreparedStatement pstmt = null;

         try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dVo.getDept_name());
            pstmt.setString(2, dVo.getDept_phonenum());
            pstmt.setString(3, dVo.getDept_num());

            pstmt.executeUpdate();

         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
      }
   
   //삭제
    public int deleteDept(Object deptNumIndivi) {

         String sql = "DELETE FROM TBL_DEPT WHERE DEPT_NUM=?";

         Connection conn = null;
         PreparedStatement pstmt;
         try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, (String)deptNumIndivi);
            
            pstmt.executeUpdate();

         } catch (SQLException e) {
            e.printStackTrace();
         }
         dbClose();
      return 0;
      }
    
    //검색
    public DeptVO readOnDeptByName(String dept_name) throws Exception {
       
       String sql = "SELECT * FROM TBL_DEPT WHERE DEPT_NAME=?";
       
       Connection conn=null;
       PreparedStatement pstmt= null;
       ResultSet rs = null;
       DeptVO dVo = new DeptVO();
       
       try {
          conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dept_name);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {

               dVo.setDept_num(rs.getString("Dept_num"));
               dVo.setDept_name(rs.getString("Dept_name"));
               dVo.setDept_phonenum(rs.getString("Dept_phonenum"));

            }
       } catch(SQLException e) {
          e.printStackTrace();
       } finally {
          //dbClose();
       }
      return dVo;
    }

}
