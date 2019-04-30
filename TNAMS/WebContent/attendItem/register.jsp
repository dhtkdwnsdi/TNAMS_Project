<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>


<!-- DropDown으로 휴가여부, 유/무급 선택항목 만들기 -->


<!-- Main content -->
<section class="content">
   <div class="row">
      <!-- left column -->
      <div class="col-md-12">
         <!-- general form elements -->
         <div class="box box-primary">
            <div class="box-header">
               <h3 class="box-title">&nbsp;&nbsp;근태항목 등록 </h3>
            </div>
            <!-- /.box-header -->

            <form role="form" method="post" class="form-horizontal"
               action="/AttendItemServlet?command=attendItemReg">
               <input type="hidden" name="validation">
               <div class="box-body box-form-custom">
                  
<!-- 근태명, 휴가여부, 유/무급 -->


                  
                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">근태명<span
                        class="must-mark">*</span></label>
                     <div class="col-sm-10">
                        <input type="text" name='attendName' class="form-control"
                           placeholder=""> <span
                           id="validateAttendName"></span>
                     </div>
                  </div>
                  
                  
                  
                  
               
                  <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">휴가 여부<span
                        class="must-mark"></span></label>
                     <div class="col-sm-10">
                     <select id="vacation" name="vacation" class="form-control">
                                 <option value="">선택</option>
                                 <option value="유">유</option>
                                 <option value="무">무</option>
                                 
                           </select>
                        <%-- <select name="compNum" class="form-control">
                           <c:forEach var="comps" items="${compList}">
                              <option value="${comps.compNum}">${comps.compName}</option>
                           </c:forEach>
                        </select> --%> 
                        <span id="validateVaction"></span>
                     </div>
                  </div>
            
            
               <div class="form-group input-short">
                     <label for="exampleInputEmail1" class="col-sm-2 control-label">유/무급<span
                        class="must-mark"></span></label>
                     <div class="col-sm-10">
                     <select id="paid" name="paid" class="form-control">
                                 <option value="">선택</option>
                                 <option value="유">유</option>
                                 <option value="무">무</option>
                                 
                           </select>
                        <%-- <select name="compNum" class="form-control">
                           <c:forEach var="comps" items="${compList}">
                              <option value="${comps.compNum}">${comps.compName}</option>
                           </c:forEach>
                        </select> --%> 
                        <span id="validatePaid"></span>
                     </div>
                  </div>
            
               
               
                  </div>
                  
               </div>
               <!-- /.box-body -->

               <div class="box-footer btn-group-center">
                  <button type="button" class="btn btn-cancel">취소</button>
                  <button type="submit" class="btn btn-primary" id="submitbutton"
                     onclick="return validateEmptyVal()">등록</button>
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
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>

<script>
   $(document)
         .ready(
               function() {

                  // 취소버튼 누르면 Criteria 유지한 채로 목록으로 돌아가게 하는 함수
                  $(".btn-cancel")
                        .on(
                              "click",
                              function() {
                                 self.location = "list?page=${cri.page}&perPageNum=${cri.perPageNum}"
                                       + "&searchType=${cri.searchType}&keyword=${cri.keyword}";
                              });
               });

   /**
    * 아이디, 이메일, 전화번호 중복검사와
    * 빈 값이 있는지 검사를 해서 유효성에 따라
    * submit 버튼을 활성화, 비활성화시키는 함수
    */

   window
         .setInterval(
               function() {

                  // 인풋에 있는 모든 값들을 합쳐서
                  // 어드민 객체를 생성함
                  var adminId = document.getElementsByName("adminId")[0].value;
                  var adminPw = document.getElementsByName("adminPw")[0].value;
                  var adminName = document.getElementsByName("adminName")[0].value;
                  var adminPhone = document
                        .getElementsByName("adminPhone")[0].value;
                  var adminEmail = document
                        .getElementsByName("adminEmail")[0].value;
                  var compNum = document.getElementsByName("compNum")[0].value;

                  // 완성된 JSON 어드민 객체
                  var admin = {
                     adminId : adminId,
                     adminPw : adminPw,
                     adminName : adminName,
                     adminPhone : adminPhone,
                     adminEmail : adminEmail,
                     compNum : compNum
                  };

                  // 백엔드에서 유효성 검사를 거친 뒤
                  // 메시지를 받음
                  $
                        .ajax({
                           url : 'validate',
                           type : 'POST',
                           dataType : 'JSON',
                           contentType : 'application/json',
                           data : JSON.stringify(admin),
                           success : function(msg) {
                              // 유효성 검사값을 저장하는 변수       
                              var invalid = false;

                              // 백엔드와의 통신이 성공하면 유효성 검사 결과를 받고
                              // 아이디, 이메일, 전화번호 각각의 유효성 검사 결과 메시지를
                              // 인풋 밑에 표시해줌
                              if (msg.idMsg == "idFailed") {
                                 document
                                       .getElementById("validateIdMessage").textContent = "ID가 중복되었습니다";

                                 // 중복된 값이 있으면 invalid를 true로 바꿔줌
                                 invalid = true;
                              }
                              if (msg.idMsg == "idOk") {
                                 document
                                       .getElementById("validateIdMessage").textContent = "";
                              }
                              if (msg.emailMsg == "emailFailed") {
                                 document
                                       .getElementById("validateEmailMessage").textContent = "이메일이 중복되었습니다";
                                 invalid = true;
                              }
                              if (msg.emailMsg == "emailOk") {
                                 document
                                       .getElementById("validateEmailMessage").textContent = "";
                              }
                              if (msg.phoneMsg == "phoneFailed") {
                                 document
                                       .getElementById("validatePhoneMessage").textContent = "전화번호가 중복되었습니다";
                                 invalid = true;
                              }
                              if (msg.phoneMsg == "phoneOk") {
                                 document
                                       .getElementById("validatePhoneMessage").textContent = "";
                              }

                              document.getElementById("submitbutton").disabled = invalid;
                           }
                        });

               }, 500);

   // submit 버튼을 누를 때 빈 값을 찾아서
   // 사용자에게 입력을 유도하는 함수
   function validateEmptyVal() {
      if (document.getElementsByName("adminId")[0].value == "") {
         alert("아이디를 입력해주세요");
         document.getElementsByName("adminId")[0].focus();
         return false;
      }
      if (document.getElementsByName("adminPw")[0].value == "") {
         alert("비밀번호를 입력해주세요");
         document.getElementsByName("adminPw")[0].focus();
         return false;
      }
      if (document.getElementsByName("adminPwConfirm")[0].value == "") {
         alert("비밀번호를 한번 더 입력해주세요");
         document.getElementsByName("adminPwConfirm")[0].focus();
         return false;
      }
      if (document.getElementsByName("adminPw")[0].value != document
            .getElementsByName("adminPwConfirm")[0].value) {
         alert("비밀번호가 일치하지 않습니다");
         document.getElementsByName("adminPwConfirm")[0].focus();
         return false;
      }
      if (document.getElementsByName("adminName")[0].value == "") {
         alert("이름을 입력해주세요");
         document.getElementsByName("adminName")[0].focus();
         return false;
      }
      if (document.getElementsByName("adminPhone")[0].value == "") {
         alert("전화번호를 입력해주세요");
         document.getElementsByName("adminPhone")[0].focus();
         return false;
      }
      if (document.getElementsByName("adminEmail")[0].value == "") {
         alert("이메일주소를 입력해주세요");
         document.getElementsByName("adminEmail")[0].focus();
         return false;
      }

      return true;
   }

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

   var cellPhone = document.getElementById('cellPhone');
   cellPhone.onkeyup = function(event) {
      event = event || window.event;
      var _val = this.value.trim();
      this.value = autoHypenPhone(_val);
   }
</script>