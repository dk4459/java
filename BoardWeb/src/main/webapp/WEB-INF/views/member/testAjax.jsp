<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Ajax연습페이지</h3>

<table class="table">
<tr>
	<th>회원ID</th><td><input type="text" name="mid"></td>
</tr>
<tr>
	<th>비밀번호</th><td><input type="text" name="mpw"></td>
</tr>
<tr>
	<th>회원이름</th><td><input type="text" name="mname"></td>
</tr>
<tr>
  <td colspan="2" align="center">
<button class="btn btn-warning" id="addMember">등록</button>	  
  </td>
</tr>
</table>

<h3 align="center">회원목록</h3>
<table class="table">
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원비밀번호</th>
			<th>회원이름</th>
			<th>권한</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="list">
		
	</tbody>
</table>
<script src="js/test.js"></script>