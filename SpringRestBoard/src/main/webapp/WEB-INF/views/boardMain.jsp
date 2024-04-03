<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"
></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 글쓰기 버튼 클릭시 글 정보를 저장
		$("#btnAdd").click(function() {
			alert("글쓰기 버튼 클릭 - 시작");
			
			// 전달할 정보(글쓰기 내용) JSON형태로 준비
// 			var board = {
// 				"title" : "REST 글쓰기",
// 				"content" : "REST 글 내용",
// 				"writer" : "REST 글 작성자"
// 			};
			
			var board = {
				"title" : $("#title").val(),
				"content" : $("#content").val(),
				"writer" : $("#writer").val()
			};
			
			// 글 정보 저장 - REST URI 호출 (비동기 방식 ajax)
			$.ajax({
				url : "/boards",
				type : "POST",
				data : JSON.stringify(board),
				contentType : "application/json",
				success : function() {
					alert(" /boards 다녀옴! ");
				},
				error : function() {
					alert(" /boards 다녀옴 실패! ");
				}
			});
			
			
			alert("글쓰기 버튼 클릭 - 끝");
		});
	});
</script>
</head>
<body>
	<h1>boardMain.jsp</h1>
	<!-- 사용자, 제목, 내용 입력받아서 글 작성  -->
	<h2>상태 : </h2>
	<fieldset style="width: 450px;">
		<legend> 글쓰기 (POST) </legend>
		작성자 : <input type="text" name="writer" id="writer"><br>
		제목 : <input type="text" name="title" id="title"><br> 
		내용 : <br>
		<textarea rows="5" cols="50" name="content" id="content"></textarea>
		<br> <input type="button" value="글쓰기(POST)" id="btnAdd">
	</fieldset>








</body>
</html>