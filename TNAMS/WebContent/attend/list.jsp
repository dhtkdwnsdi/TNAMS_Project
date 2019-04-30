<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>



<!-- Main content -->
<section class="content">
   <div class="row">
      <!-- left column -->

      <div class="col-md-12">
         <!-- general form elements -->

         <div class="box">
            <div class="box-header with-border">
               <h2 class="box-title">&nbsp;&nbsp;&nbsp;근태 목록</h2>
            </div>
            <div class="box-wrap">
               <div class="box-body" style="text-align: center;">
                  <div class="box-keyword">
                  </div>

                  <form role="form" method="post"
                     action="/attend?command=attendDelete">
                     

                     <div class="row">

                        <table class="table table-striped">
                           <tr>


                              <th>근태 번호</th>
                              <th>근태명</th>
                              <th>사원 번호</th>
                              <th>시작일</th>
                              <th>종료일</th>
                              <th>사유</th>
                              <th>승인 여부</th>

                           </tr>
                           <c:forEach items="${attendList}" var="AttendVO"
                              varStatus="status">
                              <tr>
<!-- 번호를 없애려면 EL태그 없앰 -->
                                 <td style="text-align: center;"><input type="checkbox" value="${AttendVO.attendanceNum}" name="attendCheck" id="attendCheck">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%-- ${AttendVO.attendanceNum} --%></td>
                                 <td style="text-align: center;"><a
                                    href="attend?command=attendUpdateForm&attendName=${AttendVO.attendanceNum}">${AttendVO.attendItemNum}</a></td>
                                 <td style="text-align: center;">${AttendVO.empNum}</td>
                                 <td style="text-align: center;">${AttendVO.startDate}</td>
                                 <td style="text-align: center;">${AttendVO.endDate}</td>
                                 <td style="text-align: center;">${AttendVO.attendanceRemarks}</td>
                                 <td style="text-align: center;">${AttendVO.approved}</td>

                              </tr>

                           </c:forEach>

                        </table>
                     </div>
                     <a type="button" href="attend?command=attendRegForm"
						class="btn btn-primary" id="sub_btn" style="float: center">등록</a>
                    
                       <button type = "submit" class="btn btn-danger" style = "float : center">삭제</button>
                     
                     
                  </form>
               </div>
               <!-- /.box-body -->


               <div class="box-footer">

                  <div class="text-center">
                     <ul class="pagination">
                     </ul>
                  </div>
                  <!-- .text-center END -->
                  <div class="btn-group-custom">
                     <!-- 등록버튼 -->
                  </div>
               </div>
               <!-- .box-footer END -->
            </div>
            <!-- .box-wrap END -->
         </div>
      </div>
      <!--/.col (left) -->

   </div>
   <!-- /.row -->
</section>
<!-- /.content -->

<script>
   var result = '${msg}';

   if (result == 'SUCCESS') {
      alert("처리가 완료되었습니다.");
   }
</script>
<!-- 검색버튼 -->
<script>
   $(document).ready(
         function() {

            $('#searchBtn').on(
                  "click",
                  function(event) {

                     self.location = "list"
                           + '${pageMaker.makeQuery(1)}'
                           + "&searchType="
                           + $("select option:selected").val()
                           + "&keyword=" + $('#keywordInput').val();

                  });

            $('#newBtn').on("click", function(evt) {

               self.location = "register";

            });

         });
</script>

<%@include file="../include/footer.jsp"%>