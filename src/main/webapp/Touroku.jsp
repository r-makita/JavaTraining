<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet" href="button.css"> 
<link rel="stylesheet" href="phont.css"> 
<style type="text/css">
body {
   background-image: url("jpeg/キラキラ.jpg"); /* 画像 */
   background-size: cover;               /* 全画面 */
   
  
}
</style>



 <form action ="/Enshu/HamburgerServlet" method="post">
 <po>
<div style="text-align: center">
<br><br><br><br><br><br><font  size="3" >ログインID(お名前)</font>
<input type = "text" name="id" placeholder="ログインIDを設定"/><br><br>
<font  size="3" >パスワード(半角英数字８文字以上)</font>
<input type = "text" name="pass" placeholder="パスワードを設定"/><br><br>
<input type = "hidden" name="action" value="add"/>

※IDの変更はできません。
</po>
<br><br><br>
<input type="submit" value="登録する" class ="button">  
</form>
</head>
<body>
</div>
</body>
</html>