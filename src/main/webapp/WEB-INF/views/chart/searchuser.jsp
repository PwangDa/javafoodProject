<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정을 찾고 싶으신가요?</title>
<body>
	<div id="wrap">
		<div id="title">
			<span>아이디 / 비밀번호 찾기</span>
		</div>
		<div id="userfind">
			<div id="messege">
				<p>아이디, 비밀번호를 잊으셨습니까?<br>
				회원정보를 입력하시고 찾기 버튼을 클릭해주세요.</p>
			</div>
			<div id="find_click">
				<div id="findID_click"><img alt="아이디" src="C:\Users\admin\Downloads\free-icon-user-2521782.png">아이디 찾기</div>
				<div id="findPW_click"><img alt="비밀번호" src="C:\Users\admin\Downloads\free-icon-lock-2089784.png">비밀번호 찾기</div>
			</div>
			<div id="find_info">
				<!-- id 찾기 div -->
					<div id="findID">
						<input type="text" class="find_id" id="findid_nic"  name="findid_nic" placeholder="닉네임"><br>
						<span id="span_findid_nic"></span>
						<input type="tel" class="find_tel" name="phone1" id="findid_phone1" placeholder="010">-
						<input type="tel" class="find_tel" name="phone2" id="findid_phone2">-
						<input type="tel" class="find_tel" name="phone3" id="findid_phone3"><br>
						<span id="span_findid_phone"></span>
						<input type="hidden" id="findid_totalphone" name="findid_totalphone">
						<input type="submit" id="findID_btn" value="아이디 찾기" formaction="/userfind_id">
					<!-- id 찾기 출력결과 넣을 곳 -->
						<div class="f_signupBtnDiv">
							<button class="find_signupBtn" onclick="location.href='/login'">회원가입</button>
						</div>
					</div>
					<!-- pw 찾기 div  -->
						<div id="findPW">
							<input type="text" class="find_input" id="findpw_id" placeholder="아이디(메일주소)"><br>
							<span id="s_findpw_id"></span>
							<input type="text" class="find_input" id="findpw_name" name="findpw_name" placeholder="닉네임"><br>
							<span id="s_findpw_nic"></span>
							<input type="tel" class="find_tel" name="phone1" id="findpw_phone1" placeholder="010">-
							<input type="tel" class="find_tel" name="phone2" id="findpw_phone2">-
							<input type="tel" class="find_tel" name="phone3" id="findpw_phone3"><br>
							<span id="s_findpw_phone"></span>
							<input type="hidden" id="findpw_totalphone" name="findpw_totalphone">
							<input type="submit" id="findPWBtn" value="비밀번호 찾기" formaction="/userfind_pw">
						<!-- 출력 결과 넣을 곳 -->
							<div class="f_signupBtnDiv">
								<button class="find_signupBtn" onclick="location.href='/login'">회원가입</button>
							</div>
						</div>
					</div><!-- find_info -->
				</div><!-- userfind  -->
			</div>
			
			<!-- 아이디 찾기 결과 출력 -->
			<c:choose>
				<c:when test="${check == 1}">
					<p>닉네임 혹은 전화번호를 다시 확인해주세요.</p>
				</c:when>
				<c:when test="${check == 0 }">
					<p>찾으시는 아이디는 ${findid.id }입니다.</p>
				</c:when>
			</c:choose>
			
			<!-- 비밀번호 찾기 결과 출력 -->
			<c:choose>
				<c:when test="${check2 == 1 }">
					<p>일치하는 회원이 없습니다.</p>
				</c:when>
				<c:when test="${check2 == 0 }">
					<p>찾으시는 비밀번호는
					<c:if test="${fn:length(findpw.pw) >= 3 }">
						<!-- 비밀번호의 앞 2자리까지 보여 주고 -->
						${fn:substring(findpw.pw,0,2 }
						<!-- 3자리부터 비밀번호의 길이만큼 *를 찍어줌 -->
						<c:forEach begin="3" end="${fn:length(findpw.pw) }" step="1">*</c:forEach>
					</c:if>
						입니다.</p>
				</c:when>
			</c:choose>
	
</body>
</html>