<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>

    <title>boardlist</title>
    <link href="${path}/board.css" rel="styleSheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

    <c:choose>
            <c:when test="${loginUser.userProfile eq 'none'}">
                <c:set var="profile" value="${path}/images/profile-img-none.png"/>
            </c:when>
            <c:otherwise>
                <c:set var="profile" value="${loginUser.userProfile}"/>
            </c:otherwise>
    </c:choose>


    <div class="mypage-wrap">
        <div class="mypage-text">마이페이지</div>
        <div class="mypage-profile-img"><img src="${profile}" class="profile-img"></div>
        <div class="profile-img-change-btn">프로필 변경</div>
        <input type="file" class="profile-btn-hidden" accept="images/*">


        <div class="mypage-nick-wrap"><input type="text" class="mypage-nick" name="updateNick"></div>
        <div class="nick-update-btn">정보수정</div>

        <div class="withdrawal-btn">회원탈퇴</div>
    </div>

<jsp:include page="../common/footer.jsp"/>

    <script>
            $(function(){
                $(".profile-btn-hidden").hide();
                $(".mypage-nick").val('${loginUser.userNick}');

                $(".profile-img-change-btn").click(function () {
                    $(".profile-btn-hidden").click();
                });

                 $(".nick-update-btn").click(function () {
                    const updateNick = $(".mypage-nick").val();
                    $.ajax({
                        url : "/updateNick",
                        data: {updateNick : updateNick},
                        method : "PATCH",
                        success : function(result){
                                if(result == "닉네임수정완료"){
                                   location.reload()
                                }
                            }
                    })
                });

                const inputFile = $(".profile-btn-hidden");

                inputFile.change(function(){
                     const newFile = this.files[0];

                    if(this.files[0] != undefined){
    		            const reader = new FileReader();
    		            reader.readAsDataURL(this.files[0]);

                        const newImg = new FormData();
                        newImg.append("profileImg",newFile);

                        reader.onload = function(e){
                            $.ajax({
                                url : "/profileUpload",
                                data: newImg,
                                method : "PATCH",
                                processData: false,
                                contentType: false,
                                success : function(result){
                                        $(".profile-img").attr("src", e.target.result);
                                    }
                            })
                        }
                    }
                })
            })



        </script>
</body>
</html>