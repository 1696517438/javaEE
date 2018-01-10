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

	function showHideText(){
	  document.getElementById("div_mianshi_hide").className="div_show";
	}
	
	function showHideTextMes(){
		  document.getElementById("award_hide").className="div_show";
		}
	$(function(){
		$("#bt").change(function(){
			var mydate=new Date();
			var str = "" + mydate.getFullYear() + "-";
		    str += (mydate.getMonth()+1) + "-";
		    str += mydate.getDate();
		   
			var time = $(":input[name='time']").val();
			var taday=new Date(str.replace("-","/").replace("-","/"));
			var times = new Date(time.replace("-","/").replace("-","/"));
			
			if(times<taday){
				alert("该日期过期了,请重新输入");
				$(":input[name='time']").val("");
				return false;
			}else{
				alert("输入正确");
				return true;
			}
		})
		
	})
	$(function(){
			$("#bts").click(function(){
				var result = confirm("确定退出吗？");
				if(!result){
					return false;
				}
			})
		})
		$(function(){
			$("#send").click(function(){
				var mydate=new Date();
				var str = mydate.getDate();
				if(str > 15){
					alert("发放成功");
				}else{
					alert("15号之后才能发工资");
				}
			})
		})
		
		$(function(){
		$("select[name='dept']").change(function(){
			var val = $("#department").val();
			 $.post("${pageContext.request.contextPath}/employee/updateDept",{id:val},function(date){
				var a = date.split(",");
				var postname = $("#postname");
				postname.attr("disabled",false);
				for (var i = 0; i < a.length; i++) {
					postname.append("<option >"+a[i]+"</option>");
				}
			})
		})
	})
	$(function(){
		$("#dei_mep").click(function(){
			var name = $(this).prev().val();
			var tr = $(this).parent().parent();
			if(confirm("确定开除"+name+"吗？"))
			 $.post("${pageContext.request.contextPath}/employee/delEmpByName",{name:name},function(date){
				if(date == 1){
					tr.remove
					
					alert("删除成功");
				}else{
					alert("删除失败");
				}
			})
			return false;
		})
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
	#exit{
		margin-top: 230px;
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
.div_show
{
   display:block;
}
.div_mianshi
{
   display:none;
}
.award{
   display:none;
}
#five{
	margin-left: 210px;
	margin-top: -290px;
}
#queryEmp{
	margin-left: 210px;
	margin-top: -290px;
}
#employeeMes{
	margin-left: 210px;
	margin-top: -290px;
 }
 #transfer{
 	border:1px solid #FFFFFF;
 	width: 300px;
	margin-left: 210px;
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
		<a href="${pageContext.request.contextPath}/recruit/addrecruit?name=${requestScope.user.uname}" >
			<img src="${pageContext.request.contextPath}/images/9.gif"  height="80px" width="80px">	
		</a>
	</div>
	
	<div id="five">
	 	<a href="${pageContext.request.contextPath}/employee/queryAllEmployee?name=${requestScope.user.uname}">
	 		<img src="../images/a-1.gif"  height="80px" width="80px">
	 	</a>
 	</div>
 	
	<div id="exit">
	 	<a href="${pageContext.request.contextPath }/user/returnIndex" id="bts">
	 		<img src="../images/d-3.gif"  height="80px" width="80px">
	 	</a>
 	</div>
 	
	
	
	
	
	
	
	
	
	
	
	
	<c:if test="${!empty requestScope.employeeMes}">
		<div id="employeeMes">
			<table border="1" style="color:white">
					<tr>
						<td>名字</td>
						<td>${requestScope.employeeMes.ename}</td>
					</tr>
					<tr>
						<td>性别</td>
						<td>${requestScope.employeeMes.egender}</td>
					</tr>
					<tr>
						<td>年龄</td>
						<td>${requestScope.employeeMes.age}</td>
					</tr>
					<tr>
						<td>学历</td>
						<td>${requestScope.employeeMes.education}</td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td>${requestScope.employeeMes.phone}</td>
					</tr>
					<tr>
						<td>电子邮箱</td>
						<td>${requestScope.employeeMes.email}</td>
					</tr>
					<tr>
						<td>入职时间</td>
						<td>
						<f:formatDate value="${requestScope.employeeMes.cometime}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
					<tr>
						<td>政治面貌</td>
						<td>${requestScope.employeeMes.sface}</td>
					</tr>
					
					<tr>
						<td>爱好</td>
						<td>${requestScope.employeeMes.hobby}</td>
					</tr>
					<tr>
						<td>职位</td>
						<td>${requestScope.employeeMes.rename}</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<a href="javaScript:showHideTextMes()">奖赏</a>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="award_hide" class="award">
								<center>奖赏</center>
								<form action="">
									原由:<input type="text" required name="reason"><br/>
									奖金:<input type="number" required name="amount"><br/>
									时间:<br/>
									<input type="date" required name="awardTime"><br/><br/>
									<input type="submit" value="确认">
								</form>
							</div>
						</td>
					</tr>
				</table>
		</div>
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
	
	<c:if test="${!empty requestScope.employee}">
		<div id="queryEmp">
			<table border="1">
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td colspan="4" align="center">操作</td>
				</tr>
				<c:forEach items="${requestScope.employee }" var="emp">
					<tr>
						<td>${emp.eid }</td>
						<td><a href="${pageContext.request.contextPath }/employee/findEmpById?id=${emp.eid }&name=${requestScope.user.uname}">${emp.ename }</a></td>
						<td><a href="${pageContext.request.contextPath }/employee/queryAlldept?name=${requestScope.user.uname}&ename=${emp.ename }" >人事调动</a></td>
						<td><a href="#">考勤</a></td>
						<td><a href="#" id="send">工资发放</a></td>
						<td>
						<input type="hidden" value="${emp.ename }">
						<a href="#" id="dei_mep">开除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<c:if test="${!empty requestScope.departments}">
		<div id="transfer">
			<center>请选择调动的部门职位</center>
			<center>调动人:${requestScope.ename}</center>
			<form action="${pageContext.request.contextPath }/employee/updateEmp",method="post">
				<select name="dept" id="department">
				<option >选择部门</option>
					<c:forEach items="${requestScope.departments}" var="dempt">
						<option value="${dempt.did }">${dempt.dname }</option>
					</c:forEach>
				</select>
				
				<select id="postname" disabled="disabled" name="post">
				<option >选择部门职位</option>
				</select>
				<input type="hidden" value="${requestScope.user.uname}" name="name">
				<input type="hidden" value="${requestScope.ename}" name="ename">
				<input type="submit" value="确认" id="dept_bt">
			</form>
		</div>
	</c:if>
	
	
	
	
	
	
	
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
						<td align="center"><a href="javaScript:showHideText()">面试</a></td>
						<td align="center"><a href="${pageContext.request.contextPath}/department/returnShowApply?name=${requestScope.user.uname}">返回</a></td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="div_mianshi_hide" class="div_mianshi">
								<form action="${pageContext.request.contextPath}/department/addMesage" method="post">
									<input type="date" required name="time" id="bt">
									<input type="hidden" name="name" value="${requestScope.user.uname}">
									<input type="hidden" name="id" value="${requestScope.apply1.id}">
									<input type="submit" value="确认" >
								</form>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</c:if>
	
</body>
</html>