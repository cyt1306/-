<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录界面</title>
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


<h1>   管理员登陆界面</h1>


<form action="/admin/logon" method="post" name="登陆界面">
 <table>
      <tr>
      <td>管理员名:</td>
      <td><input type="text" name="name" size="20"> </td>
      </tr>
    
      <tr>
      <td>密码：</td>
      <td>  <input type="password"  name="password" size="20"></td>
      </tr>
     
      <tr>
      <td><input type="submit"  value="登陆"></td>
      <td><input type="reset" value="重置"></td>
      </tr>
 
 
 
 </table>
 </form>
 </body>
 </html>
