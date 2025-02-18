<%@page import="com.yedam.vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.Employee"%>
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
 	<h1>게시판 목록</h1>
	<!-- html 주석문 -->
	<%
	// boardList.do => request => boardList.jsp
	List<Board> list = (List<Board>) request.getAttribute("list");
	%>
	<table class="table">
	<thead>
	<tr>
		<th>게시글 번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>글쓴날짜</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody>
	<% for(Board brd : list){ %> 
	<tr>
		<td><%= brd.getBoardNo() %></td>
		<td><%= brd.getContent() %></td>
		<td><%= brd.getWriter() %></td>
		<td><%= brd.getWriteDate() %></td>
		<td><%= brd.getViewCnt() %></td>
	</tr>
	<%	} %>
	</tbody>
	</table>
</body>
</html>