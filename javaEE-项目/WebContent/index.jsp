<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入界面</title>
<style type="text/css">
	a{
	text-decoration: none;
	}
	.div_show
{
   display:block;
}
.div_hide
{
   display:none;
}
</style>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function showHideText(){
	  document.getElementById("div_text").className="div_show";
	}
	$(function(){
		$("#pwd").change(function(){
			var pass= $("#pass").val();
			var pwd= $("#pwd").val();
			if(pass!=pwd){
				$("#val").text("两次密码不匹配");
				$("#sb").attr("disabled",true);
			}else{
				$("#val").text("");
				$("#sb").attr("disabled",false);
			}
		})
	})
	$(function(){
		$(":input[name='uname']").change(function(){
			var name = $("#na").val();
			 $.post("${pageContext.request.contextPath}/user/queryUserByName",{uname:name},function(data){
				if(data == 1){
					 $("#va").text("用户已存在");
					 $("#na").val("");
				}else{
					$("#va").text("");
				}
			})
		})
		return false;
	})
</script>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/1.jpg)" >
	<center>
	<h1>登录</h1>
		<form action="${pageContext.request.contextPath}/user/loginSuccess" method="post">
			<table cellpadding="10" cellspacing="0">
				<tr>
					<td>账号</td>
					<td><input type="text" required name="name"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" required name="password" ></td>
				</tr>
					
				<tr>
					<td colspan="2" align="center"><font color="red">${requestScope.manges}</font></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="登录" style="width: 160px;background-color: blue" ></td>
				</tr>
			</table>
		</form>	
		<h3><a href="javaScript:showHideText()">游客注册</a></h3>
		<div id="div_text" class="div_hide">
			<form action="${pageContext.request.contextPath}/user/addUser" method="post">
			<table cellpadding="10" cellspacing="0">
				<tr>
					<td>账号</td>
					<td><input type="text" required name="uname" id="na"><font color="blue"><span id="va"></span></font></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" required name="upassword" id="pass"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" required id="pwd">
					<font color="red"><span id="val"></span></font>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交" id="sb"></td>
				</tr>
			</table>
		</form>	
		</div>
	</center>
</body>
</html>