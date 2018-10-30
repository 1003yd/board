
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<%@ include file="/common/basicLib.jsp"%>

<style type="text/css">
.userClick {
	cursor: pointer;
}

table{
	width: 150px;
}

.removePost{
	text-align: center;
}

/* #titleTd{
	width:400px;
} */

#rnum{
	width: 50px;
}
</style>


<script type="text/javascript">
	$(document).ready(function(){
		console.log("documnet.ready");
		
		//tr에 select(class="userClick")
		$(".userClick").on("click", function(){
			/* console.log("userClick");
			var userId= $(this).children()[0].innerText; */
			var postNo = $(this).children(".post").val();
			$("#postNum").val(postNo);
			$("#frm").submit();
		});
		
	});
		
	
	
</script>

</head>
<form id="frm" action="/boardDetailPageServlet" method="get">
	<input type="hidden" id="postNum" name="postNum">
</form>

<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">목록</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>내용</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>

								<%-- <%
									List<UserVO> userList = (List) request.getAttribute("pageUserList");
									int index = 1;
									for (UserVO uservo : userList) {
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								%>

								<tr class="userClick">
									<td><%=uservo.getRnum()%></td>
									<td><%=uservo.getUserId()%></td>
									<td><%=uservo.getName()%></td>
									<td><%=sdf.format(uservo.getBirth())%></td>
								</tr>


								<%
									index++;
									}
								%> --%>

								<c:forEach items="${postList}" var="post">
									<c:if test="${post.post_rmv =='Y'}">
									<tr>
										<td>${post.rnum}</td>
										<td colspan="4" class ="removePost">삭제된 글입니다.</td>	
									</tr>
									</c:if>
									<c:if test="${post.post_rmv=='N'}">
									<tr class="userClick">
										<td id="rnum">${post.rnum}</td>
										<td id="titleTd">${post.post_title}</td>
										<td>${post.post_context}</td>
										<td>${post.post_user}</td>
										<td><fmt:formatDate value="${post.post_date}"
												pattern="yyyy-MM-dd" /></td>
									<input type="hidden" class="post" name="postNo" value="${post.post_no}"/>
									</tr>
									</c:if>
								</c:forEach>


							</table>
						</div>

						<a class="btn btn-default pull-right" href="/boardNewPostServlet">새글 등록</a>

						<div class="text-center">

							<ul class="pagination">
								<li><a href="/boardMenuPageServlet?boardNo=${boardNo}&page=1&pageSize=10" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<%-- <%
								int pageCnt = (Integer)request.getAttribute("pageCnt");
								for(int p = 1; p <= pageCnt ; p++){
									
								
							%>
								<li><a href="/userPageList?page=<%=p%>&pageSize=10"><%=p%></a></li>
								<%
								}
								%>
								<li><a href="/userPageList?page=<%=pageCnt%>&pageSize=10"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li> --%>
								<%-- <c:forEach begin="1" end="${pageCnt}" var="p">
									<li><a href="/userPageList?page=${p}&pageSize=10">${p}</a></li>
								</c:forEach>
								<li><a href="/userPageList?page=${pageCnt}&pageSize=10"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li> --%>
								<c:forEach begin="1" end="${pageCnt}" var="p">
									<li><a href="/boardMenuPageServlet?boardNo=${boardNo}&page=${p}&pageSize=10">${p}</a></li>
								</c:forEach>
								<li><a href="/boardMenuPageServlet?boardNo=${boardNo}&page=${pageCnt}&pageSize=10"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
