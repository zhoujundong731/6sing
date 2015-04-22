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
<p class="menu_head">${song.sname}&nbsp;&nbsp;&nbsp;歌曲信息修改页面</p>
<div class="div_head">歌手：${user.uname}</div>
<form action="UserIndex?temp=8" method="post" enctype="multipart/form-data" onsubmit="return isAll()">
<input type="hidden" name="sid" value="${song.sid}"/>
		<table width="834" align="center" cellpadding="0px" cellspacing="0px">
			<tr>
				<td width="145">歌曲名字:</td>
				<td width="687"><input type="text" name="sname" id="sname" onblur="isSname()" value="${song.sname}" /></td>
			</tr>
			<tr>
				<td>歌曲简介:</td>
				<td><textarea rows="" cols="" name="stext" id="stext" onblur="isStext()">${song.stext}</textarea></td>
			</tr>
			<tr>
				<td>MP3地址:</td>
				<td>
					<input type="text" name="d1" value="${song.smaddress}" hidden="true"/>
					<c:if test="${empty song.smaddress}">暂无信息
					</c:if>${song.smaddress}
					<input type="file" name="sm" value=""/>重新上传
				</td>
			</tr>
			<tr>
				<td>高品质音乐地址:</td>
				<td>
					<input type="text" name="d2" value="${song.swaddress}" hidden="true"/>
					<c:if test="${empty song.swaddress}">暂无信息
					</c:if>${song.swaddress}
					<input type="file" name="sw" value="ddd"/>重新上传
				</td>
			</tr>
			<tr>
				<td>MV地址：</td>
				<td>
					<input type="text" name="d3" value="${song.svaddress}" hidden="true"/>
					<c:if test="${empty song.svaddress}">暂无信息
					</c:if>${song.svaddress}
					<input type="file" name="sv" value=""/>重新上传
				</td>
			</tr>
			<tr>
				<td>歌曲歌词:</td>
				<td><textarea rows="7" cols="40" name="slrc" readonly="readonly">${song.slrc}</textarea></td>
			</tr>
			<tr>
				<td>重新上传歌曲歌词:</td>
				<td><textarea rows="7" cols="40" name="slrc2"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<span id="msg"></span>
				<input type="submit" value="修改" />
					&nbsp&nbsp&nbsp<input type="reset" value="重置" /></td>
			</tr>
    </table>

	</form>