<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORIGINAL SHINDAN BURGER</title>
<link rel="stylesheet" href="button.css"> 
<link rel="stylesheet" href="phont.css">

<style type="text/css">
body {
	background-image: url("jpeg/星.jpeg"); /* 画像 */
	background-size: cover; /* 全画面 */
}
</style>
<div style="text-align:center">
<br><br><po><p>あなたにおすすめのハンバーガーは・・・</p>
<img src="jpeg/ダブルベーコン.jpg" width=350 height=250  alt="ハンバーガー">
<p>オリジナルSHINDANバーガー</p><form action="/Enshu/HamburgerServlet"  method="post">
	<font size="3" >個数</font>
	<select name="kosuu">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	</select><br><br> 
	<!-- shouhinNameにオリジナルSHINDANバーガーを入れて、カートへ追加が押下された際にServletのaddcartへ渡す -->
<input type = "hidden" name="shohinName" value="オリジナルSHINDANバーガー"/>
<!-- hiddenは入力しなくても送信してくれるというもの -->
<input type = "hidden" name="nedan" value="1200"/>
<input type = "hidden" name="kosuu" value="kosuu"/>
<input type = "hidden" name ="action" value="addcart"/>
<input type="submit"  value="カートへ追加" class ="button"/><br><br><br>
<br><br><a href="Menu.jsp">メニューへ</a><br>
</po>
</form>

</div>
</head>
<body>

</body>
</html>