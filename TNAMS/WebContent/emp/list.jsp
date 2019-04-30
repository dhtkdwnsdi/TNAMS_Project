<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>


<!-- Main content -->
<section class="content">
   <div class="row">
      <div class="col-md-12">
         <div class="box">
            <div class="box-header with-border">
               <h2 class="box-title">사원  목록</h2>
            </div>   
            <div class="box-wrap">
               <div class="box-body">
                  <div class="box-keyword">
                     <form method="get">
                     <div class="row">
                        <div class="col-md-2 col-xs-4">
                           <select class="form-control" name="searchType">
                              <option>이름</option>
                           </select>
                        </div>
                        <div  class="col-md-4 col-xs-8">
                           <input type="text" class="form-control" placeholder="이름을 입력하세요"
                              id="keyword" onkeydown="return enter(event)">
                        </div>
                     </div>
                     </form>
                  </div>
                     <form action="emp?command=empDelete" method="post">
                     <div class="row">
                  <table class="table table-bordered" id="user-table">
                  <thead>
                     <tr>
                        <th></th>
                        <th style="text-align: center;">사번</th>
                        <th style="text-align: center;">이름</th>
                        <th style="text-align: center;">부서명</th>
                        <th style="text-align: center;">직급</th>
                     </tr>
                  </thead>

                  <c:forEach items="${empList}" var="EmpVO">
                     <tbody>
                        <tr>
                           <td><input type="checkbox" value="${EmpVO.empNum}" name="empCheck" id="empCheck"></td>
                           <td style="text-align: center;">${EmpVO.empNum}</td>
                           <td style="text-align: center;">
                           <a href="emp?command=empModifyForm&empNum=${EmpVO.empNum}">${EmpVO.empName}</a></td>
                           <td style="text-align: center;">${EmpVO.deptName}</td>
                           <td style="text-align: center;">${EmpVO.empPosition}</td>
                        </tr>
                  </tbody>
                  </c:forEach>
               </table>
               <div class="box-footer btn-group-right">            
               <a type="button" class="btn btn-primary" id="newBtn" style="float: center"
               href="emp?command=empRegistForm">신규 등록</a>
               <input type="submit" class="btn btn-danger" style="float: center" value="삭제"/>
               </div>
               </div>
               </form>
            </div>
            </div>
         </div>
      </div>
   </div>
</section>

<script>
   var result = '${msg}';

   if (result == 'SUCCESS') {
      alert("처리가 완료되었습니다.");
   }else(result == 'FAIL'){
      alert("실패");
   }

</script>
<!-- /.content -->
<%@include file="../include/footer.jsp"%>