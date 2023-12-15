<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>
    <title>Sign up</title>
    <link href="${path}/sign.css" rel="styleSheet" type="text/css">

</head>
<body>

<jsp:include page="../common/header.jsp"/>



   <div class="signup-form-wrap">
        <div class="signup-header">Chart Home 회원가입</div>

            <div class="naver-login-wrap">
              <!--  <img src="${path}/images/btnG_완성형.png" class="naver-login-logo"> -->
               <a href="/api/oauth/naver"> <div class="naver-signup"><b>N</b> &nbsp; 네이버로 시작하기</div></a>
            </div>



        <!--
        <div class="signup-comment">기본정보를 모두 입력해주세요.</div>
        <form>
            <div class="signup-label">아이디</div>
            <input type="text" placeholder="4 ~ 20자 이내로 입력해주세요.">
            <label class="input-label id-label">사용가능한 아이디입니다.</label>

            <div class="signup-label">비밀번호</div>
            <input type="password" placeholder="최소 8자 이상">
            <label class="input-label pwd-label">최소 8자 이상 입력해주세요.</label>

            <div class="signup-label">이메일</div>
            <input type="email" placeholder="charthome@charthome.com">
            <label class="input-label email-label">올바른 이메일 양식으로 입력해주세요.</label>

            <div class="signup-label">닉네임</div>
            <input type="text" placeholder="최대 10자">
            <label class="input-label nick-label">사용가능한 닉네임입니다.</label>

            <div>

                <button type="submit" class="signup-btn" disabled>회원가입</button>
                <!-- 조건 다 통과하면 클래스에 sbtn 붙여줘야함 -->
            </div>
        </form>

    </div>


    <!-- 푸터 -->
    <jsp:include page="../common/footer.jsp"/>
    <!-- 푸터 -->
</body>
</html>