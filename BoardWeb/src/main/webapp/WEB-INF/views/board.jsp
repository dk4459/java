<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp"></jsp:include>
<head>
	<style>
		#content{
			height: 400px
		}
	</style>
</head>
    <!-- getAttribute값 가져오기 -->
	<!-- <p>BoardVO객체의 값 => ${board}</p> -->
	<!--<p>String 객체의 값${msg}</p> -->
	<!--<p>String 객체의 값${loginId}</p> -->

<h3 align ="center" class="mt-5">상세페이지</h3>
<form action="modifyForm.do">
<input type="hidden" name="boardNo" value="${board.boardNo}">
<table class="table table-striped w-75 mt-5" align="center">
	<tr>
	  <th>제목:</th>
	  <td colspan="2" >
	  ${board.title}
	  </td>
	  <th>작성자:</th>
	  <td id='writer'>
	  ${board.writer}
	  </td>
	  <th>조회수:</th>
	  <td>
	  ${board.viewCnt}
	  </td>
	  <th>작성일자:</th>
	  <td>
	  ${board.writerDate} 
	  </td>
	</tr>
	<tr id="content" >
	  <th>내용</th>
	  <td colspan = "8" >
	  	${board.content} 
	  </td>
	</tr>
	<tr>
	  <th>이미지</th>
	  <td colspan = "8" >
	  	<img src="images/${board.img }"> 
	  </td>
	</tr>
	<tr>
		<td colspan="9" align="center">
		  <button class="btn btn-success"type="submit">수정</button>
		  <button class="btn btn-danger" type="button">삭제</button>
		</td>
	</tr>
		 <c:if test="${msg != null}">
		<tr> 
		    <td colspan="9" align = "center">
			 <span style = "color:red;">${msg }</span>
		    </td>
		  </tr>
		</c:if>
</table>
</form>
<script>
	let logId = '${loginId}';
	document.querySelector('button.btn-danger')
	.addEventListener('click',function(e){
		let writer = document.querySelector('#writer').textContent
		let bno = document.querySelector('input[name="boardNo"]').value;
		console.log(writer,logId)
		if(writer.trim() == logId.trim()){
		location.href = "deleteControl.do?boardNo="+bno+"&searchCondition=${search}&keyword=${keyword}&page=${page}";
		}else{
			alert('권한을 확인하세요');
		}
	});
</script>
<jsp:include page="includes/footer.jsp"></jsp:include>