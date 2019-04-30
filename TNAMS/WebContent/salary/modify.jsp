<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>


<!-- Main content -->
<section class="content">
   <div class="row">
      <!-- left column -->
      <div class="col-md-12">
         <!-- general form elements -->
         <div class="box">
            <div class="box-header">
               <h3 class="box-title">급여항목 수정</h3>
            </div>
            <!-- /.box-header -->

            <form role="form" method="post" action="salary?command=salaryModify"
               class="form-horizontal" onsubmit="return validateEmptyVal()">
               <input type="hidden" name="validation">
               <div class="box-body box-form-custom">
                  
                  <div class="form-group input-with-button">
                     <label for="exampleInputEmail1"
                        class="col-sm-2 control-label pull-left">급여항목번호<span
                        class="must-mark">*</span></label>
                     <div class="col-md-3 col-xs-4 left-input">
                        <input name="salaryNum" class="form-control" type="text"  readonly="readonly" value="${salaryNum}"> <input
                           name="salaryNumOk" class="form-control" type="hidden">
                     </div>
                     
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">급여항목명<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='salaryName' class="form-control"
                           placeholder="급여항목명을 입력해주세요" value="${salaryName}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">과세여부
                        <span class="must-mark">*</span>
                     </label>
                     <div class="col-sm-10">
                        <select id='taxed' name='taxed'>
                           <c:if test="${taxed == '있음'}">
                           <option value='' selected>--선택--</option>
                           <option value='있음' selected="selected">있음</option>
                           <option value='없음'>없음</option>
                           </c:if>
                           
                           <c:if test="${taxed == '없음'}">
                           <option value='' selected>--선택--</option>
                           <option value='있음'>있음</option>
                           <option value='없음' selected="selected">없음</option>
                           </c:if>
                           
                        </select>
                     </div>
                  </div>

               </div>
               <div class="box-footer btn-group-center">
                  <!-- <button type="button" class="btn btn-danger" onclick="remove()">삭제</button> -->
                  <button type="submit" class="btn btn-primary">수정</button>
                  <a type="button" href="/salary?command=salaryListForm"
                     class="btn btn-default">취소</a>
                  <!-- <button type="button" class="btn btn-cancel">취소</button> -->
                  
               </div>
                  
                  
               
               </form>
               

            
                  
         </div>
         <!-- /.box -->
      </div>
      <!--/.col (left) -->

   </div>
   <!-- /.row -->
</section>
<!-- /.content -->
<!-- /.content-wrapper -->


<%@include file="../include/footer.jsp"%>




<script>
//유효성 검사
   function validateEmptyVal() {
      if (document.getElementsByName("salaryNum")[0].value == "") {
         alert("급여항목번호를 입력해주세요");
         document.getElementsByName("salaryNum")[0].focus();
         return false;
      }
      if (document.getElementsByName("salaryName")[0].value == "") {
         alert("급여항목명을 입력해주세요");
         document.getElementsByName("salaryName")[0].focus();
         return false;
      }
      if (document.getElementsByName("taxed")[0].value == "") {
         alert("과세여부를 입력해주세요");
         document.getElementsByName("taxed")[0].focus();
         return false;
      }

      alert("수정되었습니다.");
      return true;
   }
</script>