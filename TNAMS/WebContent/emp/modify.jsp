<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>


<script type="text/javascript">
	//캘린더
	$(function() {
		$('#datetimepicker6').datetimepicker();
		$('#datetimepicker7').datetimepicker({
			useCurrent : false
		//Important! See issue #1075
		});
		$("#datetimepicker6").on("dp.change", function(e) {
			$('#datetimepicker7').data("DateTimePicker").minDate(e.date);
		});
		$("#datetimepicker7").on("dp.change", function(e) {
			$('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
		});
	});
</script>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">사원 등록</h3>
				</div>
				<!-- /.box-header -->

				<form id='frm' role="form" onsubmit="return validateEmptyVal()"
					method="post" class="form-horizontal" action = "emp/command?empModify">

					<div class="box-body box-form-custom">
						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								사원번호
							</label>
							<div class="col-sm-10">
								<input type="text" name='empNum' class="form-control" value="${empNum}" readonly>
							</div>
						</div>
						
						
						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								사원이름 <span class="must-mark">*</span>
							</label>
							<div class="col-sm-10">
								<input type="text" name='empName' class="form-control"
									value="${empName}">
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								부서명 <span class="must-mark">*</span>
							</label>
							<div class="col-sm-10">
								<select class="form-control" name="deptNum" value="${deptName}">
									<%-- <c:forEach items="${EmpList}" var="EmpVO" varStatus="status">
										<option value="${comp.compNum}">${comp.compName}</option>
									</c:forEach> --%>
									<option value="1">영업부</option>
								</select>
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								직급 <span class="must-mark">*</span>
							</label>
							<div class="col-sm-10">
								<select class="form-control" name="empPosition" value="${empPosition}">
									<option value="사원">사원</option>
									<option value="주임">주임</option>
									<option value="대리">대리</option>
									<option value="계장">계장</option>
									<option value="차장">차장</option>
									<option value="부장">부장</option>
									<option value="전무/상무">전무/상무</option>
									<option value="대표이사">대표이사</option>
								</select>
							</div>
						</div>
						
						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								생년월일 <span class="must-mark">*</span>
							</label>
							<div class="col-sm-10">
								<input id="cellPhone" type="text" name='birthday' maxlength="13"
									class="form-control" value="${birthday}">
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								이메일 <span class="must-mark">*</span>
							</label>
							<div class="col-sm-10">
								<input type="text" name='email' class="form-control"
									value="${email}">
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								휴대폰 번호 <span class="must-mark">*</span>
							</label>
							<div class="col-sm-10">
								<input id="hp" type="text" name='hp' maxlength="13"
									class="form-control" value="${hp}">
							</div>
						</div>

						<div class="form-group input-double">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								입사 날짜<span class="must-mark">*</span>
							</label>
							<div class="col-sm-4">
								<div class='input-group date' id='datetimepicker6'>
									<span class="input-group-addon" id="sdate-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span> <input type='text' aria-describedby="sdate-addon"
										class="form-control" name="workDate" value="${workdate}" />
								</div>
							</div>
							<div class="col-sm-2 wave-mark">~</div>
							<div class="col-sm-4">
								<div class='input-group date' id='datetimepicker7'>
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span> <input type='text' class="form-control" name="endDate"
										placeholder="퇴사일을 입력하세요." />
								</div>
							</div>
						</div>

						<div class="form-group input-long">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">우편번호
								<span class="must-mark">*</span>
							</label>
							<div class="row col-md-10">
								<div class="col-md-3 col-xs-4">
									<input name='zipCode' class="form-control" value="${zipCode}"
										readonly>
								</div>
								<div class="col-md-7 col-xs-6">
									<button type="button" onclick="findRoadAddr()"
										class="btn btn-default">
										<i class="fa fa-search"></i> 주소 찾기
									</button>
								</div>
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">주소<span
								class="must-mark">*</span></label>
							<div class="col-sm-10">
								<input name='frontAddr' class="form-control" value="${frontAddr}"
									readonly>
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">상세주소<span
								class="must-mark">*</span></label>
							<div class="col-sm-10">
								<input name='rearAddr' class="form-control" value="${rearAddr}">
							</div>
						</div>
						
						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								최종학력 </label>
							<div class="col-sm-10">
								<select class="form-control" name="finalEducation" value="${finalEducation}">
									<option value="중학교졸">중학교졸</option>
									<option value="고등학교졸">고등학교졸</option>
									<option value="전문대졸">전문대졸</option>
									<option value="대학교졸">대학교졸</option>
									<option value="대학원졸">대학원졸</option>
								</select>
							</div>
						</div>

						<div class="form-group input-short">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">
								최종학교 </label>
							<div class="col-sm-10">
								<input type="text" name='finalSchool' class="form-control"
									value="${finalSchool}">
							</div>
						</div>

						<!-- /.box-body -->
						
						<div class="box-footer btn-group-center">
						<button type="button" class="btn btn-danger btn-remove"
							onclick="location.href='emp/command?delete&empNum=${empNum}'">삭제</button>
						<button type="submit" class="btn btn-primary">수정</button>
						<input type="reset" class="btn btn-cancel" value="취소"/>
					</div>
						<%-- <div class="box-footer btn-group-center">
							<a
								href="/admin/emp/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}"
								type="button" class="btn btn-cancel">취소</a>
							<button type="submit" class="btn btn-primary">등록</button>
						</div> --%>
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

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js">
	
</script>
<script charset="UTF-8" type="text/javascript"
	src="http://t1.daumcdn.net/postcode/api/core/180619/1529384927473/180619.js">
	
</script>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template" type="text/x-handlebars-template">
<li>
  <span class="mailbox-attachment-icon has-img">
	<img src="/admin/emp/{{imgsrc}}" alt="Attachment">
	<input name="imglink" type="hidden" value="{{fullName}}">
  </span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	<a href="{{fullName}}" 
     class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
	</span>
  </div>
</li>                       
</script>
<script>
	//다음 API 주소찾기 팝업창을 띄우는 메소드
	function findRoadAddr() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 도로명 조합형 주소 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
						if (fullRoadAddr !== '') {
							fullRoadAddr += extraRoadAddr;
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementsByName('zipCode')[0].value = data.zonecode; //5자리 새우편번호 사용
						document.getElementsByName('frontAddr')[0].value = fullRoadAddr;
					}
				}).open();
	}

	//전화번호를 입력하면 자동으로 - 표시를 해줌
	function autoHypenPhone(str) {
		str = str.replace(/[^0-9]/g, '');
		var tmp = '';
		if (str.length < 4) {
			return str;
		} else if (str.length < 7) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3);
			return tmp;
		} else if (str.length < 11) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 3);
			tmp += '-';
			tmp += str.substr(6);
			return tmp;
		} else {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 4);
			tmp += '-';
			tmp += str.substr(7);
			return tmp;
		}
		return str;
	}

	//전화번호 입력칸에 키가 눌렸다 떼지면 전화번호에
	//- 표시를 자동으로 넣어주는 함수
	var cellPhone = document.getElementsByName('hp')[0];
	cellPhone.onkeyup = function(event) {
		event = event || window.event;
		var _val = this.value.trim();
		this.value = autoHypenPhone(_val);
	}

	//유효성 검사
	function validateEmptyVal() {
		if (document.getElementsByName("empName")[0].value == "") {
			alert("사원이름을 입력해주세요");
			document.getElementsByName("empName")[0].focus();
			return false;
		}
		if (document.getElementsByName("deptNum")[0].value == "") {
			alert("부서명을 선택해주세요");
			return false;
		}
		if (document.getElementsByName("empPosition")[0].value == "") {
			alert("직급을 선택해주세요");
			return false;
		}
		if (document.getElementsByName("email")[0].value == "") {
			alert("이메일을 입력해주세요");
			document.getElementsByName("email")[0].focus();
			return false;
		}
		if (document.getElementsByName("brithday")[0].value == "") {
			alert("생년월일를 입력해주세요");
			document.getElementsByName("brithday")[0].focus();
			return false;
		}
		if (document.getElementsByName("hp")[0].value == "") {
			alert("휴대폰번호를 입력해주세요");
			document.getElementsByName("hp")[0].focus();
			return false;
		}
		if (document.getElementsByName("workDate")[0].value == "") {
			alert("입사일을 선택해주세요");
			return false;
		}

		return true;
	}
</script>
<%@include file="../include/footer.jsp"%>
