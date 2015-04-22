<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String uname=new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");%>
<script>
    //专辑名认证
 	function isBname(){
 	 		var txt= document.getElementById("bname").value;
 	 		if(txt.length==0){
 	 			document.getElementById("msg").innerHTML="请填写专辑名！";
 	 			return false;
 	 		}
 	 		if(txt.length > 6){
 				document.getElementById("msg").innerHTML="专辑名小于6位，重新输入！";
 				return false;	
 		}else{
 			document.getElementById("msg").innerHTML="";
 			return true;
 		}	
 	}
	//专辑简介认证
	function isBtext(){
	 		var txt= document.getElementById("btext").value;
	 		if(txt.length==0){
	 			document.getElementById("msg").innerHTML="请填写专辑简介！";
	 			return false;
	 		}
	 		if(txt.length < 10){
				document.getElementById("msg").innerHTML="专辑简介大于10位，重新输入！";
				return false;	
		}else{
			document.getElementById("msg").innerHTML="";
			return true;
		}	
	}
	function isAll() {
		if (isBname() == false) {
			return false;
		} else if (isBtext() == false) {
			return false;
		}
		return true;
	}
	</script>

<p class="menu_head"><%=uname %>专辑添加页面</p>
<form action="ManagerAlbum?temp=2" method="post"enctype="multipart/form-data" onsubmit="return isAll()">
<input type="hidden" name="uid"  value="${param.uid}"/>
	<table align="center" cellpadding="0px" cellspacing="0px">
			<tr>
				<td>请输入专辑名字:</td>
				<td><input type="text" id="bname" onblur="isBname()" name="bname" value="" /></td>
			</tr>
			<tr>
				<td>请输入专辑简介:</td>
				<td><textarea rows="4" id="btext" onblur="isBtext()" cols="" name="btext"></textarea></td>
			</tr>
			<tr>
				<td>请上传专辑图片:</td>
				<td><input type="file" name="bimage"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<span id="msg"></span><br>
				<input type="submit" value="添加" />
					&nbsp&nbsp&nbsp<input type="reset" value="重置" /></td>
			</tr>
	</table>
</form>