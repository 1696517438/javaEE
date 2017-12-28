<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		 $("a[name='del']").click(function(){		
			var name=$(this).parent().prev().prev().prev().prev().prev().text();
			var sId=$(this).parent().prev().prev().prev().prev().prev().prev().text();
			var tr = $(this).parent().parent();
			result=confirm("确定要删除"+name+"信息吗？")
			if(result){
				$.ajax({
					url:"${pageContext.request.contextPath}/delStudent",
					type:"post",
					datetype:"text",
					data:{"del":sId},
					success:function(data){
						if(data==1){
							tr.remove
						}else{
							alert("删除失败");
						}
					}
				})
			}
			
			/* $.post("delStudent",{"del":sId},function(data){
				alert(data);
				//location.reload();
				if(data==1){
					tr.remove
				}else{
					alert("删除失败");
				}
			}) */
		})
		return false; 
	})
	$(function(){
		$("select[name='lession']").change(function(){
			var val = $("#sele").val();
			alert(val);
			$.post("${pageContext.request.contextPath}/getStudentName",{id:val},function(date){
				var a = date.split(",");
				var student = $("#student");
				student.empty();
				student.attr("disabled",false);
				for (var i = 0; i < a.length; i++) {
					student.append("<option >"+a[i]+"</option>");
				}
			})
		})
	})
	
</script>
<title>show</title>
</head>
<body>
WELCOME
<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>password</td>
		<td>age</td>
		<td>createDate</td>
		<td>lesson</td>
		<td>operation</td>
	</tr>
	<c:forEach items="${requestScope.students }" var="studnets">
		<tr>
			<td>${studnets.sId }</td>
			<td>${studnets.sName }</td>
			<td>${studnets.sPassword }</td>
			<td>${studnets.sAge }</td>
			<td>${studnets.sCreateDate }</td>
			<td>${studnets.subject.jName }</td>
			<td><a href="" name="del">删除</a>
			<a href="${pageContext.request.contextPath}/updateStudent?id=${studnets.sId }">修改</a></td>
		</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/addStudent">添加</a>

<br/>二级联动
	<select name="lession" id="sele">
	<option ></option>
		<c:forEach items="${requestScope.subject }" var="subject">
			<option value="${subject.jId }">${subject.jName }</option>
		</c:forEach>
	</select>
	
	<select id="student" disabled="disabled">
		<option ></option>
	</select>
</body>
</html>