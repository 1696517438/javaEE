<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游客填写简历页面</title>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)">
游客：${requestScope.user.uname }
<c:if test="${requestScope.user.uresumeid == 0 }">
	<center>
		<font color="BlueViolet"><h1>请填写你的个性简历</h1></font>
		<form action="${pageContext.request.contextPath}/resume/addResumeSuccess" method="post">
			<table bgcolor="AliceBlue">
				<tr>
					<td align="left">姓名</td>
					<td>
					<input type="hidden" value="${requestScope.user.uname }" name="names">
					<input type="text" required name="uname">
					</td>
				</tr>
				<tr>
					<td align="left">性别</td>
					<td><input type="radio" name="gender" value="男">男
						<input type="radio" name="gender" value="女">女
					</td>
				</tr>
				<tr>
					<td align="left">年龄</td>
					<td><input type="number" required name="rage"></td>
				</tr>
				<tr>
					<td align="left">学历</td>
					<td><input type="text" required name="reducation"></td>
				</tr>
				<tr>
					<td align="left">联系方式</td>
					<td><input type="number" required name="phone"></td>
				</tr>
				<tr>
					<td align="left">e-mail</td>
					<td><input type="email" required name="email"></td>
				</tr>
				<tr>
					<td align="left">应聘岗位</td>
					<td><input type="text" required name="rename"></td>
				</tr>
				<tr>
					<td align="left">政治面貌</td>
					<td><input type="text" required name="sface"></td>
				</tr>
				<tr>
					<td align="left">上份工作</td>
					<td><input type="text" required name="lastwork"></td>
				</tr>
				<tr>
					<td align="left">工作经验</td>
					<td><input type="text" required name="workexperience"></td>
				</tr>
				<tr>
					<td align="left">期望薪资</td>
					<td><input type="text" required name="salary"></td>
				</tr>
				
				<tr>
					<td align="left">兴趣爱好</td>
					<td><input type="text" required name="hobby"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="保存"></td>
				</tr>
				
			</table>
		</form>	
	</center>
</c:if>

<c:if test="${requestScope.user.uresumeid != 0 }">
	<center>
		<font color="BlueViolet"><h1>修改你的个性简历</h1></font>
		<form action="${pageContext.request.contextPath}/resume/updateResume" method="post">
			<table bgcolor="AliceBlue">
				<tr>
					<td align="left">姓名</td>
					<td>
					<input type="hidden" name="rid" value="${requestScope.resume.rid }">
					<input type="hidden" value="${requestScope.user.uname }" name="names">
					<input type="text" required name="uname" value="${requestScope.resume.rname }">
					</td>
				</tr>
				<tr>
					<td align="left">性别</td>
					<td>
						<c:if test="${requestScope.resume.gender =='男' }">
							<input type="radio" name="gender" value="男" checked="checked">男
							<input type="radio" name="gender" value="女">女
						</c:if>
						<c:if test="${requestScope.resume.gender =='女' }">
							<input type="radio" name="gender" value="男" >男
							<input type="radio" name="gender" value="女" checked="checked">女
						</c:if>
					</td>
				</tr>
				<tr>
					<td align="left">年龄</td>
					<td><input type="number" required name="rage" value="${requestScope.resume.rage }"></td>
				</tr>
				<tr>
					<td align="left">学历</td>
					<td><input type="text" required name="reducation" value="${requestScope.resume.reducation }"></td>
				</tr>
				<tr>
					<td align="left">联系方式</td>
					<td><input type="number" required name="phone" value="${requestScope.resume.rphone }"></td>
				</tr>
				<tr>
					<td align="left">e-mail</td>
					<td><input type="email" required name="email" value="${requestScope.resume.remail }"></td>
				</tr>
				<tr>
					<td align="left">应聘岗位</td>
					<td><input type="text" required name="rename" value="${requestScope.resume.rename }"></td>
				</tr>
				<tr>
					<td align="left">政治面貌</td>
					<td><input type="text" required name="sface" value="${requestScope.resume.sface }"></td>
				</tr>
				<tr>
					<td align="left">上份工作</td>
					<td><input type="text" required name="lastwork" value="${requestScope.resume.lastwork }"></td>
				</tr>
				<tr>
					<td align="left">工作经验</td>
					<td><input type="text" required name="workexperience" value="${requestScope.resume.workexperience }"></td>
				</tr>
				<tr>
					<td align="left">期望薪资</td>
					<td><input type="text" required name="salary" value="${requestScope.resume.salary }"></td>
				</tr>
				
				<tr>
					<td align="left">兴趣爱好</td>
					<td><input type="text" required name="hobby" value="${requestScope.resume.hobby }"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="保存"></td>
				</tr>
			</table>
		</form>	
	</center>
</c:if>
</body>
</html>