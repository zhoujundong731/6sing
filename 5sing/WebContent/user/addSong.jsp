<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	//歌曲名认证
	function isSname() {
		var txt = document.getElementById("sname").value;
		if (txt.length == 0) {
			document.getElementById("msg").innerHTML = "请填写歌曲名！";
			return false;
		}
		if (txt.length > 8) {
			document.getElementById("msg").innerHTML = "歌曲名小于8位，重新输入！";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	//歌曲简介认证
	function isStext() {
		var txt = document.getElementById("stext").value;
		if (txt.length == 0) {
			document.getElementById("msg").innerHTML = "请填写歌曲简介！";
			return false;
		}
		if (txt.length < 10) {
			document.getElementById("msg").innerHTML = "歌曲简介大于10位，重新输入！";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	function isAll() {
		if (isSname() == false) {
			return false;
		} else if (isStext() == false) {
			return false;
		}
		return true;
	}
</script>

<div class="addSong">
	<p class="menu_head">${user.uname}&nbsp;&nbsp;&nbsp;歌曲添加页面</p>
	<form action="UserIndex?temp=3" method="post"
		enctype="multipart/form-data" onsubmit="return isAll()">
		<input type="hidden" name="uid" value="${user.uid}">
		<table width="601" align="center" cellpadding="0px" cellspacing="0px">
			<tr>
				<td width="149" class="tr_left">请输入歌曲姓名:</td>
				<td width="409"><input type="text" name="sname" id="sname"
					onblur="isSname()" value="" /></td>
			</tr>
			<tr>
				<td class="tr_left">请输入歌曲简介:</td>
				<td><textarea rows="3" cols="40" name="stext" id="stext"
						onblur="isStext()"></textarea></td>
			</tr>
			<tr>
				<td class="tr_left">上传MP3歌曲:</td>
				<td><input type="file" name="sm" value="" /></td>
			</tr>
			<tr>
				<td class="tr_left">上传高品质音乐:</td>
				<td><input type="file" name="sw" value="" /></td>
			</tr>
			<tr>
				<td class="tr_left">上传MV：</td>
				<td><input type="file" name="sv" value="" /></td>
			</tr>
			<tr>
				<td class="tr_left">请输入歌曲歌词:</td>
				<td><textarea rows="7" cols="40" name="slrc"></textarea></td>
			</tr>
			<tr>
				<td height="57" colspan="2"><span id="msg"></span><br> <input
					type="submit" value="添加" /> &nbsp&nbsp&nbsp<input type="reset"
					value="重置" /></td>
			</tr>
		</table>

	</form>
</div>