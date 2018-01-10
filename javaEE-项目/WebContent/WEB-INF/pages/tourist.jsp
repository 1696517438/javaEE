<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游客操作界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		
	$(function(){
		var name = ${requestScope.user.uname};
		$.ajax({
			url:"${pageContext.request.contextPath}/user/queryMes",
			type:"post",
			datetype:"text",
			data:{name:name},
			success:function(data){
				if(data==1){
					alert("您有新的消息，请在我的消息中查看")
				}else{
					alert("暂时没有新的消息");
				}
			}
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
	a{
	text-decoration: none;
	margin-top:50%;
	}
	#one, #three{
		margin-left: 50px;
	}
	#updatepwd{
		background-color: AliceBlue;
		width:250px;
		margin-left: 250px;
		margin-top: -300px;
	}
	a:hover{
     color: red;
    }
    
   #show{
   	margin-left: 300px;
   	margin-top: -400px;
   }
</style>
</head>
<body style="background: url(${pageContext.request.contextPath}/images/magin.jpg" >
 <font color="orange"><h3>游客：${requestScope.user.uname} </h3></font>
	 <div id="one">
	 	<a href="${pageContext.request.contextPath}/resume/addResumes?name=${requestScope.user.uname}">
	 		<img src="../images/2.gif"  height="80px" width="80px">
	 	</a>
 	</div><br/>
 	
 <div id="two">
	 <a href="${pageContext.request.contextPath}/recruit/queryAllRecruit?name1=${requestScope.user.uname}">
	 	<img src="../images/3.gif"  height="80px" width="80px">
	 </a>
 </div><br/>
 
  <div id="three">
  	<a href="${pageContext.request.contextPath}/recruit/queryAllMesage?name=${requestScope.user.uname}">
  		<img src="../images/4.gif"  height="80px" width="80px">
  	</a>
  </div><br/>
  <div id="four">
	  <a href="${pageContext.request.contextPath}/user/GotoUpdate?name=${requestScope.user.uname}">
	  	<img src="../images/6.gif"  height="80px" width="80px">
	  </a>
  </div><br/>
  
  <div id="exit">
	 	<a href="${pageContext.request.contextPath }/user/returnIndex" id="bt">
	 		<img src="../images/d-3.gif"  height="80px" width="80px">
	 	</a>
 	</div>
  
  
  
  

  <c:if test="${!empty requestScope.mesage }">
 	<div id="show">
	  	 <table style="color: blue" border="1">
	  		<tr>
		  		<td>投递时间</td>
		  		<td>是否查看</td>
		  		<td>面试时间</td>
		  		<td>是否录用</td>		
		  	</tr>
		  	<c:forEach items="${requestScope.mesage  }" var="mes">
		  		<tr>
			  		<td>
			  			<f:formatDate value="${mes.apply.sendTime }" pattern="yyyy-MM-dd"/>
			  		</td>
			  		<td>${mes.apply.status }</td>
			  		 <td>
			  		 <f:formatDate value="${mes.interviewTime}" pattern="yyyy-MM-dd"/>
			  		</td> 
			  		<td>${mes.isEmploy }</td>	
			  	</tr>
		  	</c:forEach>
	  	</table>
  	</div>
  </c:if>  

</body>
</html>