<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	//歌手名认证
	function isUname() {
		var txt = document.getElementById("uname").value;
		if (txt.length == 0) {
			document.getElementById("msg").innerHTML = "请填写歌手名！";
			return false;
		}
		if (txt.length > 6) {
			document.getElementById("msg").innerHTML = "歌手名小于6位，重新输入！";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	//歌手简介认证
	function isStext() {
		var txt = document.getElementById("stext").value;
		if (txt.length == 0) {
			document.getElementById("msg").innerHTML = "请填写歌手简介！";
			return false;
		}
		if (txt.length < 8) {
			document.getElementById("msg").innerHTML = "歌手简介大于8位，重新输入！";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	function isType() {
		var obj = document.getElementsByName("arttype");
		var count = obj.length;
		var j = 0;
		for ( var i = 0; i < count; i++) {
			if (obj[i].checked) {
				j++;
			}
		}
		if (j == 0) {
			document.getElementById("msg").innerHTML = "请至少选择一个歌手类型！";
			return false;
		} else {
			return true;
		}
	}
	function isAll() {
		if (isSname() == false) {
			return false;
		} else if (isStext() == false) {
			return false;
		} else if (isType() == false) {
			return false;
		}
		return true;
	}
</script>
<p class="menu_head">添加歌手</p>
<form action="UserServlet?temp=2" method="post"
	enctype="multipart/form-data" onsubmit="return isUname()">
	<table align="center" cellpadding="0px" cellspacing="0px">
		<tr>
			<td>请输入歌手姓名:</td>
			<td><input type="text" name="uname" id="uname"
				onblur="isUname()" value="" /></td>
		</tr>
		<tr>
			<td>请选择性别:</td>
			<td><input type="radio" name="usex" value="0" checked="checked" />男
				<input type="radio" name="usex" value="1" />女</td>
		</tr>
		<tr>
			<td>请选择歌手图片:</td>
			<td><input name="uimage" type="file" /></td>
		</tr>
		<tr>
			<td>请输入歌手简介:</td>
			<td><input name="utext" type="text" id="stext"
				onblur="isStext()" /></td>
		</tr>
		<tr>
			<td>请选择歌手类型:</td>
			<td><c:if test="${!empty arttypes }">
					<c:forEach items="${arttypes }" var="at">
						<input type="checkbox" name="arttype" value="${at.atid }" />${at.atid }${at.atname}
				</c:forEach>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="2"><span id="msg"></span><br> <input
				type="submit" value="添加" onclick="return isType()" /> &nbsp&nbsp&nbsp<input
				type="reset" value="重置" /></td>
		</tr>
	</table>