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
               <h3 class="box-title">부서 등록</h3>
            </div>
            <!-- /.box-header -->

            <form role="form" name="frm" method="post" class="form-horizontal" action="dept?command=deptRegist">
               <!-- 
               onsubmit="return validateEmptyVal()" -->
               <input type="hidden" name="validation">
               <div class="box-body box-form-custom">

            <!-- 부서번호 칸 맞추기 -->
                 <%-- <div class="form-group input-with-button">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">
                           부서번호 <span class="must-mark">*</span></label>
                           <div class="col-sm-10">
                        <input name="dept_num" class="form-control" type="text"  value="${dept_num}" disabled> 
                        <!-- <input name="dept_numOk" class="form-control" type="hidden"> -->  <!-- readonly="readonly" -->
                     </div>
                  </div> --%>
                 

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">부서명<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='dept_name' class="form-control" id="dept_name"
                           placeholder="부서명을 입력해주세요"> 
                     </div>
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">부서 연락처<span class="must-mark">*</span></label> 
                     <div class="col-sm-10">
                        <input id="dept_phonenum" type="text" name='dept_phonenum' maxlength="13" class="form-control" placeholder="ex) 0421112221">
                        
                     </div>
                  </div>

               </div>



               <!-- /.box-body -->

               <div class="box-footer btn-group-center">
                  <button id="sub_btn" class="btn btn-primary" type="submit"
                     onclick="return deptRegistCheck()">등록</button>
                  <a type="button" href="dept?command=deptListForm"
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

