<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goods.action?method=goodsAdd" method="post" enctype="multipart/form-data" >
		商品名称：<input type="text" name="gname" />
		商品类型：<input type="text" name="typeid"  />
		商品价格：<input type="text" name="gprice" />
		商品图片：<input type="file" name="gphoto"  />
		商品描述：<input type="text" name="gdes"  />
		<button type="submit">增加</button>
	</form>
</body>
</html>