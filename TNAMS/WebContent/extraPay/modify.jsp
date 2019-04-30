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
               <h3 class="box-title">수당 정보 수정</h3>
            </div>
            <!-- /.box-header -->

            <form role="form" method="post" action="extraPay?command=modify"
               class="form-horizontal" onsubmit="return validateEmptyVal()">
               <input type="hidden" name="validation">
               <div class="box-body box-form-custom">
                  
                  <div class="form-group input-with-button">
                     <label for="exampleInputEmail1"
                        class="col-sm-2 control-label pull-left">수당번호<span
                        class="must-mark">*</span></label>
                     <div class="col-md-3 col-xs-4 left-input">
                        <input name="extraPayNum" class="form-control" type="text"  readonly="readonly" value="${extraPayNum}"> <input
                           name="extraPayNumOk" class="form-control" type="hidden">
                     </div>
                     
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">사원번호<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='empNum' class="form-control"
                            value="${empNum}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>
                  
                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">급여번호<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='salaryNum' class="form-control"
                            value="${salaryNum}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>
                  
                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">지급일<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='paymentDate' class="form-control"
                            value="${paymentDate}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">금액<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='price' class="form-control"
                            value="${price}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>
                  
                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">비고<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='extraPayRemakrks' class="form-control"
                            value="${extraPayRemakrks}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>

               </div>
               <div class="box-footer btn-group-center">
                  <!-- <button type="button" class="btn btn-danger" onclick="remove()">삭제</button> -->
                  <button type="submit" class="btn btn-primary">수정</button>
                  <a type="button" href="/extraPay?command=extraPayListForm"
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
      if (document.getElementsByName("dept_name")[0].value == "") {
         alert("부서명을 입력해주세요");
         document.getElementsByName("dept_name")[0].focus();
         return false;
      }
      if (document.getElementsByName("dept_phone")[0].value == "") {
         alert("부서 연락처를 입력해주세요");
         document.getElementsByName("dept_phone")[0].focus();
         return false;
      }

      alert("수정되었습니다.");
      return true;
   }
</script>