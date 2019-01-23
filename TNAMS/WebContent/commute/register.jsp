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
               <h3 class="box-title">출퇴근 등록</h3>
            </div>
            <!-- /.box-header -->

            <form role="form" name="frm" method="post" class="form-horizontal">
               <!-- 
               onsubmit="return validateEmptyVal()" -->
               <input type="hidden" name="validation">
               <div class="box-body box-form-custom">


                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">출근 일시
                     </label>
                     <div class="col-sm-10">
                        <input type="text" name='goToWorkTime' class="form-control"readonly> 
                        <span id="validatePwEmailMessage"></span>
                     </div>
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">퇴근 일시
                     </label>
                     <div class="col-sm-10">
                        <input type="text" name='offWokrTime' class="form-control"readonly> 
                        <span id="validatePwEmailMessage"></span>
                     </div>
                  </div>

                  <div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">비고</label> 
							<div class="col-sm-10">
								<textarea rows="5" name='commuteRemarks' class="form-control"></textarea>
							</div>
				</div>

               </div>



               <!-- /.box-body -->

               <div class="box-footer btn-group-center">
                  <button id="ins_btn" class="btn btn-primary" type="submit"
                     onclick="return stuWriteCheck()">등록</button>
                  <a type="button" href="/student?command=studentListForm"
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
