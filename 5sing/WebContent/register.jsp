<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>5sing 中国原创音乐基地 用户注册</title>
<link href="style/register.css" type="text/css" rel="stylesheet"/>
<script>
function isUser(){
	var va=document.getElementById("uaccount").value;
	if(va.length < 1 ){
		document.getElementById("msg").innerHTML="<span style='color:#ff0000'>请填写用户名！</span>";
		return false;
	}else{
		document.getElementById("msg").innerHTML="";
		return true;
	}	
}
function isPass1(){
	var va=document.getElementById("upass1").value;
	if(va.length == 0 ){
		document.getElementById("msg2").innerHTML="<span style='color:#ff0000'>请填写密码！</span>";
		return false;
	}
		if(va.length <6){
			document.getElementById("msg2").innerHTML="<span style='color:#ff0000'>密码大于6位，请重新填写密码！</span>";
			return false;	
	}else{
		document.getElementById("msg2").innerHTML="";
		return true;
	}	
}
//密码验证
function isPass2(){
	var upass1=document.getElementById("upass1").value;
	var upass2=document.getElementById("upass2").value;
	if(upass2.length == 0 ){
		document.getElementById("msg3").innerHTML="<span style='color:#ff0000'>请再次输入密码！</span>";
		return false;
	}
	if(upass1==upass2){
		document.getElementById("msg3").innerHTML="";
		return true;
		}else{
			document.getElementById("msg3").innerHTML="<span style='color:#ff0000'>两次输入密码不一致，请重新输入!</span>";
			return false;
			}	
}
//邮箱验证
function isMail(){
	var va=document.getElementById("uemail").value;
	var mail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
		if(!mail.test(va)){
		document.getElementById("msg4").innerHTML="<span style='color:#ff0000'>你的输入不正确，请重新输入！</span>";
		return false;
		}	
		if(va==""){
			document.getElementById("msg4").innerHTML="<span style='color:#ff0000'>请输入邮箱号！</span>";
			return false;
			}else{
	    	  <!-- document.getElementById("msg4").value="";-->
			   document.getElementById("msg4").innerHTML="<span style='color:#ff0000'></span>";
					return true;
		}
	}	

//电话验证
function isPhone(){
	var vaphone=document.getElementById("uphone").value;
	var  phone= /^(((13[0-9]{1})|134|135|136|137|138|139|150|151|152|157|158|159|183|153|187|188|130|131|132|155|156|185|186|)+\d{8})$/; 
	if(vaphone.length==0){
		document.getElementById("msg5").innerHTML="<span style='color:#ff0000'>请输入手机号！</span>";
		return false;
		}
	if(vaphone.length!==11){
		document.getElementById("msg5").innerHTML="<span style='color:#ff0000'>输入的手机位数不够！</span>";
		return false;
		}
    if(!phone.test(vaphone)){
		document.getElementById("msg5").innerHTML="<span style='color:#ff0000'>输入有效手机号！</span>";
		return false;		
	}else{
		document.getElementById("msg5").innerHTML="";
		return true;
	}	
	}	
function isAll(){
	if(isUser()==false){
		return false;
	}else if(isPass1()==false){
		return false;
	}else if(isPass2()==false){
		return false;
	}else if(isMail()==false){
		return false;
	}else if(isPhone()==false){
		return false;
	}else if(isChecked()==false){
		return false;
	}
	return true;
}


function isChecked(){
    if(document.getElementById("checked").checked == false){
    	document.getElementById("msg6").innerHTML="<span style='color:#ff0000'>同意协议才能注册！</span>";
       return false;
    }else{
    	document.getElementById("msg6").innerHTML="<span style='color:#ff0000'></span>";
    	return true;
    }
}
</script>
</head>
<body>
<div class="header"><img src="images/logo-reg.gif" class="logo"/></div>
<div class="center">
<div class="left"></div>
<div class="content">
<form action="Register" method="post" name="f1"  onsubmit="return isAll()">
<table width="531" border="0" align="center">
<caption><div class="big_font"><b>免费注册</b></div></caption>
<tr>
	<td width="95" >用户账号：</td><td width="426"><input type="text" name="uaccount" id="uaccount" onBlur="isUser()" class="uaccount"><span id="msg"></span></td>
</tr>
<tr>
	<td>用户密码：</td><td><input type="password" name="upass1" id="upass1" onBlur="isPass1()" class="uaccount"><span id="msg2"></span></td>
</tr>
<tr>
	<td>确认密码：</td><td><input type="password" name="upass2" id="upass2" onBlur="isPass2()" onChange="checkpwd()" class="uaccount" ><span id="msg3"></span></td>
</tr>
<tr>
	<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td><td><input type="radio" name="usex" value="0" checked="checked"/>男 <input type="radio" name="usex"  value="1"/>女</td>
</tr>
<tr>
	<td>电子邮箱：</td><td><input type="text" name="uemail" id="uemail" onBlur="isMail()" class="uaccount"><span id="msg4"></span></td>
</tr>
<tr>
	<td>电话号码：</td><td><input type="text" name="uphone" id="uphone" onBlur="isPhone()" class="uaccount"><span id="msg5"></span></td>
</tr>
 
       <tr> 
       <td></td><td><input type="checkbox" name="checked" id="checked"  onBlur=" isChecked()"/>&nbsp;&nbsp;<span class="check">同意并遵守</span>&nbsp;
       <span id="msg6"></span></td>
       </tr>
       <tr>
       		<td></td><td><p><a href="clause.jsp" target="_blank"><span class="agree">《中国原创音乐基地的服务条款》</span></a></p>
       		  <p>
       		  <input type="submit" name="sub" value="立即注册" class="li"/> 
   		      <input type="reset" value="重填" class="re">
   		      </p></td>
        </tr>
        <tr>
        	<td></td><td><a href="login.jsp"><span class="return">&lt;&lt; 返回登录页</span></a></td>
        </tr>
  

</table>
</form>
</div>
<div class="right"></div>
</div>
</body>
</html>
<c:if test="${param.msg!=null&&param.msg!='null'}">
<script >alert("${param.msg}")</script>
</c:if>