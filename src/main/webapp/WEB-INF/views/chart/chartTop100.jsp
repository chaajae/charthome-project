<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>
    <title>Chart Top 100</title>

        <link href="${path}/home.css" rel="stylesheet" type="text/css">

</head>
<body>

<jsp:include page="../common/header.jsp"/>

<div class="content-body">
    <h3>음원차트 TOP 100</h3>
    <label class="datetime"></label>
    <div class="home-chart-wrap">
        <div class="home-chart melon">
            <label>
                <img class="melon-logo" src="https://is1-ssl.mzstatic.com/image/thumb/Purple116/v4/e2/b9/bd/e2b9bd15-a8b8-001f-04f2-bc3b1ddbb8f3/AppIcon-85-220-4-2x.png/1200x630bb.png">
                <a class="origin-chart-link" href="https://www.melon.com/chart/index.htm" target="_blank">
                    Melon차트
                </a>
            </label>
            <div class="home-chart-item">
                    <table >
                        <thead>
                            <tr>
                                <td class="rank-header">순위</td>
                                <td colspan="2">곡정보</td>
                            </tr>
                        </thead>
                        <tbody >
                                <c:forEach var="item" items="${melonTop100}">
                                    <tr>
                                        <td class="home-chart-rank">${item.rank}</td>
                                        <td class="home-chart-img">
                                            <img src="${item.albumArt}">
                                        </td>
                                        <td class="home-chart-title" >
                                             <p >${item.title}</p>
                                            <span class="home-chart-artist">${item.artistName}</span>
                                        </td>
                                    </tr>
                                </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>

        <div class="home-chart genie">
            <label>
                <img class="genie-logo" src="https://lh3.googleusercontent.com/fJqk-Vht9GUf1r2zuI8erHUp5WZAKbpGL44kQ_TJejle-keLFZWWAF4tocqO_11YW437">
                <a class="origin-chart-link" href="https://www.genie.co.kr/chart/top200" target="_blank">Genie차트</a>
            </label>
            <div class="home-chart-item">
                    <table >
                        <thead>
                        <tr>
                            <td class="rank-header">순위</td>
                            <td colspan="2">곡정보</td>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${genieTop100}">
                                <tr>
                                    <td class="home-chart-rank">${item.rank}</td>
                                    <td class="home-chart-img">
                                        <img src="${item.albumArt}">
                                    </td>
                                    <td class="home-chart-title" >
                                      <p >${item.title}</p>
                                     <span class="home-chart-artist">${item.artistName}</span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>

        <div class="home-chart vibe">
            <label >
                <img class="genie-logo" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpSSxEjscLrhdVb_AFR6eaz7wzqxu1nevobmEoS0LkpP-Jf5jHwGVbNEVMZ0bJ4tYaIvY&usqp=CAU">
                <a class="origin-chart-link" href="https://vibe.naver.com/chart/total" target="_blank">Vibe차트</a>
            </label>
            <div class="home-chart-item">
                    <table >
                        <thead>
                        <tr>
                            <td class="rank-header">순위</td>
                            <td colspan="2">곡정보</td>
                        </tr>
                        </thead>
                        <tbody >
                            <c:forEach var="item" items="${vibeTop100}">
                                <tr>
                                    <td class="home-chart-rank">${item.rank}</td>
                                    <td class="home-chart-img">
                                        <img src="${item.albumArt}">
                                    </td>
                                    <td class="home-chart-title" >
                                      <p >${item.title}</p>
                                      <span class="home-chart-artist">${item.artistName}</span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>

    </div>

</div>




<!-- 푸터 -->
<jsp:include page="../common/footer.jsp"/>
<!-- 푸터 -->

<script>
function displayDateTime() {
    let currentDate = new Date();
    let formattedDateTime = currentDate.toLocaleString('ko-KR', {
        hour12: false,
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'

    }).replace(/(\d+)\/(\d+)\/(\d), (\d+):(\d+)/, '0000/00/00 $4 $5');

     let elements = document.querySelectorAll(".datetime");
        for (var i = 0; i < elements.length; i++) {
            elements[i].textContent = formattedDateTime;
        }
}

window.onload = displayDateTime;
</script>

</body>
</html>