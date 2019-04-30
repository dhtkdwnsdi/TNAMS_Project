<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Bootstrap 3.3.4 -->
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<!-- <link rel="stylesheet" href="/css/jquery-ui.min.css"> -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">
    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
    <script src="../resources/js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>

	<script type="text/javascript" src="resources/js/regi.js"></script>
<%@include file="../include/header.jsp"%>

<script type="text/javascript">
	//캘린더
	$(function() {
		$('.input-group.date').datepicker({
			calendarWeeks : false,
			todayHighlight : true,
			autoclose : true,
			format : "yyyy-mm-dd",
			language : "kr"
		});
	});

</script>


<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">수당 등록</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" name="frm" method="post" class="form-horizontal"
					action="extraPay?command=extraPayRegist">
				
					<input type="hidden" name="validation">
					<div class="box-body box-form-custom">


						<div class="form-group input-with-button">
							<label for="empNum" class="col-sm-2 control-label pull-left">사원명<span class="must-mark">*</span></label>
						      <input name="empNum"   class="form-control" type="hidden">
						      <div class="col-md-3 col-xs-4 left-input">
						      	<input name="empName" class="form-control" type="text" readonly="readonly">
							  </div>
							  <div class="col-md-7 col-xs-5 right-button">
								  <button type = "button" onClick = "empNameCheck()" id = "idCheck">
									<i class="fa fa-search" aria-hidden="true"></i>
								  </button>
							  </div>
							</div>

						<div class="form-group input-with-button">
							<label for="salaryNum" class="col-sm-2 control-label pull-left">급여명<span class="must-mark">*</span></label>
						      <input name="salaryNum"   class="form-control" type="hidden">
						      <div class="col-md-3 col-xs-4 left-input">
						      	<input name="salaryName" class="form-control" type="text" readonly="readonly">
							  </div>
							  <div class="col-md-7 col-xs-5 right-button">
								  <button type = "button" onClick = "salaryNameCheck()" id = "idCheck">
									<i class="fa fa-search" aria-hidden="true"></i>
								  </button>
							  </div>
							</div>

						<div class="form-group input-double">
							<label for="paymentDate" class="col-sm-2 control-label">
								지급일<span class="must-mark">*</span>
							</label>
							<div class="col-sm-4">
								<div class="input-group date">
									<input type="text" class="form-control"  name="paymentDate" placeholder="지급 일자를 입력해주세요">
									<span class="input-group-addon">
									<i class="glyphicon glyphicon-calendar"></i></span>
								</div>
							</div>
						</div>

						<div class="form-group input-short">
							<label for="price" class="col-sm-2 control-label">가격<span
								class="must-mark">*</span></label>
							<div class="col-sm-10">
								<input id="price" type="text" name="price" maxlength="13"
									class="form-control" placeholder="가격을 입력해주세요"> <span
									id="validatePhoneMessage"></span>
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">비고</label>
							<div class="col-sm-10">
								<input id="extraPayRemarks" type="text" name="extraPayRemarks"
									maxlength="13" class="form-control" placeholder="비고을 입력해주세요">
								<span id="validatePhoneMessage"></span>
							</div>
						</div>

					</div>



					<!-- /.box-body -->

					<div class="box-footer btn-group-center">
						<button id="ins_btn" class="btn btn-primary" type="submit">등록</button>
						<a type="button" href="extraPay?command=extraPayListForm"
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
function empNameCheck() {
	var url = "/emp?command=empSearchForm"
			window.open(url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

function salaryNameCheck() {
	var url = "/salary?command=salarySearchForm"
			window.open(url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400");
}

</script>
