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
$(function(){
	$("#card_play").click(function(){
		var name = ${requestScope.user.uname}
		$.ajax({
			url:"${pageContext.request.contextPath}/employee/queryCard",
			type:"post",
			data:{name:name},
			datatype:"text",
			success:function(data){
				if(data == 1){
					alert("打卡成功");
				}else if(data == 2){
					alert("您今天打过卡了");
				}
			}
		})
	})
})
$(function(){
	$("#closed_play").click(function(){
		
		var name = ${requestScope.user.uname}
		if(confirm("确定下班打卡吗？")){
			 $.ajax({
				url:"${pageContext.request.contextPath}/employee/updateCard",
				type:"post",
				data:{name:name},
				datatype:"text",
				success:function(data){
					if(data == 1){
						alert("下班打卡成功");
					}else if(data == 2){
						alert("早退打卡成功");
					}else if(data == 3){
						alert("旷工打卡成功");
					}
				}
			})
		}
		return false;
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
	#three{
		margin-top: 20px;
	}
	#four{
		margin-top: 20px;
		margin-left: 20px;
		}
	#Mymesage{
		margin-left: 200px;
		margin-top: -300px;
	}
	#updatepwd{
		margin-left: 200px;
		margin-top: -300px;
	}
	#exit{
	margin-top: 20px;
	}
	#e_dept{
		margin-left: 200px;
		margin-top: -300px;
	}
	#e_post{
		margin-left: 300px;
		margin-top: -120px;
	}
	#e_push{
		margin-left: 250px;
		margin-top: -300px;
	}
	
</style>

</head>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
	<center>
		<font color="orange"><h3>您好：${requestScope.user.uname}
		 <a href="#" id="card_play">上班打卡</a>
		 &nbsp;&nbsp;&nbsp;
		 <a href="#" id="closed_play">下班打卡</a></h3></font>
	</center>
	<div id="one">
		<a href="${pageContext.request.contextPath}/employee/queryEmployeeByname?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/e-1.gif"  height="80px" width="80px">	
		</a>
	</div>
	
	
	  <div id="two">
	  <a href="${pageContext.request.contextPath}/user/GotoUpdate?name=${requestScope.user.uname}">
	  	<img src="../images/6.gif"  height="80px" width="80px">
	  </a>
  </div>
  
  <div id="three">
		<a href="${pageContext.request.contextPath}/employee/queryDept?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/e-2.gif"  height="80px" width="80px">	
		</a>
	</div>
	
	 <div id="four">
		<a href="${pageContext.request.contextPath}/employee/queryPushCard?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/e-3.gif"  height="80px" width="80px">	
		</a>
	</div>
	
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
	
	<c:if test="${!empty requestScope.departments}">
		<div id="e_dept">
			部门
			<table>
				<c:forEach items="${requestScope.departments}" var="dept">
					<tr>
						<td><a href="${pageContext.request.contextPath }/employee/queryPost?name=${requestScope.user.uname}&dname=${dept.dname}">${dept.dname }</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	
	<c:if test="${!empty requestScope.posts}">
		<div id="e_post">
			职位
			<table>
				<c:forEach items="${requestScope.posts}" var="post">
					<tr>
						<td>
							<font color="white">${post.pname }</font>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	
	<c:if test="${!empty requestScope.pushCard}">
		<div id="e_push">
			<form action="${pageContext.request.contextPath }/employee/findCard">
			<input type="hidden" name="name" value="${requestScope.user.uname}">
				<select name="year">
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
				</select>
				<select name="month">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
				<input type="submit" value="确认查询">
			</form>
			<table border="1">
				<tr>
					<td>上班时间</td>
					<td>下班时间</td>
					<td>是否迟到</td>
					<td>是否早退</td>
				</tr>
				<c:forEach items="${requestScope.pushCard}" var="pushCard">
					<tr>
						<td>
							${pushCard.starttime }
						</td>
						<td>
							${pushCard.endtime }
						</td>
						<td>
							${pushCard.islate }
						</td>
						<td>
							${pushCard.isearly }
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>