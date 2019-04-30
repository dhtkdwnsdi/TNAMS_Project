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
					<h2 class="box-title">수당 목록</h2>
				</div>
				<form action="extraPay?command=extraPayDelete" method="post"
					name=frm>
					<div class="box-wrap">
						<div class="box-body">

							<table class="table table-striped">
								<tr>
									<th>수당번호</th>
									<th>사원이름</th>
									<!-- <th>사원이름</th> -->
									<th>급여명</th>
									<th>지급날짜</th>
									<th>금액</th>
									<th>비고</th>
								</tr>
								<c:forEach items="${list}" var="ExtraPayVO">
									<tr>
										<td style="text-align: center;"><input type="checkbox"
											value="${ExtraPayVO.extraPayNum}" name="extraPayCheck"
											id="extraPayCheck"></td>
										<td style="text-align: center;"><a
											href="extraPay?command=extraPayModify&extraPayNum=${ExtraPayVO.extraPayNum}">${ExtraPayVO.empNum}</a></td>
										<%-- <td style="text-align: center;">${ExtraPayVO.EmpName}</td> --%>
										<td style="text-align: center;">${ExtraPayVO.salaryNum}</td>
										<td style="text-align: center;">${ExtraPayVO.paymentDate}</td>
										<td style="text-align: center;">${ExtraPayVO.price}</td>
										<td style="text-align: center;">${ExtraPayVO.extraPayRemarks}</td>
									</tr>

								</c:forEach>

							</table>
						</div>
						<!-- /.box-body -->
					</div>
					<a type="button" href="extraPay?command=extraPayRegistForm"
						class="btn btn-primary" id="sub_btn" style="float: center">등록</a>
					<input type="submit" class="btn btn-danger" style="float: center"
						value="삭제" />
				</form>
				<div class="box-footer" style="text-align: center;">

					<!-- .text-center END -->
					<!-- <div class="btn-group-custom"> -->
					<!-- </div>  -->
				</div>
				<!-- .box-footer END -->
			</div>
			<!-- .box-wrap END -->
		</div>
	</div>

	<!-- /.row -->
</section>
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
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});

	var arrSal = document.getElementsByName("salCheck");

	for (var i = 0; i < arrSal.length; i++) {
		if (arrSal[i].checked == true) {
			isChk = true;
			break;
		}
	}

	if (!isChk) {
		alert("선택된 수당항목이 없습니다.");
	} else {
		alert("삭제되었습니다.")
		formObj.submit();
	}
</script>

<%@include file="../include/footer.jsp"%>