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
	function isType() {
		var obj = document.getElementsByName("songtypes");
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
		}else if (isType() == false) {
			return false;
		}
		return true;
	}
</script>

<p class="menu_head">${uname}&nbsp;&nbsp;&nbsp;歌曲添加页面</p>
<form action="ManagerSong?temp=3" method="post"
	enctype="multipart/form-data" onsubmit="return isAll()">
	<input type="hidden" name="uid" value="${uid}">
	<c:if test="${empty albums}">
		<div class="div_head">暂无专辑信息</div>
	</c:if>
	<c:if test="${!empty albums}">
		<c:forEach items="${albums}" var="album">
			<div class="div_showArt">
			
			<img alt="${album.bname }" src="../userimages/${album.bimage }"
				width="90px" height="100px">
				${album.bname }<input type="radio" name="bid" value="${ album.bid}">
			</div>
		</c:forEach>
	</c:if>
	<br>
	<table width="557" height="270" align="center" cellpadding="0px" cellspacing="0px">
		<tr>
			<td width="171">请输入歌曲姓名:</td>
			<td width="384"><input type="text" name="sname" value="" id="sname"
					onblur="isSname()" /></td>
		</tr>
		<tr>
			<td>请输入歌曲简介:</td>
			<td><textarea rows="3" cols="40" name="stext" id="stext"
						onblur="isStext()"></textarea></td>
		</tr>
		<tr>
			<td>上传MP3歌曲:</td>
			<td><input type="file" name="sm" value="" /></td>
		</tr>
		<tr>
			<td>上传高品质音乐:</td>
			<td><input type="file" name="sw" value="" /></td>
		</tr>
		<tr>
			<td>上传MV：</td>
			<td><input type="file" name="sv" value="" /></td>
		</tr>
		<tr>
			<td>请输入歌曲歌词:</td>
			<td><textarea rows="7" cols="40" name="slrc"></textarea></td>
		</tr>
		<tr>
			<td>请选择歌曲类型:</td>
			<td><c:if test="${!empty songtypes }">
					<c:forEach items="${songtypes }" var="st">
						<input type="checkbox" name="songtypes" value="${st.stid }" />${st.stname}
						</c:forEach>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="2">
				<span id="msg"></span>
			<input type="submit" value="添加" />
				&nbsp&nbsp&nbsp<input type="reset" value="重置" /></td>
		</tr>
	</table>

</form>