<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 결제</title>
</head>
<body>
    <form action="kakaoControl.do" method="post">
        상품명: <input type='text' name='itemName' class='form-control' required><br>
        갯수: <input type='number' name='quantity' class='form-control' value="1" required><br>
        금액: <input type='number' name='amount' class='form-control' required><br>
        <button type="submit">결제하기</button>
    </form>
</body>
</html>