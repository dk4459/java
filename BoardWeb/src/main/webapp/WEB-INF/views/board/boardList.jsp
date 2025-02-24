
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<style>
		form{
			width:1000px
		}
	</style>
</head>
<h3 align="center" class="mb-5 mt-5">게시글 목록</h3>
<div class="d-flex justify-content-center mb-5">
<form action="boardList.do">
<div id="center">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control" >
			  
				<option value="">선택하세요</option>
				<option value="T" ${searchCondition=="T"?"selected":"" }>제목</option>
				<option value="W" ${searchCondition=="W"?"selected":"" }>작성자</option>
				<option value="TW" ${searchCondition=="TW"?"selected":"" }>제목 & 작성자</option>
			</select>
		</div>
		<div class="col-sm-5">
			 <input class="form-control" name="keyword" value="${keyword}">
		</div>
		<div class="col-sm-2">
			<input type= "submit" value="조회"  class="btn btn-primary">
		</div>
	</div>
 </div>
</form>
</div>
<table class="table table-striped w-75 rwerw" align="center">
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
		<!-- 향상된 for문 같이 활용 -->
		<c:forEach var="board" items="${list }">
		<tr>
			<td>${board.boardNo}</td>
			<td><a href="board.do?boardNo=${board.boardNo}&searchCondition=${searchCondition}&keyword=${keyword}&page=${paging.currentPage}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.writerDate}</td>
			<td>${board.viewCnt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<div  class="d-flex justify-content-center">
<nav aria-label="..." align="center">
	<ul class="pagination">
	<c:choose>
	<c:when test = "${paging.prev}">
		<li class="page-item"><a class="page-link" href="boardList.do?page=${paging.startPage-1 }&searchCondition=${searchCondition}&keyword=${keyword}" >Previous</a>
		</li>
	</c:when>
	 <c:otherwise>
	 <li class="page-item disabled"><span class="page-link">Previous</span>
		</li>
	 </c:otherwise>
	 </c:choose>
	<!-- 페이지 start ~ end -->
	 	<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
		<c:choose>
		<c:when test="${p==paging.currentPage}">
			<li class="page-item active"><a class="page-link" href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}">${p}</a></li>
		</c:when>
		 <c:otherwise>
			<li class="page-item"><a class="page-link" href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}">${p}</a></li>
		</c:otherwise>
		</c:choose>
		</c:forEach>
		<c:choose>
		 <c:when test="${paging.next}">
		<li class="page-item"><a class="page-link" href="boardList.do?page=${paging.endPage+1 }&searchCondition=${searchCondition}&keyword=${keyword}">Next</a></li>
		 </c:when>
		  <c:otherwise>
			<li class="page-item disabled"><a class="page-link">Next</a></li>
		 </c:otherwise>
		</c:choose>
	</ul>
</nav>
</div>
