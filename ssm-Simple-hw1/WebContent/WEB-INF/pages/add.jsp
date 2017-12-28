<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(":input[name='name']").change(function(){
			var name = $("#na").val();
			 $.post("${pageContext.request.contextPath}/addSuccess1",{uname:name},function(data){
				if(data == 1){
					 $("#va").text("用户已存在");
					 $("#na").val("");
				}else{
					$("#va").text("");
				}
			})
		})
		return false;
	})
</script>
</head>
<body>
<c:if test="${requestScope.num==1 }">
<h1>添加界面</h1>
<form action="${pageContext.request.contextPath }/addSuccess" method="post">
姓名：<input type="text" name="name" required id="na"><font color="blue"><span id="va"></span></font><br/>
密码：<input type="password" name="password" required><br/>
年龄：<input type="number" name="age" required><br/>
课程：<select name="lession">
		<c:forEach items="${requestScope.subject }" var="subject">
			<option value="${subject.jId }">${subject.jName }</option>
		</c:forEach>
</select><br/>
<input type="submit" value="提交">
</form>
</c:if>

<c:if test="${requestScope.num == 2}">
	<h1>修改界面</h1>
	<form action="${pageContext.request.contextPath }/updateSuccess" method="post">
	<input type="hidden" name="id" value="${requestScope.student.sId }"/>
	姓名：<input type="text" readonly="readonly" name="name" value="${requestScope.student.sName }"/><br/>
	密码：<input type="text" name="password" value="${requestScope.student.sPassword }"/><br/>
	年龄：<input type="text" name="age" value="${requestScope.student.sAge }"/><br/>
	报名时间：<input type="text" name="sCreateDate" readonly="readonly" value="${requestScope.student.sCreateDate }"/>
	<br/>
	课程：<select name="lession">
			<option value="${requestScope.student.subject.jName}">${requestScope.student.subject.jName}</option>
			 <c:forEach items="${requestScope.subject }" var="subject">
				<c:if test="${subject.jName != requestScope.student.subject.jName}">
					<option value="${subject.jId }">${subject.jName }</option>
				</c:if>
			</c:forEach> 
	</select><br/>
	<input type="submit" value="提交">
	</form>
</c:if>
</body>
</html>