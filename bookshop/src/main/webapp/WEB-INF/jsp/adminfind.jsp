<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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
<div class="panel panel-primary">
	<!-- .panel-heading 面板头信息。 -->
	<div class="panel-heading">
		<!-- .panel-title 面板标题。 -->
		<h3 class="panel-title">图书清单</h3>
	</div>
</div>
<div class="container">
	
	<div class="col-md-12">
			
			  <div class="panel-body">
				<!-- table-responsive:响应式表格,在一个表展示所有的数据,当不够显示的时候可以左右滑动浏览-->
				<div class="table table-responsive">
					<!--
	                	.table-bordered 类为表格和其中的每个单元格增加边框。
	                	.table-hover 类可以让 <tbody> 中的每一行对鼠标悬停状态作出响应。
	                -->
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center">书名</th>
								<th class="text-center">价格</th>
								<th class="text-center">数量</th>
							</tr>
						</thead>
						<tbody class="text-center">
						<!-- 这里requestScope还不清楚是什么，到时候要改一下 -->
							<c:forEach items="${requestScope.listbook }" var="book">
								<tr>
									<td>${book.name}</td>
									<td>${book.price}</td>
									<td>${book.quantity}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	</div>
</div>

</body>
</html>