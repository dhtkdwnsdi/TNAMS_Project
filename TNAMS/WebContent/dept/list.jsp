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
               <h2 class="box-title">부서 목록</h2>
            </div>
            <div class="box-wrap">
               <div class="box-body">
                  <div class="box-keyword">
                     <form method="get">
                     <div class="row">
                        <div class="col-md-2 col-xs-4">
                           <select class="form-control" name="searchType">
                               <option>--</option>
                              <option value="dept_num"
                                 <c:out value="${cri.searchType eq 'dept_num'?'selected':''}"/>>
                                 부서 번호
                              </option>
                              <option value="dept_name"
                                 <c:out value="${cri.searchType eq 'dept_name'?'selected':''}"/>>
                                 부서명
                              </option>
                              <option value="dept_phonenum"
                                 <c:out value="${cri.searchType eq 'dept_phonenum'?'selected':''}"/>>
                                 연락처
                              </option>
                           </select>
                        </div>
                        <div  class="col-md-4 col-xs-8">
                           <input type="text" class="form-control" placeholder="키워드를 입력하세요"
                              name="keyword" value="${cri.keyword}">
                        </div>
                     </div>
                     <div class="row">
                        <div  class="btn-group-custom">
                           <button type="submit" class="btn btn-default"><i class="fa fa-search"></i> 검색</button>
                        </div>
                     </div>
                     </form>
                  </div>
                  
                  <form action="dept?command=deptDelete" method="post">
                  <table class="table table-striped" id="user-table">
                  <thead>
                     <tr>
                        <th>부서번호</th>
                        <th>부서명</th>
                        <th>부서 연락처</th>
                     </tr>
                  </thead>
                     <c:forEach items="${list}" var="DeptVO">
                     <tbody>
                        <tr>
                           <td style="text-align: center;"><input type="checkbox" value="${DeptVO.dept_num}" name="deptCheck" id="deptCheck"></td>
                           <td style="text-align: center;"><a
                              href="dept?command=deptModifyForm&dept_num=${DeptVO.dept_num}">
                                 ${DeptVO.dept_name} </a>
                           </td>
                           <td style="text-align: center;">${DeptVO.dept_phonenum}</td>
                        </tr>
   
                     </c:forEach>
   
                  </table>
               <div class="box-footer">
   
                  <div class="text-center">
                     <ul class="pagination">
   
                        <c:if test="${pageMaker.prev}">
                           <li><a
                              href="list${pageMaker.makeAppSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
                        </c:if>
   
                        <c:forEach begin="${pageMaker.startPage }"
                           end="${pageMaker.endPage }" var="idx">
                           <li
                              <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                              <a href="list${pageMaker.makeAppSearch(idx)}">${idx}</a>
                           </li>
                        </c:forEach>
   
                        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                           <li><a
                              href="list${pageMaker.makeAppSearch(pageMaker.endPage +1) }">&raquo;</a></li>
                        </c:if>
                     </ul>
                  </div> <!-- .text-center END -->
                  <div class="btn-group-custom">
                     <a type="button" href="dept?command=deptRegistForm" class="btn btn-default">등록</a>
                  </div>
                  <div class="btn-group-custom">
                     <input type="submit" class="btn btn-default" value="삭제"/>
                  </div> 
                  </div>
                  </form>
                  
               </div>
               </div> <!-- .box-footer END -->
               
            </div> <!-- .box-wrap END -->
         </div>
      </div>
                  
      <!--/.col (left) -->

   <!-- /.row -->
</section>
<!-- /.content -->

<script>
   var result = '${msg}';

   if (result == 'SUCCESS') {
      alert("처리가 완료되었습니다.");
   }else(result == 'FAIL'){
      alert("실패");
   }

</script>

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
      var arrSal = document.getElementsByName("deptCheck");

       for (var i = 0; i < arrSal.length; i++) {
          if (arrSal[i].checked == true) {
             isChk = true;
             break;
          }
       }

       if (!isChk) {
          alert("선택된 부서 항목이 없습니다.");
       } else {
          alert("삭제되었습니다.")
          formObj.submit();
       }



</script>

<%@include file="../include/footer.jsp"%>