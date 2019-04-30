/**
 * 
 */

function check() {
		if (document.frm.empName.value == "") {
			alert("사원이름을 입력해주세요");
			document.frm.empName.focus();
			return false;
		}else if (document.frm.empPw.value == "") {
			alert("비밀번호를 입력해주세요");
			document.frm.rearAddr.focus();
			return false;
		}else if ((document.frm.empPw.value) != (document.frm.empPw2.value) ) {
			alert("비밀번호가 맞는지 확인해주세요");
			document.frm.rearAddr.focus();
			return false;
		}else if (document.frm.email.value == "") {
			alert("이메일을 입력해주세요");
			document.frm.email.focus();
			return false;
		}else if (document.frm.brithday.value == "") {
			alert("생년월일를 입력해주세요");
			document.frm.brithday.focus();
			return false;
		}else if (document.frm.hp.value == "") {
			alert("휴대폰번호를 입력해주세요");
			document.frm.hp.focus();
			return false;
		}else if (document.frm.startWork.value == "") {
			alert("입사일을 선택해주세요");
			return false;
		}else if (document.frm.frontAddr.value == "") {
			alert("주소를 입력해주세요");
			return false;
		}else if (document.frm.rearAddr.value == "") {
			alert("상세주소를 입력해주세요");
			document.frm.rearAddr.focus();
			return false;
		}
		
		return true;
	}