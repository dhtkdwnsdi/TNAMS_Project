package com.tnams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tnams.vo.EmpVO;

public class EmpDAO extends CommonDao {
   
   private static EmpDAO instance;
   
      // EmpDAO 객체 리턴하는 메소드 [싱글턴]
      public static EmpDAO getInstance() {
         if (instance == null) {
            instance = new EmpDAO();
         }
         return instance;
      }
   
      //사원이름, 사원번호, 부서명, 직급 출력하는 메소드   emp/list.jsp
      public List<EmpVO> selectEmp() {
         
         String sql = "SELECT e.EMP_NUM AS empNum"
               + "         ,e.EMP_NAME AS empName"
               + "         ,e.EMP_POSITION AS empPosition"
               + "         ,d.DEPT_NAME AS deptName"
               + "       FROM TBL_EMP e, TBL_DEPT d "
               + "      WHERE d.DEPT_NUM = e.DEPT_NUM"
               + " ORDER BY EMP_NAME" ;

         List<EmpVO> list = new ArrayList<EmpVO>();
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;

         try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
               EmpVO eVo = new EmpVO();

               eVo.setEmpNum(rs.getString("empNum"));
               eVo.setEmpName(rs.getString("empName"));
               eVo.setDeptName(rs.getString("deptName"));
               eVo.setEmpPosition(rs.getString("empPosition"));
               list.add(eVo);
            }
            
         } catch (SQLException e) {
            
            e.printStackTrace();
            
         } finally {
            
            dbClose();
            
         }
         
         return list;
      }
      
      //사원 번호를 통해서 modify.jsp로 넘어가는 메소드
      
            public EmpVO readEmp(String empNum) {
               
               String sql = "SELECT EMP_NAME AS empName"
                     + "         ,DEPT_NUM AS deptNum"
                     + "         ,EMP_POSITION AS empPosition"
                     + "         ,BIRTHDAY AS birthday"
                     + "         ,EMAIL AS email"
                     + "         ,HP AS hp"
                     + "         ,TO_CHAR(START_WORK, 'YYYY-MM-DD') AS startWork"
                     + "         ,TO_CHAR(END_WORK, 'YYYY-MM-DD') AS endWork"
                     + "         ,ZIP_CODE AS zipCode"
                     + "         ,FRONT_ADDR AS frontAddr"
                     + "         ,REAR_ADDR AS rearAddr"
                     + "         ,FINAL_EDUCATION AS finalEducation"
                     + "         ,FINAL_SCHOOL AS finalSchool"
                     + "       FROM TBL_EMP"
                     + "      WHERE EMP_NUM = '" + empNum +"'";

               EmpVO eVo = new EmpVO();
               Connection conn = null;
               Statement stmt = null;
               ResultSet rs = null;

               try {
                  conn = getConnection();
                  stmt = conn.prepareStatement(sql);
                  rs = stmt.executeQuery(sql);

                  if (rs.next()) {

                     eVo.setEmpName(rs.getString("empName"));
                     eVo.setDeptNum(rs.getString("deptNum"));
                     eVo.setEmpPosition(rs.getString("empPosition"));
                     eVo.setBirthday(rs.getString("birthday"));
                     eVo.setEmail(rs.getString("email"));
                     eVo.setHp(rs.getString("hp"));
                     eVo.setStartWork(rs.getString("startWork"));
                     eVo.setEndWork(rs.getString("endWork"));
                     eVo.setZipCode(rs.getString("zipCode"));
                     eVo.setFrontAddr(rs.getString("frontAddr"));
                     eVo.setRearAddr(rs.getString("rearAddr"));
                     eVo.setFinalEducation(rs.getString("finalEducation"));
                     eVo.setFinalSchool(rs.getString("finalSchool"));
                     
                  }
                  
               } catch (SQLException e) {
                  
                  e.printStackTrace();
                  
               } finally {
                  
                  dbClose();
                  
               }
               
               return eVo;
            }
            
            //사원명으로 사원번호, 사원명, 부서명, 직급을 출력하는 search.jsp 메소드
            
            public List<EmpVO> searchEmp(String empName) {
               
               String sql = "SELECT e.EMP_NUM AS empNum,"
                     + "          e.EMP_NAME AS empName,"
                     + "          d.DEPT_NAME AS deptName,"
                     + "          e.EMP_POSITION AS empPosition"
                     + "      FROM TBL_EMP e, TBL_DEPT d"
                     + "      WHERE d.DEPT_NUM = e.DEPT_NUM"
                     + "       AND e.EMP_NAME = '" + empName + "'";
                     
               List<EmpVO> list = new ArrayList<EmpVO>();
               Connection conn = null;
               Statement stmt = null;
               ResultSet rs = null;

               try {
                  conn = getConnection();
                  stmt = conn.prepareStatement(sql);
                  rs = stmt.executeQuery(sql);

                  if (rs.next()) {
                     EmpVO eVo = new EmpVO();
                     
                     eVo.setEmpNum(rs.getString("empNum"));
                     eVo.setEmpName(rs.getString("empName"));
                     eVo.setDeptName(rs.getString("deptName"));
                     eVo.setEmpPosition(rs.getString("empPosition"));
                     list.add(eVo);
                  }
                  
               } catch (SQLException e) {
                  
                  e.printStackTrace();
                  
               } finally {
                  
                  dbClose();
                  
               }
               
               return list;
            }
      
            //사원 번호를 통해서 modify.jsp로 넘어가는 메소드
            
            public EmpVO readEmpSelf(String empNum) {
               
               String sql = "SELECT EMP_NAME AS empName"
                     + "         ,EMP_PW as empPw"
                     + "         ,DEPT_NUM AS deptNum"
                     + "         ,EMP_POSITION AS empPosition"
                     + "         ,BIRTHDAY AS birthday"
                     + "         ,EMAIL AS email"
                     + "         ,HP AS hp"
                     + "         ,TO_CHAR(START_WORK, 'YYYY-MM-DD') AS startWork"
                     + "         ,TO_CHAR(END_WORK, 'YYYY-MM-DD') AS endWork"
                     + "         ,ZIP_CODE AS zipCode"
                     + "         ,FRONT_ADDR AS frontAddr"
                     + "         ,REAR_ADDR AS rearAddr"
                     + "         ,FINAL_EDUCATION AS finalEducation"
                     + "         ,FINAL_SCHOOL AS finalSchool"
                     + "       FROM TBL_EMP"
                     + "      WHERE EMP_NUM = '" + empNum +"'";

               EmpVO eVo = new EmpVO();
               Connection conn = null;
               Statement stmt = null;
               ResultSet rs = null;

               try {
                  conn = getConnection();
                  stmt = conn.prepareStatement(sql);
                  rs = stmt.executeQuery(sql);

                  if (rs.next()) {

                     eVo.setEmpName(rs.getString("empName"));
                     eVo.setEmpPw(rs.getString("empPw"));
                     eVo.setDeptNum(rs.getString("deptNum"));
                     eVo.setEmpPosition(rs.getString("empPosition"));
                     eVo.setBirthday(rs.getString("birthday"));
                     eVo.setEmail(rs.getString("email"));
                     eVo.setHp(rs.getString("hp"));
                     eVo.setStartWork(rs.getString("startWork"));
                     eVo.setEndWork(rs.getString("endWork"));
                     eVo.setZipCode(rs.getString("zipCode"));
                     eVo.setFrontAddr(rs.getString("frontAddr"));
                     eVo.setRearAddr(rs.getString("rearAddr"));
                     eVo.setFinalEducation(rs.getString("finalEducation"));
                     eVo.setFinalSchool(rs.getString("finalSchool"));
                     
                  }
                  
               } catch (SQLException e) {
                  
                  e.printStackTrace();
                  
               } finally {
                  
                  dbClose();
                  
               }
               
               return eVo;
            }
      
            
      //사원 정보 등록하는 테이블 empRegist.jsp
      public void insertEmp(EmpVO eVo) {
         
         String sql = "INSERT INTO TBL_EMP(EMP_NUM"
               + "                      ,EMP_PW"
               + "                      ,EMP_NAME"
               + "                      ,DEPT_NUM"
               + "                   ,EMP_POSITION"
               + "                      ,BIRTHDAY"
               + "                   ,EMAIL"
               + "                    ,HP"
               + "                   ,START_WORK"
               + "                   ,END_WORK"
               + "                   ,ZIP_CODE"
               + "                   ,FRONT_ADDR"
               + "                   ,REAR_ADDR"
               + "                   ,FINAL_EDUCATION"
               + "                   ,FINAL_SCHOOL)"
               + "   VALUES(TO_CHAR(sysdate,'YYYY')||emp_seq.nextval, default,"
               + "          ?, ?, ?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD'), null, ?, ?, ?, ?, ?)";

         Connection conn = null;
         PreparedStatement st = null   ;

         try {
            conn = getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, eVo.getEmpName());
            st.setString(2, eVo.getDeptNum());
            st.setString(3, eVo.getEmpPosition());
            st.setString(4, eVo.getBirthday());
            st.setString(5, eVo.getEmail());
            st.setString(6, eVo.getHp());
            st.setString(7, eVo.getStartWork());
            st.setString(8, eVo.getZipCode());
            st.setString(9, eVo.getFrontAddr());
            st.setString(10, eVo.getRearAddr());
            st.setString(11, eVo.getFinalEducation());
            st.setString(12, eVo.getFinalSchool());

            st.executeUpdate();
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
      }
      
      //사원 정보를 수정하는 메소드
      public void updateEmp (EmpVO eVo) {
            
            String sql = "UPDATE TBL_EMP SET EMP_NAME = ?,"
                  + "                     DEPT_NUM = ?,"
                  + "                     EMP_POSITION = ?,"
                  + "                     BIRTHDAY = ?,"
                  + "                     EMAIL = ?,"
                  + "                     HP = ?,"
                  + "                     START_WORK = TO_DATE(?,'YYYY-MM-DD'),"
                  + "                     END_WORK = TO_DATE(?,'YYYY-MM-DD'),"
                  + "                     ZIP_CODE = ?,"
                  + "                     FRONT_ADDR = ?,"
                  + "                     REAR_ADDR = ?,"
                  + "                     FINAL_EDUCATION = ?,"
                  + "                     FINAL_SCHOOL = ?"
                  + "        WHERE EMP_NUM = ?";
            
            Connection conn = null;
            PreparedStatement pstmt = null;

            
            try {
            	conn = getConnection();
            	pstmt = conn.prepareStatement(sql);
               
                
            	pstmt.setString(1, eVo.getEmpName());
            	pstmt.setString(2, eVo.getDeptNum());
            	pstmt.setString(3, eVo.getEmpPosition());
            	pstmt.setString(4, eVo.getBirthday());
            	pstmt.setString(5, eVo.getEmail());
            	pstmt.setString(6, eVo.getHp());
            	pstmt.setString(7, eVo.getStartWork());
            	pstmt.setString(8, eVo.getEndWork());
            	pstmt.setString(9, eVo.getZipCode());
            	pstmt.setString(10, eVo.getFrontAddr());
            	pstmt.setString(11, eVo.getRearAddr());
            	pstmt.setString(12, eVo.getFinalEducation());
            	pstmt.setString(13, eVo.getFinalSchool());
            	pstmt.setString(14, eVo.getEmpNum());
            	
            	pstmt.executeUpdate();
                
            }catch (SQLException e){
               e.printStackTrace();
            }finally {
               dbClose();
            }
         }  
      
      //사원 정보를 수정하는 메소드
      public void updateEmpSelf (EmpVO eVo) {
            
            String sql = "UPDATE TBL_EMP SET EMP_PW = ?,"
            		+ "					  EMP_NAME = ?,"
                  + "                     DEPT_NUM = ?,"
                  + "                     EMP_POSITION = ?,"
                  + "                     BIRTHDAY = ?,"
                  + "                     EMAIL = ?,"
                  + "                     HP = ?,"
                  + "                     START_WORK = TO_DATE(?,'YYYY-MM-DD'),"
                  + "                     END_WORK = TO_DATE(?,'YYYY-MM-DD'),"
                  + "                     ZIP_CODE = ?,"
                  + "                     FRONT_ADDR = ?,"
                  + "                     REAR_ADDR = ?,"
                  + "                     FINAL_EDUCATION = ?,"
                  + "                     FINAL_SCHOOL = ?"
                  + "        WHERE EMP_NUM = ?";
            
            Connection conn = null;
            PreparedStatement pstmt = null;

            
            try {
            	conn = getConnection();
            	pstmt = conn.prepareStatement(sql);
               
            	pstmt.setString(1, eVo.getEmpPw());
            	pstmt.setString(2, eVo.getEmpName());
            	pstmt.setString(3, eVo.getDeptNum());
            	pstmt.setString(4, eVo.getEmpPosition());
            	pstmt.setString(5, eVo.getBirthday());
            	pstmt.setString(6, eVo.getEmail());
            	pstmt.setString(7, eVo.getHp());
            	pstmt.setString(8, eVo.getStartWork());
            	pstmt.setString(9, eVo.getEndWork());
            	pstmt.setString(10, eVo.getZipCode());
            	pstmt.setString(11, eVo.getFrontAddr());
            	pstmt.setString(12, eVo.getRearAddr());
            	pstmt.setString(13, eVo.getFinalEducation());
            	pstmt.setString(14, eVo.getFinalSchool());
            	pstmt.setString(15, eVo.getEmpNum());
            	
            	pstmt.executeUpdate();
                
            }catch (SQLException e){
               e.printStackTrace();
            }finally {
               dbClose();
            }
         }  
      
      //사원 정보 삭제하는 메소드
      public void deleteEmp(EmpVO eVo) {
         
         String sql = "DELETE TBL_EMP"
               + "     WHERE EMP_NUM = ?";
         
         Connection conn = null;
         PreparedStatement st = null;
         
         try {
            conn = getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, eVo.getEmpNum());

            st.executeUpdate();
            
         } catch(SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
      }
      
       public int deleteEmp(Object empNumIndivi) {

            String sql = "DELETE FROM TBL_EMP WHERE EMP_NUM=?";

            Connection conn = null;
            PreparedStatement pstmt;
            try {
               conn = getConnection();
               pstmt = conn.prepareStatement(sql);
               
               pstmt.setString(1, (String)empNumIndivi);
               
               pstmt.executeUpdate();

            } catch (SQLException e) {
               e.printStackTrace();
            }
            dbClose();
         return 0;
         }
       
      
}