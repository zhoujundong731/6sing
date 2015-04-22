<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="userInfo">
<p class="menu_head">个人信息详情</p>
<p><span><a href="userIndex.jsp?page=updateUserInfo.jsp">个人信息修改</a></span>
</p>
<table width="518" height="296" align="center" cellpadding="2px" cellspacing="0px">
  <tr>
		<td width="128" align="center" class="tr_left">用户账号</td>
		<td width="337" class="tr_right">${user.uaccount}</td>
	</tr>
	<tr>
		<td height="116" align="center" class="tr_left">头像</td>
		<td class="tr_right">
		<c:if test="${empty user.uimage}">暂无信息</c:if>
		<c:if test="${!empty user.uimage}">
			<img alt="${user.uname}" src="../userimages/${user.uimage}"/>
		</c:if>
		</td>
	</tr>
	<tr>
		<td align="center" class="tr_left">用户姓名</td>
	  <td class="tr_right"><c:if test="${empty user.uname}">暂无信息</c:if>${user.uname}</td>
	</tr>
	<tr>
		<td align="center" class="tr_left">个性签名</td>
	  <td class="tr_right"><c:if test="${empty user.usign}">暂无信息</c:if>${user.usign}</td>
	</tr>
	<tr>
		<td align="center" class="tr_left">性别</td>
	  <td class="tr_right"><c:if test="${user.usex==0 }">男</c:if> <c:if
				test="${user.usex==1 }">女</c:if></td>
	</tr>
	<tr>
		<td align="center" class="tr_left">邮箱</td>
	  <td class="tr_right"><c:if test="${empty user.uemail}">暂无信息</c:if> ${user.uemail}</td>
	</tr>
	<tr>
		<td align="center" class="tr_left">电话</td>
	  <td class="tr_right"><c:if test="${empty user.uphone}">暂无信息</c:if>${user.uphone}</td>
	</tr>
	<tr>
		<td height="23" align="center" class="tr_left">地址</td>
	  <td class="tr_right"><c:if test="${empty user.uaddress}">暂无信息</c:if>${user.uaddress}</td>
	</tr>
</table>
</div>