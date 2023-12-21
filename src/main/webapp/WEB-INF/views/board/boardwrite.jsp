<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources/static"/>
<!DOCTYPE html>
<html>
<head>
    <title></title>

    <script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
    <link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
    <link rel="stylesheet" href="https://nhn.github.io/tui.editor/latest/dist/cdn/theme/toastui-editor-dark.css" />
    <link href="${path}/board.css" rel="styleSheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    <div class="write-form-wrap">
        <div class="board-write-header">글쓰기</div>

            <select name="selectBoardType" class="select-boardType">
                <option value="k" selected>국내음악</option>
                <option value="p">해외음악</option>
                <option value="j">일본음악</option>
                <option value="f">자유게시판</option>
            </select>

        <div><input type="text" placeholder="제목" class="board-write-title"></div>

            <div id="toastUI"></div>

        <div>
            <button class="board-submit-btn">등록</button>
        </div>


    </div>


    <script>
        const { Editor } = toastui;
        let imgList = [];
        const editor = new Editor({
            el: document.querySelector('#toastUI'), // 에디터를 적용할 요소 (컨테이너)
            height: 'auto',                        // 에디터 영역의 높이 값 (OOOpx || auto)
            initialEditType: 'wysiwyg',            // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
            previewStyle: 'vertical',           // 마크다운 프리뷰 스타일 (tab || vertical)
            theme: 'dark',
            hooks: {
                    async addImageBlobHook(blob, callback) { // 이미지 업로드 로직 커스텀
                        try {
                            const formData = new FormData();
                            formData.append('image', blob);

                            const response = await fetch('/api/attach/imgUpload', {
                                method : 'POST',
                                body : formData,
                            });
                            const filename = await response.text();
                            callback(filename, 'image alt attribute');
                            imgList.push(filename);
                        } catch (error) {
                            console.error('업로드 실패 : ', error);
                        }
                    }
                }
        });



        $(function(){
            $('.select-boardType').val('${boardCode}');

            $(".board-submit-btn").click(function(){
                const title = $(".board-write-title").val();
                if (title.length < 1) {
                    alert('제목을 입력해 주세요.');
                }
                if (editor.getMarkdown().length < 1) {
                    alert('게시글 내용을 입력해 주세요.');
                    throw new Error('editor content is required!');
                }else{
                    insertBoard(title);
                }
            })

        })
            const insertBoard = async (title) => {
                    const board = {
                        boardCode : '${boardCode}',
                        boardWriter : ${loginUser.userNo},
                        boardTitle : title,
                        boardContent : editor.getHTML(),
                        imgList : imgList
                    }
                        try {
                            const response = await fetch("/api/board/write", {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(board),
                            });

                            const result = await response.text();
                            if(result.length > 0){
                                alert("게시물이 작성되었습니다.");
                                location.href = '/';
                            }

                        } catch (error) {
                            console.error('저장 실패 : ', error)
                        }
            }

    </script>

    <jsp:include page="../common/footer.jsp"/>
</body>
</html>