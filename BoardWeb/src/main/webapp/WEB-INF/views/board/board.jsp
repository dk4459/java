<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<style>
		#content{
			height: 400px
		}
		img{
			width:300px
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
<style>
	.reply .content ul {
		list-style-type:none;
	}
	.reply .content span {
		display: inline-block
	}
	li{
	  margin-bottom:15px;
	}
</style>
<div class="container reply">
 <!-- 댓글등록 -->
 <div class="header">
   <input type="text" id="reply" class="col-sm-9">
   <button id="addReply" class="btn btn-primary">댓글등록</button>
 </div>
 <!-- 댓글목록 -->
 <div class="content">
 <ul>
 	<li>
 		<span class="col-sm-2">글번호</span>
 		<span class="col-sm-5">글내용</span>
 		<span class="col-sm-2">작성자</span>
 		<span class="col-sm-2">삭제</span>
 	</li>
 </ul>
 </div>
</div> 
<script>
	let logId = '${loginId}';
	let bno = '${board.boardNo}'
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
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script> 