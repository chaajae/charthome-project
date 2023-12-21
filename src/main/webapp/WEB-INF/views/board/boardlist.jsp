<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>

    <title>boardlist</title>
    <link href="${path}/board.css" rel="styleSheet" type="text/css">
</head>
<body>

<jsp:include page="../common/header.jsp"/>

    <div class="boardlist-wrap">
        <div class="boardType-title">
            <c:forEach items="${boardTypeList }" var="bt">
                <c:if test="${bt.boardCode == boardCode }">
                    ${bt.boardName }
                    <c:set var="boardName" value="${bt.boardName }"/>
                </c:if>
            </c:forEach>
        </div>

        <div class="boardlist-header-wrap">
            <div class="boardlist-searchbar">
                <form>
                    <select name="searchOption" class="board-search-selectbar">
                            <option value="title" selected>제목</option>
                            <option value="titleandcontent">제목 + 내용</option>
                            <option value="writer">작성자</option>
                    </select>
                    <input type="text" name="keyword"  class="board-searchbar">
                    <button type="button" class="board-search-btn">검색</button>
                </form>
            </div>

            <c:if test="${loginUser ne null}">
                <div class="board-write-btn-wrap">
                    <button class="board-write-btn" onclick="location.href='/api/board/write/${boardCode}'">
                        글쓰기
                    </button>
                </div>
            </c:if>
        </div>

        <div class="boardlist-table">
            <table class="board-table">
                <thead>
                    <tr>
                        <td colspan="2" class="table-content">
                          내용
                        </td>
                        <td class="table-likes"><span class="thead-hits">조회</span></td>
                        <td class="table-hits"><span class="thead-likes">추천</span></td>
                    </tr>
                </thead>

                <tbody>

                    <c:choose>
                        <c:when test="${boardPages.content.size() gt 0}">
                            <c:forEach var="board" items="${boardPages.content}">
                                <tr onclick="location.href='/api/board/views/${boardCode}/${board.boardNo}'">
                                    <td class="thumbnail-img">
                                        <img src="https://i.namu.wiki/i/w11dbZZeomJI4bD3_KItw3vq7tgglcM1YQA_xHULxMsixPpY1S7KcB8WrEFhJNuSuejiiQkicGKMH12JvpUqBQ.webp" alt="">
                                    </td>
                                    <td class="table-content">
                                        <div class="board-content">[${boardName}] ${board.boardTitle}
                                            <span class="replycount">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-chat-square-dots" viewBox="0 0 16 16">
                                                    <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                    <path d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                                                </svg>
                                                100
                                            </span>
                                        </div>
                                        <span class="boardwriter">${board.boardWriter}</span>
                                        <span class="create-date">${board.createDate}</span>

                                    </td>
                                    <td class="table-hits">
                                        <div class="table-likes-and-hits">
                                            <svg xmlns="http://www.w3.org/2000/svg"width="25" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                            </svg>
                                            ${board.boardCount}
                                        </div>
                                    </td>
                                    <td class="table-likes">
                                        <div class="table-likes-and-hits">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="14" fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                                                <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
                                            </svg>
                                            133
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                             <tr style="text-align: center; height: 4.5em;">
                                <td colspan="4">게시물이 없습니다.</td>
                             </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
                <div class="paging-wrap">
                    <div class="paging-area">
                        <c:if test="${!boardPages.isFirst()}">
                            <div class="paging-btn"><a href="/api/board/list/${boardCode}?page=${boardPages.number}" >&lt; &nbsp;</a></div>
                        </c:if>

                        <c:forEach begin="${startPage}" end="${endPage}" var="page">
                            <c:choose>
                                <c:when test="${page == boardPages.number + 1}">
                                    <div class="currentPage">${page}</div>
                                </c:when>
                                <c:otherwise>
                                    <div><a href="/api/board/list/${boardCode}?page=${page}" class="pages">${page}</a></div>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${!boardPages.isLast()}">
                            <div class="paging-btn"><a href="/api/board/list/${boardCode}?page=${boardPages.number + 2}" class="pages">&nbsp; &gt;</a></div>
                        </c:if>
                    </div>
                </div>







        </div>
    </div>

<jsp:include page="../common/footer.jsp"/>



</body>
</html>