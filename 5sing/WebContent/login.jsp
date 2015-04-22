<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<link href="style/login.css" type="text/css" rel="stylesheet" />
<script>
	function Change(ID1,ID2){
		document.getElementById(ID1).style.display="block";
		document.getElementById(ID2).style.display="none";
		}
	function submitForm1(){
		document.getElementById('sub1').submit();}
	function submitForm2(){
		document.getElementById('sub2').submit();}
	function isUname(){
		var uname=document.getElementById("uname").value;
		if(uname.length==0){
			return false;
			}else{
				return true;
				}
		}
	function isUpass(){
		var upass=document.getElementById("upass").value;
		if(upass.length==0){
			return false;
			}else{
				return true;
				}
		}
	function isMname(){
		var mname=document.getElementById("mname").value;
		if(mname.length==0){
			return false;
			}else{
				return true;
				}
		}
	function isMpass(){
		var mpass=document.getElementById("mpass").value;
		if(mpass.length==0){
			return false;
			}else{
				return true;
				}
		}
	function isUser(){
		if(isUname()==false){
			return false;
		}else if(isUpass()==false){
			return false;
		}
		return true;
		}
		function isManger(){
		if(isMname()==false){
			return false;
		}else if(isMpass()==false){
			return false;
		}
		return true;
		}
</script>
</head>
<body>
	<div class="header">
		<a href="index.jsp"><img src="images/logo.png" class="login" /></a>
	</div>
	<div class="center">
		<div class="content">
			<div class="content_left" name="user"
				onClick="Change('user','manager')" align="center">
				<br /><div class="top_font">用户登录</div>
			</div>
			<div class="content_right" name="manager"
				onClick="Change('manager','user')" align="center">
				<br /><div class="top_font">管理员登录</div>
			</div>
			<div id="user">
				<form action="UserLogin" method="post" name="f1"
					onSubmit="return isUser()">
					<table align="center">
						&nbsp;
						<tr>
							<td class="yong">用户账号：</td>
							<td><input type="text" name="uaccount" id="uname" class="uaccount"></td>
						</tr>
						&nbsp;&nbsp;
						<tr>
							<td class="yong">
								<p>用户密码：</p>
							</td>
							<td><input type="password" name="upass" id="upass" class="uaccount"></td>
						</tr>
						<tr>
							<td><input type="checkbox" name="issave" id="issave"><span
								class="issave yong">记住我</span></td>
							<td align="right"><a href="###" class="forget"
								title="忘记密码"> 忘记密码</a></td>
						</tr>
						<tr>
							<!-- <input type="submit" id="sub1" hidden="true" /> -->
							<td align="center"><button class="log_1">登&nbsp;&nbsp;陆</button></td>

							<td align="right"><a class="reg" href="register.jsp"
								title="注册">注册</a></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="manager" style="display: none">
				<form action="ManagerLoginServlet" method="post" name="f1"
					onSubmit="return isManager()">
					<table align="center">
						&nbsp;
						<tr>
							<td class="yong">管理员账号：</td>
							<td><input type="text" name="mname" id="mname" class="uaccount"></td>
						</tr>
						&nbsp;&nbsp;
						<tr>
							<td class="yong">
								<p>管理员密码：</p>
							</td>
							<td><input type="password" name="mpass" id="mpass" class="uaccount"></td>
						</tr>
						<tr>
							<td><input type="checkbox" name="issave" id="issave"><span
								class="issave yong">记住我</span></td>
							<td align="right"><a href="/getpass/" class="forget1"
								title="忘记密码"> 忘记密码</a></td>
						</tr>
						<tr>

							<td align="center"><button class="log_2">登&nbsp;&nbsp;陆</button></td>
							<!-- <input type="submit" id="sub2" hidden="true" /> -->
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="bottom">
		<h3 class="return ">
			<a href="" class="return1">&lt;&lt;返回首页</a>
		</h3>
	</div>
</body>
</html>
<c:if test="${param.msg!=null&&param.msg!='null'}">
	<script>alert("${param.msg}")</script>
</c:if>
<c:if test="${param.mm!=null}">
	<c:if test="${param.mm==1}">
		<script>alert("请先登陆！")</script>
	</c:if>
	<c:if test="${param.mm==2}">
		<script>alert("用户已经在线！")</script>
	</c:if>
	<c:if test="${param.mm==3}">
		<script>alert("用户名或密码错误！")</script>
	</c:if>
	<c:if test="${param.mm==4}">
		<script>alert("该用户已被锁定！")</script>
	</c:if>
</c:if>