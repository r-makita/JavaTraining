<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会</title>
<div style="text-align:center">
<style type="text/css">
body {
	background-image: url("jpeg/キラキラ2.jpg"); /* 画像 */
	background-size: cover; /* 全画面 */
}
</style>
</head>
<body>
<br><br><h1>退会しますか？</h1><br>
<br>	<a><img src="jpeg/maji.jpg" "width=500 height=500" alt="悲しみの退会泣き泣き"></a>
			
<br><h4>本当に退会する場合のみ退会ボタンをクリックしてください。</h4>
<br><h4>退会が完了するとログイン画面に遷移します。</h4>

<form action="/Enshu/HamburgerServlet"  method="post">
<br><input type="submit" value="退会" /><br><br>
<input type = "hidden" name="action" value="delete"/>
</form>

<br><a href="Mypage.jsp">戻る</a>
</div>
</body>
</html>