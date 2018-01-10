<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员添加招聘信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function showHideText(){
	  document.getElementById("div_text").className="div_show";
	}
</script>
<style type="text/css">
.div_show
{
   display:block;
}
.div_hide 
{
   display:none;
}
	a:hover{
     color: orange;
    }
   a{
	text-decoration: none;
	color: red;
	}
</style>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)">
<font color="orange"><h3>管理员：${requestScope.user.uname} </h3></font>
	<a href="javaScript:showHideText()">添加招聘信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/recruit/showAllRecruit?name=${requestScope.user.uname}">查看所有的招聘信息</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/department/returnAdmin?name=${requestScope.user.uname}">返回</a>
	<div id="div_text" class="div_hide">
		<form action="${pageContext.request.contextPath}/recruit/addRecruit" method="post">
			<table bgcolor="AliceBlue">
				<tr>
					<td>公司名字</td>
					<td>
					<input type="text" required name="rname">
					<input type="hidden" name="uname" value="${requestScope.user.uname}">
					</td>
				</tr>
				<tr>
					<td>职位</td>
					<td><input type="text" required name="positions"></td>
				</tr>
				<tr>
					<td>工作经验</td>
					<td><input type="text" required name="workexperience"></td>
				</tr>
				<tr>
					<td>学历</td>
					<td><input type="text" required name="diploma"></td>
				</tr>
				<tr>
					<td>公司要求</td>
					<td><textarea rows="5px" cols="23px" name="requires" required style="resize: none"></textarea></td>
				</tr>
				<tr>
					<td>薪资待遇</td>
					<td><input type="text" required name="salary"></td>
				</tr>
				<tr>
					<td>职位描述</td>
					<td><textarea rows="5px" cols="23px" name="describes" required style="resize: none"></textarea></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="发布">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>