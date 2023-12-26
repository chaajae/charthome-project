<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>

    <title>boardDetailView</title>
    <link href="${path}/board.css" rel="styleSheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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

        <div class="boardDetail-wrap">

            <div class="board-title">
                [${boardName}] ${boardItem.boardTitle}
            </div>

            <div class="board-info">
                <img src="https://picpac.kr/common/img/default_profile.png" class="boardDetail-profile-img" alt="">
                <span class="boardDetail-boardwriter">${boardItem.boardWriter}</span>
                <span class="boardDetail-boarddate">${boardItem.createDate}</span>
                <span class="boardDetail-hits">
                    <svg xmlns="http://www.w3.org/2000/svg"width="25" height="16" fill="white" class="bi bi-eye" viewBox="0 0 16 16">
                        <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                        <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                    </svg>
                    ${boardItem.boardCount}
                </span>
                <span class="boardDetail-likes">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="14" fill="white" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                        <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
                    </svg>
                    1745
                </span>
            </div>

            <div class="boardDetail">${boardItem.boardContent}</div>
            <div class="boardlike-area">
                <button class="boardlike-btn">
                      <svg xmlns="http://www.w3.org/2000/svg" width="25" height="18" fill="white" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                        <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
                     </svg>
                  <!-- <svg xmlns="http://www.w3.org/2000/svg" width="25" height="18" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
                        <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
                     </svg> -->
                    추천
                </button>
            </div>

            <div class="board-replyarea">
                <div class="reply-count-wrap">댓글 <span class="reply-count">${replyList.size()}</span> 개</div>
                    <c:forEach var="reply" items="${replyList}">
                        <div class="board-replyContent">
                            <div class="reply-info-wrap">
                                <div class="reply-info">
                                    <img src="https://picpac.kr/common/img/default_profile.png" class="boardDetail-profile-img" alt="">
                                    <span>ckwogus</span>
                                    <span class="reply-date">${reply.createDate}</span>
                                </div>
                                <c:if test="${loginUser.userNo eq reply.userNo}">
                                    <div class="reply-popup-btn">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
                                                <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
                                            </svg>

                                            <div class="reply-popup">
                                                <li class="reply-update-btn">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                                      </svg>
                                                    &nbsp; 수정
                                                </li>
                                                <li>
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                                        <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                                      </svg>
                                                    &nbsp; 삭제
                                                </li>
                                            </div>
                                    </div>
                                </c:if>
                            </div>

                            <div class="reply-content">${reply.replyContent}</div>
                            <div class="rereply-btn-wrap">
                                <button class="rereply-btn">
                                    댓글쓰기
                                </button>
                            </div>

                            <div class="rereply-input-wrap">
                                <textarea placeholder="댓글을 입력해주세요."></textarea>
                                <button class="reply-btn">등록</button>
                            </div>
                        </div>
                    </c:forEach>



                <div class="reply-input-wrap">
                    <textarea placeholder="댓글을 입력해주세요." class="reply-text" ></textarea>
                    <button class="reply-btn">등록</button>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="../common/footer.jsp"/>

    <script>
        const thumb = (event) => {
            const clickedButton = event.currentTarget;
            const svgInsideButton = clickedButton.querySelector('svg');
        };

        $(function(){

            $(".rereply-input-wrap").hide();
            $(".reply-popup").hide();

            $(".rereply-btn").click(function(){
                $(this).closest('.board-replyContent').find('.rereply-input-wrap textarea').val("");
                $(this).closest('.board-replyContent').find('.rereply-input-wrap').toggle();
            });

            $(".reply-popup-btn").click(function(){
                $(this).closest('.board-replyContent').find('.reply-popup').toggle();
            });

            $(document).mouseup(function (e) {
                var popup = $(".reply-popup");
                if (popup.has(e.target).length === 0) {
                    popup.hide();
                }
            });

            $(".reply-update-btn").click(function(){
                let content = $(this).closest('.board-replyContent').find('.reply-content').text();
                $(this).closest('.board-replyContent').find('.rereply-input-wrap textarea').val(content);
                $(this).closest('.board-replyContent').find('.rereply-input-wrap').toggle();
            });


            let filled = false;
            $(".boardlike-btn").click(function(){
                <c:if test="${loginUser eq null}">
                    alert("로그인 후 가능합니다.");
                </c:if>
                <c:if test="${loginUser ne null}">
                    const boardLike = {
                        userNo : ${loginUser.userNo},
                        boardNo : '${boardItem.boardNo}'
                    };
                    $.ajax({
                        url : "/api/board/like",
                        data: JSON.stringify(boardLike),
                        method : "POST",
                        processData: false,
                        contentType: 'application/json',
                        success : function(result){
                                const thumbUp = '<svg xmlns="http://www.w3.org/2000/svg" width="25" height="18" fill="white" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16"><path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/></svg> 추천';
                                const filledThumbUp = '<svg xmlns="http://www.w3.org/2000/svg" width="25" height="18" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16"><path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/></svg> 추천';

                                // 클릭할 때마다 번갈아가면서 출력되도록 설정
                                if (filled) {
                                    $(".boardlike-btn").html(thumbUp);
                                } else {
                                    $(".boardlike-btn").html(filledThumbUp);
                                }
                                filled = !filled;
                        }
                    });
                </c:if>
            });

            if(${loginUser eq null}){
                $(".reply-text").prop("disabled", true);
                $("button.reply-btn").prop("disabled", true);
                $(".rereply-btn").hide();
                $(".reply-text").attr("placeholder", "로그인 후 댓글작성이 가능합니다.");
            }

            $("button.reply-btn").click(function (){

                <c:if test="${loginUser ne null}">
                let content = $(".reply-text").val();
                if(content.length > 0 ){
                    const reply = {
                        userNo : ${loginUser.userNo},
                        boardNo : '${boardItem.boardNo}',
                        replyContent : content
                    };
                    $.ajax({
                        url : "/api/reply/save",
                        data: JSON.stringify(reply),
                        method : "POST",
                        processData: false,
                        contentType: 'application/json',
                        success : function(result){
                            location.reload();
                        }
                    });
                }
                </c:if>
            })


        });
    </script>
</body>
</html>