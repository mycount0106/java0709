<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goods.action?method=goodsEdit" method="post" enctype="multipart/form-data" >
		序号：<input type="hidden" name="gid" value="${goods.gid }" />
		商品名称：<input type="text" name="gname" value="${goods.gname }" />
		商品类型：<input type="text" name="typeid" value="${goods.typeid }"  />
		商品价格：<input type="text" name="gprice" value="${goods.gprice }" />
		商品图片：<input type="file" name="gphoto" value="${goods.gphoto }"  />
		商品描述：<input type="text" name="gdes" value="${goods.gdes }" />
		<button type="submit">修改</button>
	</form>
</body>
</html>