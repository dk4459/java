<%@page import="com.yedam.PageVO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp"></jsp:include>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
//페이징값 가져오기
PageVO paging = (PageVO) request.getAttribute("paging");
%>
<p>page의 값 <%= paging %></p>
<h3 align="center" class="mb-5 mt-5">게시글 목록</h3>
<table class="table table-striped w-75" align="center">
	<thead>
		<tr>
			<th>게시글 번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO board : list) {
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href="board.do?boardNo=<%=board.getBoardNo()%>"><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getWriterDate()%></td>
			<td><%=board.getViewCnt()%></td>
		</tr>
		<%
		} // for 종료.
		%>
	</tbody>
</table>
<div  class="d-flex justify-content-center">
<nav aria-label="..." align="center">
	<ul class="pagination">
	 <%if(paging.isPrev()){ %>
		<li class="page-item"><a class="page-link" href=boardList.do?page=<%=paging.getCurrentPage()-(paging.getCurrentPage()-paging.getStartPage()+1) %>>Previous</a>
		</li>
	 <%}else{ %>
	 <li class="page-item disabled"><span class="page-link">Previous</span>
		</li>
	 <%}%>
	<!-- 페이지 start ~ end -->
		<% for(int p =paging.getStartPage(); p<=paging.getEndPage(); p++){ %>
		<% if(p == paging.getCurrentPage()){ %>
			<li class="page-item active"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>	
		<%} else { %>
		<li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
		<%} }%>
		<%if(paging.isNext()){ %>
		<li class="page-item"><a class="page-link" href="boardList.do?page=<%=paging.getCurrentPage()+(paging.getEndPage()-paging.getCurrentPage())+1 %>">Next</a></li>
		<%}else{ %>
			<li class="page-item disabled"><a class="page-link">Next</a></li>
		<%}%>
	</ul>
</nav>
</div>
<script>



</script>
<jsp:include page="includes/footer.jsp"></jsp:include>