<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
<style type="text/css">
	a{
	text-decoration: none;
	color: red;
	}
	#dept{
	background-color: white;
	width: 120px;
	margin-left: 300px;
	}
	#post{
	background-color: white;
	width: 120px;
	margin-top: -74px;
	margin-left: 430px;
	}
	#two{
		margin-top: -100px;
		margin-left: 100px;
	}
</style>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
	<font color="orange"><h3>管理员：${requestScope.user.uname} </h3></font>
	<div id="one">
		<a href="${pageContext.request.contextPath}/department/queryAllDept?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/5.gif"  height="80px" width="80px">	
		</a>
	</div>
	<div id="two">
		<a href="${pageContext.request.contextPath}/department/addDept?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/7.gif"  height="80px" width="80px">	
		</a>
	</div>
		<br/>
	<div id="dept">
		<center>
			<c:forEach items="${requestScope.department }" var="dept">
				<a href="${pageContext.request.contextPath}/department/queryById?id=${dept.did}&name=${requestScope.user.uname}">${dept.dname }</a>
				
				<a href="${pageContext.request.contextPath}/department/deldept?id=${dept.did}&name=${requestScope.user.uname}" style="margin-top: 10px;">
					<img  src="${pageContext.request.contextPath}/images/delete.jpg" width="20px" height="20px">
				</a><br/>
			</c:forEach>
			
		</center>
		<font color="blue">${requestScope.mgs }</font>
	</div>
	<div id="post">
		<center>
			<c:forEach items="${requestScope.post }" var="post">
				${post.pname }
				<a href="${pageContext.request.contextPath}/department/delpost?pid=${post.pid}&id=${post.did}&name=${requestScope.user.uname}" style="margin-top: 10px;">
					<img  src="${pageContext.request.contextPath}/images/delete.jpg" width="20px" height="20px">
				</a><br/>
			</c:forEach>
		</center>
	</div>
</body>
</html>