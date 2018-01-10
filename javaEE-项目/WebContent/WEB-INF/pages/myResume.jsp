<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的简历</title>
<style type="text/css">
	a{
		text-decoration: none;
	}
	a:hover{
		color:red;
	}
</style>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)">
	<center>
		<font color="BlueViolet"><h1>${requestScope.user.uname}:您的简历如下 </h1></font>
			<table bgcolor="AliceBlue" border="1">
				<tr>
					<td align="left">姓名</td>
					<td>
					${requestScope.resume.rname }
					</td>
				</tr>
				<tr>
					<td align="left">性别</td>
					<td>
						${requestScope.resume.gender}
						
					</td>
				</tr>
				<tr>
					<td align="left">年龄</td>
					<td>${requestScope.resume.rage }</td>
				</tr>
				<tr>
					<td align="left">学历</td>
					<td>${requestScope.resume.reducation }</td>
				</tr>
				<tr>
					<td align="left">联系方式</td>
					<td>${requestScope.resume.rphone }</td>
				</tr>
				<tr>
					<td align="left">e-mail</td>
					<td>${requestScope.resume.remail }</td>
				</tr>
				<tr>
					<td align="left">应聘岗位</td>
					<td>${requestScope.resume.rename }</td>
				</tr>
				<tr>
					<td align="left">政治面貌</td>
					<td>${requestScope.resume.sface }</td>
				</tr>
				<tr>
					<td align="left">上份工作</td>
					<td>${requestScope.resume.lastwork }</td>
				</tr>
				<tr>
					<td align="left">工作经验</td>
					<td>${requestScope.resume.workexperience }</td>
				</tr>
				<tr>
					<td align="left">期望薪资</td>
					<td>${requestScope.resume.salary }</td>
				</tr>
				
				<tr>
					<td align="left">兴趣爱好</td>
					<td>${requestScope.resume.hobby }</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a href="${pageContext.request.contextPath}/user/returnEmployee?name=${requestScope.user.uname}">返回</a></td>
				</tr>
			</table>
	</center>

</body>
</html>