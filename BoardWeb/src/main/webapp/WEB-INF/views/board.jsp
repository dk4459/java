<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
<head>
	<style>
		#content{
			height: 400px
		}
	</style>
</head>
	<%
	BoardVO list = (BoardVO) request.getAttribute("board");
	String msg = (String) request.getAttribute("msg");
	String logId = (String) session.getAttribute("loginId");
	%>
<h3 align ="center" class="mt-5">상세페이지</h3>
<form action="modifyForm.do">
<input type="hidden" name="boardNo" value="<%= list.getBoardNo() %>">
<table class="table table-striped w-75 mt-5" align="center">
	<tr>
	  <th>제목:</th>
	  <td colspan="2" >
	  <%= list.getTitle() %>
	  </td>
	  <th>작성자:</th>
	  <td id='writer'>
	  <%= list.getWriter() %>
	  </td>
	  <th>조회수:</th>
	  <td>
	  <%= list.getViewCnt() %>
	  </td>
	  <th>작성일자:</th>
	  <td>
	  <%= list.getWriterDate() %>
	  </td>
	</tr>
	<tr id="content" >
	  <th>내용</th>
	  <td colspan = "8" >
	  	<%= list.getContent() %>
	  </td>
	</tr>
	<tr>
		<td colspan="9" align="center">
		  <button class="btn btn-success"type="submit">수정</button>
		  <button class="btn btn-danger" type="button">삭제</button>
		</td>
	</tr>
	<tr>
		  <% if(msg != null){ %>
		<td colspan="9" align = "center">
			  <span style = "color:red;"><%=msg %></span>
		</td>
		  <% } %>
	</tr>
</table>
</form>
<script>
	let logId = "<%=logId%>";
	document.querySelector('button.btn-danger')
	.addEventListener('click',function(e){
		let writer = document.querySelector('#writer').textContent
		let bno = document.querySelector('input[name="boardNo"]').value;
		console.log(writer,logId)
		if(writer.trim() == logId.trim()){
		location.href = "deleteControl.do?boardNo="+bno;
		}else{
			alert('권한을 확인하세요');
		}
	});
</script>
<jsp:include page="includes/footer.jsp"></jsp:include>