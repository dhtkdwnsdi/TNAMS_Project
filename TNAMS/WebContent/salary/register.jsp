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
               <h3 class="box-title">급여항목 등록</h3>
            </div>
            <!-- /.box-header -->

            <form role="form" name="frm" method="post" class="form-horizontal"
               action="/salary?command=salaryRegist">
               <!-- 
               onsubmit="return validateEmptyVal()" -->
               <input type="hidden" name="validation">
               <div class="box-body box-form-custom">


                  <!--                   <div class="form-group input-with-button">
                     <label for="exampleInputEmail1"
                        class="col-sm-2 control-label pull-left">급여항목번호<span
                        class="must-mark">*</span></label>
                     <div class="col-md-3 col-xs-4 left-input">
                        <input name="salaryNum" class="form-control" type="text"  readonly="readonly"> <input
                           name="salaryNumOk" class="form-control" type="hidden">
                     </div>
                     <div class="col-md-7 col-xs-5 right-button">
                        <button type="button" onClick="salaryNumCheck()" id="numCheck">
                           <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                     </div>
                  </div> -->

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">급여항목명<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='salaryName' class="form-control"
                           placeholder="급여항목명을 입력해주세요"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">과세여부
                        <span class="must-mark">*</span>
                     </label>
                     <div class="col-sm-10">
                        <select id='taxed' name='taxed'>
                           <option value='' selected>--선택--</option>
                           <option value='있음'>있음</option>
                           <option value='없음'>없음</option>
                        </select>
                     </div>
                  </div>

               </div>



               <!-- /.box-body -->

               <div class="box-footer btn-group-center">
                  <button id="ins_btn" class="btn btn-primary" type="submit"
                     onclick="return salaryWriteCheck()">등록</button>
                  <a type="button" href="/salary?command=salaryListForm"
                     class="btn btn-default">취소</a>

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

<!-- </div> -->
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>



<script>
   function salaryWriteCheck() {

      if (document.frm.salaryName.value == "") {
         alert("급여항목이름을 입력하세요");
         document.frm.salaryName.focus();
         return false;
      } else if (document.frm.taxed.value == "") {
         alert("과세 여부를 선택하세요");
         document.frm.taxed.focus();
         return false;
      } else {
         var name = document.frm.salaryName.value;
         var isCorrect = confirm(name + " 급여항목을 등록하시겠습니까?");
         if (isCorrect == true) {
            return true;
         } else {
            return false;
         }
      }
   }
</script>