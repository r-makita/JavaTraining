<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR</title>
<link rel="stylesheet" type="text/css" href="button.css">
<style type="text/css">
body {
   background-image: url("jpeg/login.jpg"); /* 画像 */
   background-size: cover;               /* 全画面 */
  
}
</style>
<div style="text-align:center">
</head>
<body>

<br><br><br>
<a href="Secretphoto2.jsp"><img src="jpeg/QR.png" width=250 height=250  alt="ハンバーガー"></a>

<br><br><br><br><tr>ご購入ありがとうございます<tr>
完成までしばらくお待ちください♪

<br><br><br>
<form action="/Enshu/HamburgerServlet"  method="post">
<input type = "hidden" name="action" value="dbdelete"/>
<br><input type="submit" value="マイページへ戻る" class = "button"/><br><br>

</form>



</body>
</div>
</html>