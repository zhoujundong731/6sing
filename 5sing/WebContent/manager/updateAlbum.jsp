<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<p class="menu_head">${album.bname}&nbsp;&nbsp;专辑修改页面</p>
<form action="ManagerAlbum?temp=7" method="post"enctype="multipart/form-data" onsubmit="return isAll()">
<input type="text" name="bid"  value="${album.bid}" hidden="true"/>
<input type="text" name="bimage"  value="${album.bimage}" hidden="true"/>
	<table align="center" cellpadding="0px" cellspacing="0px">
			<tr>
				<td>专辑名字:</td>
				<td><input type="text" name="bname" value="${album.bname }" id="bname"  onblur="isBname()"  /></td>
			</tr>
			<tr>
				<td>请输入专辑简介:</td>
				<td><textarea rows="4" cols="" name="btext" id="btext" onblur="isBtext()">${album.btext}</textarea></td>
			</tr>
			<tr>
				<td>图片:</td>
				
				<td><img alt="${album.bname}" src="../userimages/${album.bimage}" width="100px" height="100px">
				<input type="file" name="bimage2"/>重新上传</td>
			</tr>
			<tr>
				<td colspan="2">
				<span id="msg"></span><br>
				<input type="submit" value="修改" />
					&nbsp&nbsp&nbsp<input type="reset" value="重置" /></td>
			</tr>
	</table>
</form>