<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加部门和职位页面</title>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)">
	<a >添加部门</a>
	<form action="">
		<table>
			<tr>
				<td>部门名字:</td>
				<td><input type="text" required name="deptName"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>