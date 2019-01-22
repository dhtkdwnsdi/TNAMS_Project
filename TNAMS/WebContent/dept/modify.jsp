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
					<h3 class="box-title">부서 정보 수정</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post" action="dept?command=dept_modify"
					class="form-horizontal" onsubmit="return validateEmptyVal()">
					<input type="hidden" name="validation">
					<div class="box-body box-form-custom">
						
						<div class="form-group input-with-button">
                     <label for="exampleInputEmail1"
                        class="col-sm-2 control-label pull-left">부서번호<span
                        class="must-mark">*</span></label>
                     <div class="col-md-3 col-xs-4 left-input">
                        <input name="dept_num" class="form-control" type="text"  readonly="readonly" value="${dept_num}"> <input
                           name="dept_numOk" class="form-control" type="hidden">
                     </div>
                     
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">부서명<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='dept_name' class="form-control"
                           placeholder="부서명을 입력해주세요" value="${dept_name}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>

                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">부서 연락처<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='dept_phonenum' class="form-control"
                           placeholder="연락처를 입력해주세요" value="${dept_phonenum}"> <span
                           id="validatePwEmailMessage"></span>
                     </div>
                  </div>

               </div>
					<div class="box-footer btn-group-center">
						<!-- <button type="button" class="btn btn-danger" onclick="remove()">삭제</button> -->
						<button type="submit" class="btn btn-primary">수정</button>
						<a type="button" href="/dept?command=deptListForm"
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