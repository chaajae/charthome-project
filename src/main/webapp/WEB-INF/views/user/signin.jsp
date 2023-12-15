<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>

    <title>Sign in</title>
    <link href="${path}/sign.css" rel="styleSheet" type="text/css">
</head>
<body>

   <jsp:include page="../common/header.jsp"/>

    <div class="signup-form-wrap">
        <div class="signin-header">로그인</div>

            <div class="naver-login-wrap">
              <!--  <img src="${path}/images/btnG_완성형.png" class="naver-login-logo"> -->
               <a href="/api/oauth/naver"> <div class="naver-signup"><b>N</b> &nbsp; 네이버로 로그인</div></a>
            </div>

          <!--  <form>
                <div class="signup-label">아이디</div>
                <input type="text" placeholder="아이디를 입력해주세요.">
                <label class="input-label id-label">사용가능한 아이디입니다.</label>

                <div class="signup-label">비밀번호</div>
                <input type="password" placeholder="비밀번호를 입력해주세요.">
                <label class="input-label pwd-label">최소 8자 이상 입력해주세요.</label>

                <div>
                    <button type="submit" class="signin-btn">로그인</button>

                </div>
            </form> -->
    </div>

    <jsp:include page="../common/footer.jsp"/>
</body>
</html>