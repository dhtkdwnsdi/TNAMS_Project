<!--Mis 전체 수정 화면 !-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!-- Bootstrap 3.3.4 -->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<!-- <link rel="stylesheet" href="/css/jquery-ui.min.css"> -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">
<script type='text/javascript'
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script src="../resources/js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>


<%@include file="/include/header.jsp"%>

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

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h2 class="box-title">출결 목록 화면</h2>
				</div>
				<div class="box-wrap">
					<div class="box-body">
						<div class="box-keyword">
						<form method="post" action="#">
							<div class="form-group input-double">
								<label for="exampleInputEmail1" class="col-sm-2 control-label">
									출결 기간 </label>
								<div class="col-sm-4">
									<div class="input-group date">
										<input type="text" class="form-control" name="startWork"
											placeholder="입사일을 입력하세요."> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-calendar"></i></span>

									</div>
									<!-- <div class="input-group input-append date" id="dateRangePicker"></div> -->
									<!-- <div class='input-group date' id='datetimepicker6'>
									<span class="input-group-addon" id="sdate-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span> <input type='text' aria-describedby="sdate-addon"
										class="form-control" name="startWork" placeholder="입사일을 입력하세요." />
								</div> -->
								</div>
								<div class="col-sm-2 wave-mark">~</div>

								<div class="col-sm-4">
									<div class="input-group date">
										<input type="text" class="form-control" name="endWork"
											placeholder="퇴사일을 입력하세요."> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-calendar"></i></span>

									</div>
								</div>
							</div>
						</form>
						<br><br><br>
						
						<form role="form" method="post"><p/>
								<div class="row">
									<table class="table table-bordered" id="user-table">
										<thead>
											<tr>
												<th style="text-align: center;">
												<!-- <input type="checkbox" name="scoreIdAll" /> -->
												근태번호</th>
												<th style="text-align: center;">일자</th>
												<th style="text-align: center;">사원명</th>
												<th style="text-align: center;">출근일시</th>
												<th style="text-align: center;">퇴근일시</th>
												<th style="text-align: center;">비고</th>
											</tr>
										</thead>
										<c:choose>
											<c:when test="${not empty commuteList}">
												<c:forEach items="${commuteList}" var="CommuteVO">
													<tbody>
														<tr>
															<td style="text-align: center;">
															<%-- <input type="checkbox" name="commuteNum" value="${CommuteVO.commuteNum }" > --%>
															${CommuteVO.commuteNum }</td>
															<td style="text-align: center;">${CommuteVO.workDate}</td>
															<td style="text-align: center;">${CommuteVO.empName}</td>
															<td style="text-align: center;">${CommuteVO.goToWorkTime}</td>
															<td style="text-align: center;">${CommuteVO.offWorkTime}</td>
															<td style="text-align: center;">${CommuteVO.commuteRemarks}</td>
															
														</tr>
													</tbody>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="7" class="txt_center" align="center"><b>수정할
															데이터가 없습니다.</b></td>
												</tr>
											</c:otherwise>
										</c:choose>
									</table>
									<div class="box-footer btn-group-center">
										<button type="button" class="btn btn-primary">수정</button>
										<a href="/mis?command=mis_list_form" type="button"
											class="btn btn-default">취소</a>
										<button type="button" class="btn btn-danger">삭제</button>	
									</div>
								</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<script>
	//전체 체크박스 클릭시 전체 checked
	$("input[name=scoreIdAll]").click(function() {
		var chk = $(this).is(":checked");

		if (chk) {
			$("input[name='scoreId']").prop("checked", true);
		} else {
			$("input[name='scoreId']").prop("checked", false);
		}

		//jquery 달력
		$(".scoreDate").datepicker();
	});

	//이름 검색기능
	$(document)
			.ready(
					function() {
						$("#keyword")
								.keyup(
										function() {
											var k = $(this).val();
											$("#user-table > tbody > tr")
													.hide();
											var temp = $("#user-table > tbody > tr > td:nth-child(5n+3):contains('"
													+ k + "')");

											$(temp).parent().show();
										})
					})

	//엔터막기	
	function enter(e) {
		if (window.event) {
			key = window.event.keyCode;
		} else if (e) {
			key = e.which;
		}
		if (key == 13) {
			return false
		}
	}

	//알람창
	$(document).ready(function() {

		var formMis = $("form[role='form']");

		console.log(formMis);

		$(".btn-primary").on("click", function() {
			formMis.attr("action", "/mis?command=mis_modify");
			formMis.attr("method", "post");

			var isChk = false; //scoreid 배열 check하는 변수 isChk 

			var scoreIdArrEss = document.getElementsByName("scoreId");

			//학번 배열이 체크되었을 때 isChk true
			for (var i = 0; i < scoreIdArrEss.length; i++) {
				if (scoreIdArrEss[i].checked == true) {
					isChk = true;
					break;
				}
			}

			if (!isChk) {
				alert("수정할 대상을 체크하시오");
				return;
			}

			else {
				if (confirm("정말 수정하시겠습니까?") == true) {
					formMis.submit();
				} else {
					return;
				}
			}

		});

	});
</script>

<%@include file="../include/footer.jsp"%>
