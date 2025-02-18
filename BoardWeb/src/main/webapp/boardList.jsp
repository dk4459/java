<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	
	<h3>게시글 목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>글제목</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BoardVO board : list) {
			%>
			<tr>
				<td><%=board.getBoardNo() %></td>
				<td><%=board.getTitle() %></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getWriterDate() %></td>
				<td><%=board.getViewCnt() %></td>
			</tr>
			<%
			} // for 종료.
			%>
		</tbody>
	</table>
</body>
</html>