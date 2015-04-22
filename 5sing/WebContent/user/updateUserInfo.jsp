<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script>
//用户验证
 	function isUname(){
 		var user = document.getElementById("uname").value;
 		if(user.length==0){
 			document.getElementById("msg").innerHTML="请填写用户名！";
 			return false;
 		}
 		if(user.length > 8){
			document.getElementById("msg").innerHTML="用户位数小于8位，重新输入！";
			return false;	
	}else{
		document.getElementById("msg").innerHTML="";
		return true;
	}	
}
//个性签名认证
function isUsign(){
 		var usign = document.getElementById("usign").value;
 		if(usign.length==0){
 			document.getElementById("msg").innerHTML="请填写个性签名！";
 			return false;
 		}
 		if(usign.length < 8){
			document.getElementById("msg").innerHTML="个性签名大于8位，重新输入！";
			return false;	
	}else{
		document.getElementById("msg").innerHTML="";
		return true;
	}	
}
//邮箱验证
function isUemail(){
	var va=document.getElementById("uemail").value;
	var mail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
		if(!mail.test(va)){
		document.getElementById("msg").innerHTML="你的输入不正确，请输入正确邮箱！";
		return false;
		}	
		if(va==""){
			document.getElementById("msg").innerHTML="请输入邮箱号！";
			return false;
			}else{
	    	  <!-- document.getElementById("msg4").value="";-->
			   document.getElementById("msg").innerHTML="";
					return true;
		}
	}	
//电话验证
function isUphone(){
	var vaphone=document.getElementById("uphone").value;
	var  phone= /^(((13[0-9]{1})|134|135|136|137|138|139|150|151|152|157|158|159|183|153|187|188|130|131|132|155|156|185|186|)+\d{8})$/; 
	if(vaphone.length==0){
		document.getElementById("msg").innerHTML="请输入手机号!";
		return false;
		}
	if(vaphone.length!==11){
		document.getElementById("msg").innerHTML="输入的手机位数不够！";
		return false;
		}
    if(!phone.test(vaphone)){
		document.getElementById("msg").innerHTML="输入有效手机号！";
		return false;		
	}else{
		document.getElementById("msg").innerHTML="";
		return true;
	}	
	}
function isAll(){
	if(isUname()==false){
		return false;
	}else if(isUsign()==false){
		return false;
	}else if(isUemail()==false){
		return false;
	}else if(isUphone()==false){
		return false;
	}
	return true;
}
</script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="updateUser">
<p class="menu_head">个人信息修改</p>
<form action="UserIndex?temp=2" method="post" enctype="multipart/form-data" onsubmit="return isAll()">
	<table width="606" align="center" cellpadding="2px" cellspacing="0px">
	<input type="hidden" name="uid" value="${user.uid}"/>
	<input type="hidden" name="uimage" value="${user.uimage}"/>
	<tr>
		<td width="124" class="tr_left">用户账号</td>
		<td width="472">${user.uaccount}</td>
	</tr>
	<tr>
		<td class="tr_left">头像</td>
		<td>
		<c:if test="${empty user.uimage}">暂无信息
		</c:if>
		<c:if test="${!empty user.uimage}">
			<img alt="${user.uname}" src="../userimages/${user.uimage}" width="100px" height="100px"/>
		</c:if>
		</td>
	</tr>
	<tr>
		<td>
		</td>
		<td>
			<input type="file" name="uimage"/>重新上传图片
		</td>
	</tr>
	<tr>
		<td class="tr_left">用户姓名</td>
		<td><input type="text" name="uname" id="uname" onBlur="isUname()" value="${user.uname}"/></td>
	</tr>
	<tr>
		<td class="tr_left">个性签名</td>
		<td><textarea rows="3" cols="" name="usign" id="usign" onblur="isUsign()">${user.usign}</textarea></td>
	</tr>
	<tr>
		<td class="tr_left">性别</td>
		<td><c:if test="${user.usex==0 }">
				<input type="radio" name="usex" value="0" checked="checked">男
				<input type="radio" name="usex" value="1" >女
			</c:if> 
			<c:if test="${user.usex==1 }">
				<input type="radio" name="usex" value="0" >男
				<input type="radio" name="usex" value="1" checked="checked" >女
			</c:if></td>
	</tr>
	<tr>
		<td class="tr_left">邮箱</td>
		<td><input type="text" name="uemail"  id="uemail"  onblur="isUemail()" value="${user.uemail}"/></td>
	</tr>
	<tr>
		<td class="tr_left">电话</td>
		<td><input type="text" name="uphone" id="uphone" onblur="isUphone()" value="${user.uphone}"/></td>
	</tr>
	<tr>
		<td class="tr_left">地址</td>
		<td><input type="text" name="uaddress" value="${user.uaddress}"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<span id="msg"></span><br>
			<input type="submit" value="修改信息">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置">
		</td>
	</tr>
</table>
</form>
</div>