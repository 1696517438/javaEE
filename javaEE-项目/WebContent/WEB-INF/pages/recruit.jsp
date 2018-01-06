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
	$("a[name='button']").click(function(){
		var name=$(this).prev().prev().val();
		var postname=$(this).prev().val();
		 $.post("${pageContext.request.contextPath}/recruit/queryRid",{uname:name,postname:postname},function(data){
			 alert(data);
			if(data == 0){
				 alert("您还未填写简历，不能投递");
			}else if(data==2){
				alert("您已经投递过了");
			}else{
				alert("投递成功");
			}
		})
	})
	return false;
})
</script>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/bg.jpg)">
<c:forEach items="${requestScope.recruit }" var="recruit">
	<table style="color: yellow">
		
		<tr>
			<td align="left">公司名字</td>
			<td align="left">${recruit.name }
			</td>
		</tr>
		
		<tr>
			<td align="left">职位</td>
			<td align="left">${recruit.positions }
			</td>
		</tr>
		<tr>
			<td align="left">工作经验</td>
			<td align="left">${recruit.workexperience }</td>
		</tr>
		
		<tr>
			<td align="left">学历</td>
			<td align="left">${recruit.diploma }</td>
		</tr>
		<tr>
			<td align="left">公司要求</td>
			<td align="left">${recruit.requires }</td>
		</tr>
		<tr>
			<td align="left">工资待遇</td>
			<td align="left">${recruit.salary }</td>
		</tr>
		<tr>
			<td align="left">职位描述</td>
			<td align="left">${recruit.describes }</td>
		</tr>
		<tr>
			<td colspan="2">
				<%-- <a href="${pageContext.request.contextPath}/recruit/queryRid?uname=${requestScope.user.uname }&post=${recruit.positions}" id="button">投递简历</a> --%>
				<input type="hidden" value="${requestScope.user.uname }">
				<input type="hidden" value="${recruit.positions }">
				<a href="#" name="button">投递简历</a>
				<a href="${pageContext.request.contextPath}/recruit/returnTourist?uname=${requestScope.user.uname }" >返回</a>
			</td>
		</tr>
	</table>
	<hr color="white">
</c:forEach>
</body>
</html>