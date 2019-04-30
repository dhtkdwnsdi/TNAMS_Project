<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>사원명 검색</title>
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
					<h2 class="box-title">사원명 검색</h2>
					<p>
					<form method="post" action="emp?command=empSearch">
								<input type="text" name="empName">
					<input type="submit" class="btn btn-default" value="검색">
					</form>
				</div>
				
						</div>
						<form method="post" name="frm">
						<table class="table table-striped">
							<tr>
								<th>근태 항목 번호</th>
								<th>근태명</th>
								<th>유급/무급</th>
								<th>과세여부</th>
							</tr>
							<c:forEach items="${empList}" var="EmpVO">
								<tr>
									<td style="text-align: center;"><input type="hidden" name="empNum" value = "${EmpVO.empNum}">
									<a onclick= "return sendToParent()"> ${EmpVO.empNum}</a></td>
									<td style="text-align: center;"><input type="hidden" name="empName" value = "${EmpVO.empName}">
									<a onclick= "return sendToParent()"> ${EmpVO.empName}</a></td>
									<td style="text-align: center;">${EmpVO.deptName }</td>
									<td style="text-align: center;">${EmpVO.empPosition}</td>
								</tr>
							
							</c:forEach>

						</table>
						</form>
					</div>
					<!-- /.box-body -->


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
						</div>
						<!-- .text-center END -->
					</div>
					<!-- .box-footer END -->
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
			   window.opener.document.frm.empNum.value = document.frm.empNum.value;
			   window.opener.document.frm.empName.value = document.frm.empName.value;
			   self.close();
			   
			}
	</script>


</body>
</html>