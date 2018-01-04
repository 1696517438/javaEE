<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)" >
<center>
		<font color="BlueViolet"><h1>请填写你的个性简历</h1></font>
		<form action="" method="post">
			<table bgcolor="AliceBlue">
				<tr>
					<td align="left">姓名</td>
					<td><input type="text" required name="uname"></td>
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
					<td><input type="text" required name="phone"></td>
				</tr>
				<tr>
					<td align="left">e-mail</td>
					<td><input type="email" required name="email"></td>
				</tr>
				<tr>
					<td align="left">应聘岗位</td>
					<td>
						<select name="rename">
							<option value="部门">--部门--</option>
						</select>
						<select name="rename">
							<option value="--职位--">--职位--</option>
						</select>
					</td>
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
</body>
</html>