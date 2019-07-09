<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script>
 	$(document).ready(function(){
 		$(".getGoods").click(function(){
			location.href="goods.action?method=getGoods&gid="+$(this).val();
	});
 		$(".delGoods").click(function(){
			location.href="goods.action?method=delGoods&gid="+$(this).val();
	});
 	});
</script>
</head>
<body>
	<table width="800px">
		<caption>商品表</caption>
		<tr>
			<td>序号</td>
			<td>商品名称</td>
			<td>商品类型</td>
			<td>商品价格</td>
			<td>商品图片</td>
			<td>商品描述</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${goodsList }" var="goods" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${goods.gname }</td>
				<td>${goods.typeid }</td>
				<td>${goods.gprice }</td>
				<td>
					<img src="imgs/${goods.gphoto }" width="200px" height="150px"> 
				</td>
				<td>${goods.gdes }</td>
				<td>
					<button class="getGoods" value="${goods.gid }">编辑</button>
				</td>
				<td>
					<button class="delGoods" value="${goods.gid }">删除啊</button>
				</td>
			</tr>	
		</c:forEach>
	</table>
	<button onclick="location.href='goodsAdd.jsp'">增加商品</button>
</body>
</html>