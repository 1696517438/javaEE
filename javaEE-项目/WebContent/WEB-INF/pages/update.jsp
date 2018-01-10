<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
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
		var pwd = $("#old").val();
		var name =$("#name").val();
		 $.post("${pageContext.request.contextPath}/user/queryUserByNameAndName",{uname:name,password:pwd},function(data){
			if(data == 0){
				 $("#va").text("旧密码输入不正确");
				 $("#old").val("");
			}else{
				$("#va").text("");
			}
		})
	})
	return false;
})
	</script>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/timg.gif)">
<center>
	<form action="${pageContext.request.contextPath}/user/updateUserPassword" method="post">
  		<table>
  			<tr>
  				<td align="left">原密码</td>
  				<td align="left">
  					<input type="hidden" value="${requestScope.user.uname}" id="name" name="updatename">
  					<input type="password" id="old" required name="uname"><font color="red"><span id="va"></span></font>
  				</td>
  			</tr>
  			<tr>
  				<td align="left">新密码</td>
  				<td><input type="password" required name="upassword" id="pass"></td>
  			</tr>
  			<tr>
  				<td align="left">确认密码</td>
  				<td>
  					<input type="password" required id="pwd">
					<font color="red"><span id="val"></span></font>
				</td>
  			</tr>
  			<tr>
  				<td colspan="2" align="center"><input type="submit" value="提交" id="sb"></td>
  			</tr>
  		</table>
  	</form>
</center>
</body>
</html>