<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="phont.css">
<title>MENU</title>
<po>
<%@ include file = "Ichinose.jsp" %>
<style type="text/css">
body {
	background-image: url("jpeg/login.jpg"); /* 画像 */
	background-size: cover; /* 全画面 */
}


.yo{
margin:70px;
}

p{
	position:center center;
	font-size: 20px;
}
</style>
</head>
<body>
<po>
		<div class = "yo">
		<table align="center" text-align="center">
    <td><a href="Beacon2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/ダブルベーコン.jpg" width=250 height=200  alt="ハンバーガー"><p>ダブルベーコンチーズバーガー</p><span><p>850円</p></span></td>
			<td><a href="Chiri2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/チリ.jpg "width=300 height=200  alt="ハンバーガー"><p>レッドホットチリバーガー</p><span><p>750円</p></span></td>
			<td><a href="Fish2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/フィッシュ.jpg" width=250 height=250  alt="ハンバーガー"><p>具だくさんタルタルフィッシュバーガー</p><span><p>450円</p></span></td>
    </tr>
    </div>
</table>

		<table align="center" text-align="center">
    <td><a href="Abochi2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/アボチ.jpg" width=250 height=250  alt="ハンバーガー"><p>アボカドチーズバーガー</p><span><p>850円</p></span></td>
			<td><a href="Soy2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/ヴィーガン.jpeg" width=300 height=200  alt="ハンバーガー"><p>彩野菜のSOYバーガー</p><span><p>400円</p></span></td>
			<td><a href="Origin2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/オリジナル.jpg" width=250 height=250  alt="ハンバーガー"><p>オリジナルSHINDANバーガー</p><span><p>1200円</p></span></td>
    </tr>
    </div>
</table>



<table align="center" text-align="center">
   <tr>			
			<td><a href="Pote2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/ポテ.jpg" width=250 height=200  alt="ハンバーガー"><p>厚切りフライドポテト</p><span><p>350円</p></span></td>
			<td><a href="Nage2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/ナゲ.jpg" width=250 height=200  alt="ハンバーガー"><p>ナゲット15ピース</p><span><p>450円</p></span></td>
			<td><a href="coca2.jsp">&nbsp;&nbsp;&nbsp;<img src="jpeg/cocacola.png" width=250 height=200  alt="ハンバーガー"><p>コカ・コーラLサイズ</p><span><p>450円</p></span></td>
    </tr>
    </div>
</table>
	
			 <input type = "hidden" name ="action" value="購入"/><br>
			</po>
		</tr>
	</table>
</po>
</body>
</html>