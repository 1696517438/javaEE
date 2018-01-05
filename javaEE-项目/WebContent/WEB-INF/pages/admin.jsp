<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
<font color="orange"><h3>管理员：${requestScope.user.uname} </h3></font>
<div id="one"><a href="${pageContext.request.contextPath}/resume/addResumes?name=${requestScope.user.uname}"><img src="../images/5.gif"  height="80px" width="80px"></a></div><br/>
</body>
</html>