<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加部门和职位页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function showHideText(){
	  document.getElementById("div_text").className="div_show";
	}
	function showHideText1(){
		  document.getElementById("div_text1").className="div_show";
		}
	$(function(){
		$("#button").click(function(){
			var name=$(":input[name='deptName']").val();
			$.post("${pageContext.request.contextPath}/department/addDepartment",{dname:name},function(data){
				if(data == 1){
					alert("添加成功");
				}else{
					alert("该部门已经存在了");
				}
			})
		})
	})
	
	$(function(){
		$("#bt").click(function(){
			var name=$(":input[name='postname']").val();
			var id=$("select[name='deptId']").val();
			alert(name);
		    alert(id); 
			$.post("${pageContext.request.contextPath}/department/addPost",{pname:name,pid:id},function(data){
				alert(data);
				if(data == 1){
					alert("保存成功");
				}else{
					alert("该部门已存在此职位");
				}
			})
		})
	})
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
.div_hide1 
{
   display:none;
}
a{
	text-decoration: none;
}
a:hover{
     color: red;
    }
</style>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)">
	<a href="javaScript:showHideText()">添加部门</a>
	<div id="div_text" class="div_hide">
		<form action="javaScript:void(0)" method="post">
			<table>
				<tr>
					<td>部门名字:</td>
					<td><input type="text" required name="deptName"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="保存" id="button"></td>
				</tr>
			</table>
		</form>
	</div>
	<br/>
	<a href="javaScript:showHideText1()">添加部门职位</a>
	<div id="div_text1" class="div_hide1">
		<form action="javaScript:void(0)" method="post">
			<table>
				<tr>
					<td>选择部门</td>
					<td>
					<select name="deptId">
						<c:forEach items="${requestScope.department }" var="department">
							<option value="${department.did }">${department.dname }</option>
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>添加职位的名称</td>
					<td>
						<input type="text" required name="postname">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="保存" id="bt"></td>
				</tr>
			</table>
		</form>
	</div>
	<br/>
	<a href="${pageContext.request.contextPath}/department/returnAdmin?name=${requestScope.user.uname}">返回</a>
</body>
</html>