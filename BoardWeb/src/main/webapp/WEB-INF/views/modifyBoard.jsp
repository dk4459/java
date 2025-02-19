<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
<head>
<style>
#content {
	height: 400px
}
</style>
</head>
<h3 align="center" class="mt-5">수정화면</h3>
<%
BoardVO list = (BoardVO) request.getAttribute("board");
%>
<form action="modifyBoard.do">
<input type="hidden" name="boardNo" value="<%= list.getBoardNo() %>">
	<table class="table table-striped w-75 mt-5" align="center">
		<tr>
			<th>제목:</th>
			<td colspan="2"><input type="text" name="title" value="<%=list.getTitle()%>"></td>
			<th>작성자:</th>
			<td><%=list.getWriter()%></td>
			<th>조회수:</th>
			<td><%=list.getViewCnt()%></td>
			<th>작성일자:</th>
			<td><%=list.getWriterDate()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="8"><textarea cols="45" rows="15" class="form-control" name="content"><%=list.getContent()%></textarea></td>
		</tr>
		<tr>
		<td colspan ="9" align="center">
		<button type="submit" class="btn btn-primary" >수정</button>
		</td>
		</tr>
	</table>
</form>
<jsp:include page="includes/footer.jsp"></jsp:include>