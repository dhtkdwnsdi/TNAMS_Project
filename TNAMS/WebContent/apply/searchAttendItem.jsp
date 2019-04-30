<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>급여 항목명 검색</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/admin/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/admin/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="/resources/admin/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />
<!-- 커스텀 스타일 -->
<link href="/resources/admin/custom.css" rel="stylesheet"
	type="text/css" />
<!-- CSS | Preloader Styles -->
<link href="/resources/css/preloader.css" rel="stylesheet"
	type="text/css">


</head>
<script src="/resources/admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>

<script src="/resources/js/jquery-plugin-collection.js"></script>
</head>

<body>
	<section class="content">
	<div class="row">
		<!-- left column -->

		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h2 class="box-title">근태 항목명 검색</h2>
					<p>
					<form method="post" action="attendItem?command=attendItemSearch">
								<input type="text" name="attendName">
					<input type="submit" class="btn btn-default" value="검색">
					</form>
				</div>
				
						</div>
						<form method="post" name="frm">
						<table class="table table-striped">
							<tr>
								<th>근태 항목 번호</th>
								<th>근태 항목명</th>
								<th>휴가 유무</th>
								<th>유급/무급</th>
							</tr>
							<c:forEach items="${list}" var="AttendItemVO">
								<tr>
									<td style="text-align: center;"><input type="hidden" name="attendItemNum" value = "${AttendItemVO.attendItemNum}">
									<a onclick= "return sendToParent()"> ${AttendItemVO.attendItemNum}</a></td>
									<td style="text-align: center;"><input type="hidden" name="attendName" value = "${AttendItemVO.attendName}">
									<a onclick= "return sendToParent()"> ${AttendItemVO.attendName}</a></td>
									<td style="text-align: center;">${AttendItemVO.vacation }</td>
									<td style="text-align: center;">${AttendItemVO.paid }</td>
								</tr>
							
							</c:forEach>

						</table>
						</form>
					</div>
					<!-- /.box-body -->


				</div>

	<!-- /.row --> </section>
	<!-- /.content -->

	<script>
		var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리가 완료되었습니다.");
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
										+ "&keyword="
										+ $('#keywordInput').val();

							});

					$('#newBtn').on("click", function(evt) {

						self.location = "register";

					});

				});
		
		function sendToParent(){
			   window.opener.document.frm.attend_item_num.value = document.frm.attendItemNum.value;
			   window.opener.document.frm.attendName.value = document.frm.attendName.value;
			   self.close();
			   
			}
	</script>


</body>
</html>