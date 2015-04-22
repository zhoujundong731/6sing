<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		} /* else if (isType() == false) {
			return false;
		} */
		return true;
	}
</script>
<p class="menu_head">修改歌手信息页面</p>
<form action="UserServlet?temp=6" method="post" enctype="multipart/form-data" onsubmit="return isAll()">
	<input type="hidden" name="uid" value="${user.uid}">
	<input type="hidden" name="uimageo" value="${user.uimage}">
	<table width="528" height="260" align="center" cellpadding="0px" cellspacing="0px">
	<tr>
		<td width="159">歌手姓名:</td>
		<td width="367"><input type="text" name="uname" id="uname" onblur="isUname()" value="${user.uname}"/></td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<c:if test="${user.usex==0}">
				<input type="radio" name="usex" value="0" checked="checked"/>男
				<input type="radio" name="usex" value="1"/>女
			</c:if>
			<c:if test="${user.usex==1}">
				<input type="radio" name="usex" value="0" />男
				<input type="radio" name="usex" value="1" checked="checked"/>女
			</c:if>
		</td>
	</tr>
	<tr>
		<td>图片:</td>
		<td><img alt="${user.uname}" src="../userimages/${user.uimage }" height="80px" width="80px"><input name="uimage" type="file" value="重新上传"/></td>
	</tr>
	<tr>
		<td>歌手简介:</td>
		<td><textarea rows="3" name="utext" id="utext" cols="">${user.usign}</textarea>
		</td>
	</tr>
	<tr>
		<td>原有歌手类型:</td>
		<td>
			<c:if test="${!empty user.arttypes}">
				<c:forEach items="${user.arttypes}" var="ato">
					${ato.atname}&nbsp;&nbsp;
				</c:forEach>
			</c:if>
			<c:if test="${empty user.arttypes}">
				无
			</c:if>
		</td>
        <tr>
        	<td>是否修改类型</td>
            <td>
            	<input type="radio" name="type" value="y" />是
				<input type="radio" name="type" value="n" checked="checked"/>否
            </td>
        </tr>
	</tr>
	<tr>
		<td>修改歌手类型:</td>
		<td>
			<c:if test="${!empty arttypes }">
				<c:forEach items="${arttypes }" var="at">
					<input type="checkbox" name="arttype"  value="${at.atid }"/>${at.atname}&nbsp;&nbsp;&nbsp;
				</c:forEach>
			</c:if>
			
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<span id="temp"></span>
		<input type="submit" value="修改"/>
		&nbsp&nbsp&nbsp<input type="reset" value="重置"/></td>
	</tr>
</table>
</form>