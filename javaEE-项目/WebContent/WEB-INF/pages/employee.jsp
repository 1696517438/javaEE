<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="f"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工操作界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("#bt").click(function(){
		var result = confirm("确定退出吗？");
		if(!result){
			return false;
		}
	})
})
</script>

<style type="text/css">
	a{
	text-decoration: none;
	}
	a:hover{
		color: red
	}
	#two{
		margin-left: 20px;
		margin-top: 20px;
		}

	#Mymesage{
		margin-left: 200px;
		margin-top: -300px;
	}
	#updatepwd{
		margin-left: 200px;
		margin-top: -300px;
	}
</style>

</head>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
	<font color="orange"><h3>用户：${requestScope.user.uname} </h3></font>
	<div id="one">
		<a href="${pageContext.request.contextPath}/employee/queryEmployeeByname?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/e-1.gif"  height="80px" width="80px">	
		</a>
	</div>
	
	  <div id="two">
	  <a href="${pageContext.request.contextPath}/user/GotoUpdate?name=${requestScope.user.uname}">
	  	<img src="../images/6.gif"  height="80px" width="80px">
	  </a>
  </div><br/>
	
	<div id="exit">
	 	<a href="${pageContext.request.contextPath }/user/returnIndex" id="bt">
	 		<img src="../images/d-3.gif"  height="80px" width="80px">
	 	</a>
 	</div>
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	<c:if test="${!empty requestScope.employee}">
		<div id="Mymesage">
			<table border="1" style="color:white">
				<tr>
					<td>名字</td>
					<td>${requestScope.employee.ename}</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${requestScope.employee.egender}</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>${requestScope.employee.age}</td>
				</tr>
				<tr>
					<td>学历</td>
					<td>${requestScope.employee.education}</td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td>${requestScope.employee.phone}</td>
				</tr>
				<tr>
					<td>电子邮箱</td>
					<td>${requestScope.employee.email}</td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td>
					<f:formatDate value="${requestScope.employee.cometime}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>政治面貌</td>
					<td>${requestScope.employee.sface}</td>
				</tr>
				
				<tr>
					<td>爱好</td>
					<td>${requestScope.employee.hobby}</td>
				</tr>
				<tr>
					<td>职位</td>
					<td>${requestScope.employee.rename}</td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
					<a href="${pageContext.request.contextPath }/user/queryResume?name=${requestScope.user.uname}">简历</a>
					</td>
				</tr>
			</table>
			</div>
	</c:if>
	
</body>
</html>