<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
.zt{
    font-size:45px;
    font-family:ngaan;
    text-align:center;
}
@font-face{
    font-family:ngaan;
    src:url("/xiaotu.ttf");
}
table{
    text-align:center;
    margin:0px auto;
}
</style>
</head>

<body class="zt">




<form method="POST" action="/admin/adddb">
	书名<input type="text" name="name" size="20"><br>
	价格<input type="text" name="price" size="20"><br>
	数量<input type="text" name="quantity" size="20"><br>
	
	<p><input type="submit" value="提交" name="B1"><input type="reset" value="重置" name="B2"></p>
</form>




</body>

</html>