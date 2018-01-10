<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人力资源—操作界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function showHideText(){
		  document.getElementById("div_text").className="div_show";
		  document.getElementById("div_text1").className="div_show";
		}
		$(function(){
			$("#get").click(function(){
				var uname=$(":input[name='uname']").val();
				var postname=$(":input[name='postname']").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/user/updateType",
					type:"post",
					datetype:"text",
					data:{name:uname,postname:postname},
					success:function(data){
						if(data==1){
							alert("录用成功");
						}else if(data == 2){
							alert("重复录用");
						}else{
							alert("录用失败");	
						}
					}
				})
			})
		})
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
#one,#two,#three{
	float: left;
	margin-left: 100px;
	margin-top: 20px;
}

.div_show
{
   display:block;
}
.div_hide 
	{
   display:none;
}
a{
text-decoration: none;
color:red;
}
a:hover{
	color: white;
}
#div_text,#div_text1{
	margin-left:100px;
	margin-top: 120px;
}
#face_mesage{
	margin-left:100px;
	margin-top: 120px;
}
#resume{
	margin-left: 200px;
	margin-top: 150px;
}
</style>
</head>
<font color="orange"><h3>用户：${requestScope.user.uname} </h3></font>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
	<div id="one">
	 	<a href="javaScript:showHideText()">
	 		<img src="../images/d-1.gif"  height="80px" width="80px">
	 	</a>
 	</div>
 	<div id="two">
	 	<a href="#">
	 		<img src="../images/d-2.gif"  height="80px" width="80px">
	 	</a>
 	</div>
 	<div id="three">
	 	<a href="${pageContext.request.contextPath }/user/returnIndex" id="bt">
	 		<img src="../images/d-3.gif"  height="80px" width="80px">
	 	</a>
 	</div>


	<div id="div_text" class="div_hide">
		<a href="${pageContext.request.contextPath}/recruit/querySomeMes?name=${requestScope.user.uname}">面试通知</a>
	</div>
	<div id="div_text1" class="div_hide">
		<a href="#">培训通知</a>
	</div>
	<c:if test="${!empty requestScope.mesage }">
		<div id="face_mesage">
			<table style="color: white">
				<tr>
					<td>面试者</td>
					<td>面试时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${requestScope.mesage }" var="mesage">
					<tr>
						<td>${mesage.apply.uname}</td>
						<td>
						<f:formatDate value="${mesage.interviewTime }" pattern="yyyy-MM-dd"/>
						</td>
						<td><a href="${pageContext.request.contextPath}/department/queryResume?name=${requestScope.user.uname}&uname=${mesage.apply.uname}">面试</a></td>
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
						<input type="hidden" name="uname" value="${requestScope.user1.uname }">
						<input type="hidden" name="postname" value="${requestScope.resume.rename }">
						<td align="center"><a href="#" id="get">录用</a></td>
						<td align="center"><a href="${pageContext.request.contextPath}/user/returnDmanager?name=${requestScope.user.uname}">返回</a></td>
					</tr>
				</table>
			</div>
		</c:if>
</body>
</html>