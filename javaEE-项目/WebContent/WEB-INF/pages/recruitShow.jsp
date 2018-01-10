<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘信息</title>
<style type="text/css">
	a{
	text-decoration: none;
	color: red
	}
	a:hover{
     color: orange;
    }
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("a[name='bt']").click(function(){
		var id = $(this).prev().val();
		var result = confirm("确认删掉这条招聘信息吗？");
		var table=$(this).parent().parent().parent();
		if(result){
			$.post("${pageContext.request.contextPath}/recruit/delRecruit",{id:id},function(data){
				if(data==1){
					alert("删除成功")
					table.remove;
				}else{
					alert("删除失败")
				}
			})
			
		}
	})
	return false;
})
</script>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/bg.jpg)">
<font color="orange"><h3>管理员：${requestScope.user.uname}</h3></font>
<c:forEach items="${requestScope.recruit }" var="recruit">
	<form action="${pageContext.request.contextPath}/recruit/updateRecruit" method="post">
		<table style="color: yellow">
			<tr>
				<td align="left">公司名字</td>
				<td align="left">
				<input type="text" required name="rname" value="${recruit.name }">
				<input type="hidden" name="name" value="${requestScope.user.uname}">
				<input type="hidden" name="id" value="${recruit.id }">
				</td>
			</tr>
			
			<tr>
				<td align="left">职位</td>
				<td align="left">
				<input type="text" required name="positions" value="${recruit.positions }">
				
				</td>
			</tr>
			<tr>
				<td align="left">工作经验</td>
				<td align="left">
				
				<input type="text" required name="workexperience" value="${recruit.workexperience }">
				</td>
			</tr>
			
			<tr>
				<td align="left">学历</td>
				<td align="left">
				<input type="text" required name="diploma" value="${recruit.diploma }">
				</td>
			</tr>
			<tr>
				<td align="left">公司要求</td>
				<td align="left">
				<textarea rows="5px" cols="23px" name="requires" required style="resize: none">${recruit.requires }</textarea>
				</td>
			</tr>
			<tr>
				<td align="left">工资待遇</td>
				<td align="left">
				<input type="text" required name="salary" value="${recruit.salary }">
				</td>
			</tr>
			<tr>
				<td align="left">职位描述</td>
				<td align="left">
				<textarea rows="5px" cols="23px" name="describes" required style="resize: none">${recruit.describes }</textarea>
				</td>
			</tr>
			<tr>
					<td colspan="2">
					<input type="submit" value="保存">
					</td>
				</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" value="${recruit.id }">
					<a href="#" name="bt">删除</a>
					<a href="${pageContext.request.contextPath}/recruit/retunAddRecruit?name=${requestScope.user.uname}">返回</a>
				</td>
			</tr>
		</table>
	</form>
	<hr color="white">
</c:forEach>
</body>
</html>