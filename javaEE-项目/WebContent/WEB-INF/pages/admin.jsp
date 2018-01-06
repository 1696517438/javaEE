<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">

$(function(){
	 $("a[name='del']").click(function(){		
		var name=$(this).parent().prev().prev().prev().prev().prev().prev().text();
		var id=$(this).parent().prev().prev().prev().prev().prev().prev().prev().text();
		var tr = $(this).parent().parent();
		result=confirm("确定要删除"+name+"信息吗？")
		if(result){
			$.ajax({
				url:"${pageContext.request.contextPath}/department/delApply",
				type:"post",
				datetype:"text",
				data:{"del":id},
				success:function(data){
					if(data==1){
						tr.remove
					}else{
						alert("删除失败");
					}
				}
			})
		}
	})
	return false; 
})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
<style type="text/css">
	a{
	text-decoration: none;
	color: red;
	}
	a:hover{
     color: blue;
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
	#three{
		margin-top: 40px;
		margin-left: 20px;
	}
	#four{
		margin-top: 20px;
		margin-left: 0px;
	}
	#apply{
		margin-top: -200px;
		margin-left: 200px;
	}
	#resume{
		margin-left: 230px;
		margin-top: -200px;
	}
	a:hover{
     color: orange;
    }
</style>

</head>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
	<font color="orange"><h3>管理员：${requestScope.user.uname} </h3></font>
	<div id="one">
		<a href="${pageContext.request.contextPath}/department/queryAllDept?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/queryAllDept.gif"  height="80px" width="80px">	
		</a>
	</div>
	<div id="two">
		<a href="${pageContext.request.contextPath}/department/addDept?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/addDept.gif"  height="80px" width="80px">	
		</a>
	</div>
	
	<div id="three">
		<a href="${pageContext.request.contextPath}/department/showApply?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/showApply.gif"  height="80px" width="80px">	
		</a>
	</div>
	
	<div id="four">
		<a href="${pageContext.request.contextPath}/department/showApply?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/9.gif"  height="80px" width="80px">	
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
	
	
	
	
	
	
	
<c:if test="${!empty requestScope.apply}">
	<div id="apply">
		<table cellpadding="10" cellspacing="0" style="color: white">
			<tr>
				<td>序号</td>
				<td>应聘者</td>
				<td>投递时间</td>
				<td>查看状态</td>
				<td>面试状态</td>
				<td>面试职位</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.apply}" var="apply">
				<tr>
					<td>${apply.id }</td>
					<td>${apply.uname }</td>
					<td>
						<f:formatDate value="${apply.sendTime }" pattern="yyyy-MM-dd"/>
					</td>
					<td>${apply.status}</td>
					<td>${apply.interviewStatus }</td>
					<td>${apply.post }</td>
					<td><a href="${pageContext.request.contextPath}/department/LookResume?name=${requestScope.user.uname}&uname=${apply.uname }&postname=${apply.post }">查看</a></td>
					<td><a href="#" name="del">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	
	<c:if test="${!empty requestScope.resume}">
		<div id="resume">
			<table bgcolor="Aquamarine" style="color: blue">
					<tr>
						<td align="left">姓名</td>
						<td>
							${requestScope.resume.rname}
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
						<td>${requestScope.resume.remail}</td>
					</tr>
					<tr>
						<td align="left">应聘岗位</td>
						<td>${requestScope.resume.rename }</td>
					</tr>
					<tr>
						<td align="left">政治面貌</td>
						<td>${requestScope.resume.sface }"</td>
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
						<td>${requestScope.resume.salary}</td>
					</tr>
					
					<tr>
						<td align="left">兴趣爱好</td>
						<td>${requestScope.resume.hobby }</td>
					</tr>
					<tr>
						<td align="center"><a>面试</a></td>
						<td align="center"><a href="${pageContext.request.contextPath}/department/returnShowApply?name=${requestScope.user.uname}">返回</a></td>
					</tr>
				</table>
			</div>
		</c:if>
	
</body>
</html>