<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Hamburger Login</title>
<link rel="stylesheet" href="phont.css">
<link rel="stylesheet" href="button.css">
<style type="text/css">
body {
	background-image: url("jpeg/login.jpg"); /* 画像 */
	background-size: cover; /* 全画面 */
}
</style>
</head>
<body background="jpeg/login.jpg">
	<div style="text-align:center">
		<font size="7" face="Cooper">Login</font>
		<p>
			<a href="Secretphoto3.jsp"><img src=jpeg/81_burger-1.png width="300" height="300" alt="ハンバーガー"></a>
		</p>
	</div>
	<div style="text-align: center">
		<font size="5" face="Cooper">Login ID</font>
		<form action="/Enshu/HamburgerServlet"  method="post">
			<input type="text" name="id"placeholder="Enter ID"  /><br> <br>
			<p><font size="5" face="Cooper">Password</font><br>
			 <input type="text" name="pass" placeholder="Enter Password" >
			 <input type = "hidden" name ="action" value="login"/><br>
			 </p>
			<input type="submit" value="Login"  placeholder="Enter Login ID" class="button" /><br>
			<br> <br> <a href="Touroku.jsp">新規会員登録</a>

		</form>
	</div>

</body>
</html>