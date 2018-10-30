
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<%@ include file="/common/basicLib.jsp"%>

<script type="text/javascript">
/* 
 //selectbox의 초기값
$(document).ready(function(){
	// 이부분을 db에서 조회 한 사용여부 값이 Y이면 사용으로 초기화 N이면 미사용으로 초기화
    $("select option[value='010']").attr("selected", true);
	if(db에서 조회한 사용여부의 값이 Y 이면){
		$("select option[value="use"]").attr("selected", true);
	}else{
		//db에서 조회한 사용여부의 값이 N이면 
		$("select option[value="notUse"]").attr("selected", true);
	}
 }); */

<%--  <%
 	List<BoardVo> boardList = (List<BoardVo>)request.getAttribute("boardList");
 	for(BoardVo board : boardList){
 		
 	}
 %>
 
 $(document).ready(function(){
	for(var i=0; i<%=boardList.size()%>; i++){
		if()
	}
 });
 --%> 
 
 $(document).ready(function(){
	 
	 //input이 생성될때마다 실행
	 /* $("#useNotuse").change(function(){
		if($("select option[value='Y']").val()=='Y'){
			$("select option[value='Y']").attr("selected", true);
		} else{
		$("select option[value='N']").attr("selected", true);
		}
		 
	 }); */

	 $(".createButton").on("click", function(){
		 var createBoard = $("#createBoard option:selected").val();
		 var boardNm = $("#boardName").val();
		 $("#boardUse").val(createBoard);
		 $("#boardNames").val(boardNm);
		 $("#fm").submit();
	 });
	 
	 

 });
 
</script>


</head>

<body>
<form id="fm" action="/boardMenuServlet" method="post">
	<input type="hidden" name="userId" value="${user.userId}">
	<input type="hidden" id="boardUse" name="boardUse">
	<input type="hidden" id="boardNames" name="boardNames">
</form>
		<%@ include file="/common/header.jsp"%>
		<div class="container-fluid">
			<div class="row">
				<%-- left --%>
				<%@ include file="/common/left.jsp"%>

				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


					<div class="blog-header">
						<h1 class="blog-title">게시판 메뉴 생성</h1>
						<p class="lead blog-description">createMenu</p>
					</div>

					<div class="row">

						<div class="col-sm-8 blog-main">

							<div class="blog-post">
								<h2 class="blog-post-title">메뉴 목록</h2>
								<p class="blog-post-meta">2017.10.30, room 201</p>

								<input type="text" class="btn btn-default" id="boardName" name="boardName" value=""
									placeholder="게시판 제목을 입력하세요" /> 
								<select class="btn btn-default" id="createBoard" >
									<optgroup>
										<option>사용 여부</option>
										<option>사용</option>
										<option>미사용</option>
									</optgroup>
								</select>
								<button type="submit" class="btn btn-default createButton" value="create">등록</button>
								<br> <br>
				
								<%-- 
							상세 구현 계획
							-> db가 완성된 후 위의 input은 새로운 게시판 메뉴를 생성하는 것이고
								여기는 기존에 있는 게시판 메뉴를 띄워주고 수정을 하는 곳
								forEach를 사용해서 db에서 게시판 이름을 반복적으로 출력한다.
								게시글 개수 만큼 input이 증가하도록 한다.
							--%>
							
								<c:forEach items="${boardAllList}" var="board">
									
									<form action="/boardUpdateServlet" method="post">
									<input type="hidden" name="boardNo" value="${board.board_no}">
									<input type="text" class="btn btn-default",  name="boardName"
										value="${board.board_name}" >
									<select class="btn btn-default" name="boardUse">
										<optgroup>
											<option>사용여부</option>
											<option value="Y"
												<c:if test="${board.board_use=='Y'}">selected</c:if>>사용</option>
											<option value="N"
												<c:if test="${board.board_use=='N'}">selected</c:if>>미사용</option>
										</optgroup>
									</select>
									<button type="submit" class="btn btn-default updateButton">수정</button>
									</form>
									<br>
									<br>
								</c:forEach>
									<form action="/loginServlet">
										<button type="submit" class="btn btn-default updateButton">완료</button>
									</form>
								<hr>
							</div>
						</div>
						<!-- /.blog-main -->
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>
