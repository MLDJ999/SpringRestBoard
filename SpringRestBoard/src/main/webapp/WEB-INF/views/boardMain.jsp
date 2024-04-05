<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		//alert(" 실행! ");
		// 글쓰기 버튼이 클릭시 글정보를 저장
		$("#btnAdd").click(function(){
			alert(" 글쓰기 버튼 클릭! - 시작");
			
			//전달할 정보(글쓰기 내용) JSON형태로 준비
			
// 			var board = {
// 				"title" : "REST 글쓰기",
// 				"content" : "REST 글 내용",
// 				"writer" : "REST 글쓴이"
// 			};
			var board = {
				"title" : $("#title").val(),
				"content" : $("#content").val(),
				"writer" : $("#writer").val()
			};
			
			
			// 글 정보를 저장 - REST URI 호출(비동기방식 ajax)
			$.ajax({
				url : "/boards",
				type : "POST",
				data : JSON.stringify(board),
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					alert(" /boards 다녀옴 성공! ");
					$("#title").val("");
					$("#writer").val("");
					$("#content").val("");
					
					//$("#statusH2").append(" 글작성 성공! ");
					$("#statusH2").append(data);
					
					selectList();
				},
				error : function(){
					alert(" /boards 다녀옴 실패! ");
				}
			});
			
			alert(" 글쓰기 버튼 클릭! - 끝");
		});// btnAdd
		
		
		// 마지막 글 조회 버튼 클릭시 
		$("#btnRead").click(function(){
			// 디비에 저장된 마지막 글정보를 가져와서 화면에 출력
			
			$.ajax({
				url : "/boards/100000",
// 				url : "/boards/1000",
				type : "GET",
				success : function(data){
					alert(" 글 조회 페이지 다녀옴 !");
					alert(data);
					console.log(data);
					$("#divRead").append("<h3>번호 : "+data.bno+"</h3>");
					$("#divRead").append("<h3>제목 : "+data.title+"</h3>");
					$("#divRead").append("<h3>작성자 : "+data.writer+"</h3>");
					$("#divRead").append("<h3>내용 : "+data.content+"</h3>");
					$("#divRead").append("<h3>조회수 : "+data.viewcnt+"</h3>");
					$("#divRead").append("<h3>작성일 : "+data.regdate+"</h3>");
					//$("#divRead").append("<h3>작성일 : "+ new Date(data.regdate)+"</h3>");
					var regdate = new Date(data.regdate);
					$("#divRead").append("<h3>작성일 : "+ regdate.getFullYear()+"."+(regdate.getMonth()+1)+"."+regdate.getDate()+"</h3>");
					$("#divRead").append("<h3>작성시간 : "+ regdate.getHours()+"."+regdate.getMinutes()+"."+regdate.getSeconds()+"</h3>");
					//$("#divRead").append("<h3>작성일 : "+ new TimeStamp(data.regdate)+"</h3>"); (x)
					
					//////////////////////////////////////////////////////////////////
					// 수정정보에 출력
					$('#uWriter').val(data.writer);
					$('#uTitle').val(data.title);
					$('#uContent').val(data.content);
					
				}				
			});
			
			
		}); //btnRead	
		
		function selectList(){
			// 디비에서 게시글(최신글) 10개만 조회
			$.ajax({
				url : "/boards/list",
				success : function(data){
					//alert(" /boards/list 다녀옴 ");
					//alert(data);
					console.log(data);
					
					// 기존의 테이블정보 비우기
					$('table tbody').empty();
					
					$(data).each(function(idx,item) {
						console.log(idx+"//"+item);
						console.log(item);
						
						//테이블에 해당 내용을 추가
						$('table').append("<tr><td>"+item.bno+"</td><td>"+item.title+"</td><td>"+item.writer+"</td></tr>");
						
					});
					
				}		
			});
		} //selectList
		
		selectList();
		
		
		// 수정버튼 클릭시
		$("#btnUpdate").click(function(){
			
			// 비동기방식 -> REST컨트롤러 (수정정보 전달)
			var updateBoardVO = {
				"writer" : $("#uWriter").val(),
				"title" : $("#uTitle").val(),
				"content" : $("#uContent").val()
			};
			
			// ajax 사용하여 정보 수정
			$.ajax({
				url : "/boards/1",
				type : "PUT",
				data : JSON.stringify(updateBoardVO),
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					alert(" 수정 페이지 다녀옴 ");
					alert("결과 :"+data);
				}
				
			});
			
			
		});
		
		
		$("#btnDelete").click(function(){
			
			$.ajax({
				url:"/boards/983140",
				type:"DELETE",
				success :function(){
					alert(" 삭제페이지 다녀옴 ");	
				}			
			});
			
			
		}); // btnDelete
		
		
	}); //ready
</script>



</head>
<body>
	<h1>boardMain.jsp</h1>
	
	<!-- 작성자,제목,내용 입력받아서 글 작성 -->
	<h2 id="statusH2"> 상태 : </h2>
	<fieldset>
	   <legend> 글쓰기 (POST) </legend>
	작성자 : <input type="text" name="writer" id="writer"><br>
	제목 : <input type="text" name="title" id="title"><br>
	내용 : <textarea rows="5" cols="40" name="content" id="content"></textarea><br>
	
	<input type="button" value="글쓰기(POST)" id="btnAdd">
	</fieldset>
	
	<hr>
	<fieldset>
		<legend> 마지막 글 조회(GET) </legend>
		<input type="button" value="글조회(GET)" id="btnRead"> 
		
		<div id="divRead"></div>
		
	
	</fieldset>
	
	<hr>
	<fieldset>
		<legend> 게시판 목록 조회(GET) </legend>
		
		<table border="1">
		  <thead>
			   <tr>
			     <td>bno</td>
			     <td>title</td>
			     <td>writer</td>
			   </tr>
		  </thead>
		  <tbody>
		  
		  </tbody>		
		</table>
	</fieldset>
	
	<hr>
	<fieldset>
		<legend> 게시판 글 내용 수정 </legend>
		작성자 : <input type="text" name="writer" id="uWriter"><br>
		제목 : <input type="text" name="title" id="uTitle"><br>
		내용 : <textarea rows="5" cols="40" name="content" id="uContent"></textarea><br>
	
		<input type="button" value="글수정(PUT)" id="btnUpdate">
	</fieldset>
	
	
		<hr>
	<fieldset>
		<legend> 게시판 글 내용 삭제 </legend>
		<input type="button" value="글삭제(DELETE)" id="btnDelete">
	</fieldset>
	
	
	
	
	
	
	
	
</body>
</html>