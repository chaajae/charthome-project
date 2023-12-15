<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>
    <title>Document</title>
     <link href="${path}/header.css" rel="stylesheet" type="text/css">

</head>
<body>

    <div class="header-wrap">
        <div class="header-nav">
            <div class="header-logo">
                <h2><a href="/">Chart HOME</a></h2>
            </div>

            <div class="header-menus">
                <ul>
                    <li><a href="/api/chart/chartTop100">음원 TOP 100</a></li>
                    <li><a href="/api/board/list/k">국내음악</a></li>
                    <li><a href="/api/board/list/p">해외음악</a></li>
                    <li><a href="/api/board/list/j">일본음악</a></li>
                    <li><a href="/api/board/list/f">자유게시판</a></li>
                </ul>
            </div>

            <div class="header-join">
                <c:choose>
                    <c:when test="${loginUser eq null}">
                        <div><a href="/signin">로그인</a></div>
                        <div><a href="/signup">회원가입</a></div>
                    </c:when>
                    <c:otherwise>
                        <div><a href="/mypage">마이페이지</a></div>
                        <div><a href="/logout" class="logoutBtn">로그아웃</a></div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

<script>
    var currentURL = window.location.href;
    console.log("현재 URL: " + currentURL);
</script>

</body>
</html>