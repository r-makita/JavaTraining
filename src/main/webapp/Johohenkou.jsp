<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
<link href="phont.css" rel="stylesheet">
<style type="text/css">
body {
   background-image: url("jpeg/キラキラ2.jpg"); /* 画像 */
   background-size: cover;               /* 全画面 */
   
  
}
</style>
<div style="text-align:center">

<form action="/Enshu/HamburgerServlet"  method="post">
<br><br><br><br>
<po>
<font  size="3" >パスワード(半角英数字８文字以上)</font>
<br><br>
<input type = "text" name="pass" placeholder="パスワードを設定"/><br><br>
 <input type = "submit"  value="変更"/><br>
 <br>
<input type = "hidden" name="action" value="update"/>

※IDは変更できません。<br>
※変更完了後、ログインページに遷移します。
</po>
</div>
</head>
<body>

</body>
</html>