<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートの中身</title>
<style type="text/css">
body {
	background-image: url("jpeg/login.jpg"); /* 画像 */
	background-size: cover; /* 全画面 */
}
</style>
</head>
<body>

	<br>
	<br>
	<br>
	<div style="text-align: center">
		<table align="center" border="1">
			<c:forEach items="${shohin}" var="shohin">
				<tr>
					<td>${shohin.shouhin}</td>
					<td>${shohin.kazu}</td>
					<td>${shohin.kingaku}</td>
				</tr>
			</c:forEach>
		</table>

		<br>
		<br><br><a href="Kounyu.jsp">購入画面へ進む</a><br>
		<br> <br><br><br>
		<a href="Menu.jsp">メニューを見る</a><br>
		<br>
	</div>
</body>
</html>