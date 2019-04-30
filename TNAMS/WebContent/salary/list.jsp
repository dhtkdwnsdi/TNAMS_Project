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
               <h2 class="box-title">급여 항목 목록</h2>
            </div>
            <div class="box-wrap">
               <div class="box-body">
                  <div class="box-keyword">
                     <form method="get">
                        <div class="row">
                           <div class="col-md-2 col-xs-4">
                              <select class="form-control" name="searchType">
                                 <option>급여항목명</option>
                                 
                              </select>
                           </div>
                           <div class="col-md-4 col-xs-8">
                           </div>
                        </div>
                        <div class="row">
                           <div class="btn-group-custom"></div>
                        </div>
                     </form>
                  </div>
                  <form name="frm" role="form" action="/salary?command=salaryDelete"
                     method="post">
                     <!-- <div style="overflow-y: scroll; height: 400px;"> -->
                     <table class="table table-bordered" id="user-table">
                        <thead>



                           <tr>
                              <th style="width: 10px"><input type="checkbox"
                                 name="AllCheck"></th>
                              <th style="text-align: center;">급여항목번호</th>
                              <th style="text-align: center;">급여항목명</th>
                              <th style="text-align: center;">과세여부</th>
                           </tr>
                        </thead>
                        <c:forEach items="${salaryList}" var="SalaryVO">
                           <tbody>

                              <tr>

                                 <td style="width: 10; text-align: center;"><input
                                    type="checkbox" value="${SalaryVO.salaryNum}"
                                    name="salaryCheck" id="salcheck"></td>
                                 <td style="text-align: center;">${SalaryVO.salaryNum}</td>
                                 <td style="text-align: center;"><a
                                    href="salary?command=salaryModifyForm&salaryNum=${SalaryVO.salaryNum}&salaryName=${SalaryVO.salaryName}&taxed=${SalaryVO.taxed}">${SalaryVO.salaryName}</a></td>
                                 <td style="text-align: center;">${SalaryVO.taxed}</td>
                              </tr>
                           </tbody>
                        </c:forEach>

                     </table>
                     <!--                   <div class="box-footer">
                        <button type="button" class="btn btn-danger" style = "float : right">삭제</button>
                     <a type="button" href = "salary?command=salaryRegistForm"
                        class="btn btn-primary" style = "float : right">신규 등록</a>
                     </div> -->

                     <div class="box-footer">
                        <button type="submit" class="btn btn-danger"
                           style="float: right">삭제</button>
                        <button type="button" class="btn btn-primary"
                           style="float: right">신규등록</button>
                     </div>
                  </form>



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
                  </div>
                  <!-- .text-center END -->
                  <div class="btn-group-custom"></div>
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


<%@include file="../include/footer.jsp"%>


<script>
   $(document).ready(function() {

      var formObj = $("form[role='form']");

      console.log(formObj);

      $(".btn-primary").on("click", function() {
         self.location = "salary?command=salaryRegistForm";
      });

   });


   var result = '${msg}';

   if (result == 'SUCCESS') {
      alert("처리되었습니다.");
   } else if (result == 'FAIL') {
      alert("이미 사용 중인 급여항목 입니다.");
   }
</script>

<script>

   //급여항목 선택 검사

   $(document).ready(function() {

      var formObj = $("form[role='form']");

      console.log(formObj);


      $("input[name=AllCheck]").click(function() {
         var chk = $(this).is(":checked");

         if (chk) {
            $("input[name='salaryCheck']").prop("checked", true);
         } else {
            $("input[name='salaryCheck']").prop("checked", false);
         }
      });

   });

   $(document).ready(
         function() {

            var formObj = $("form[role='form']");

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

   //검색기능
/*    $(document)
         .ready(
               function() {
                  $("#keyword")
                        .keyup(
                              function() {
                                 var k = $(this).val();
                                 $("#user-table > tbody > tr")
                                       .hide();
                                 var temp = $("#user-table > tbody > tr > td:nth-child(4n+3):contains('"
                                       + k + "')");

                                 $(temp).parent().show();
                              })
               })

   function enter(e) {
      if (window.event) {
         key = window.event.keyCode;
      } else if (e) {
         key = e.which;
      }
      if (key == 13) {
         return false
      }
   } */
</script>
