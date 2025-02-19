<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<jsp:include page="includes/header.jsp"></jsp:include>
	<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	
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
				<td><%=board.getBoardNo() %> </td>
				<td><a href="board.do?boardNo=<%= board.getBoardNo()%>"><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getWriterDate() %></td>
				<td><%=board.getViewCnt() %></td>
			</tr>
			<%
			} // for 종료.
			%>
		</tbody>
	</table>
<jsp:include page="includes/footer.jsp"></jsp:include>