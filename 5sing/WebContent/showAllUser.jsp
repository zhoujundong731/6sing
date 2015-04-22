<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐人信息显示</title>
<link href="style/showArt.css" type="text/css" rel="stylesheet">
<link href="style/managerIndex.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="showUser">
<p class="menu_head">音乐人信息显示</p>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td>姓名</td>
		<td>性别</td>
		<td>头像</td>
		<td>简介/个性签名</td>
		<td>操作</td>
	</tr>
	<c:if test="${!empty users}">
		<c:forEach items="${users}" var="user" varStatus="a">
			<c:if test="${a.index%2==0}">
				<tr class="tr_white">
					<td><c:if test="${empty user.uname}">暂无信息</c:if>${user.uname}</td>
					<td><c:if test="${user.usex==0}">男</c:if> <c:if
							test="${user.usex==1}">女</c:if></td>
					<td><c:if test="${empty user.uimage}">暂无信息</c:if> <c:if
							test="${!empty user.uimage}">
							<img alt="${user.uname}" src="userimages/${user.uimage }"
								height="30px" width="30px">
						</c:if></td>
					<td><c:if test="${empty user.usign}">暂无信息</c:if>
						<div class="span_text">${user.usign }</div></td>
					<td><a href="UserSong?temp=2&uid=${user.uid }">查看音乐人详情</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1}">
				<tr class="tr_2">
					<td><c:if test="${empty user.uname}">暂无信息</c:if>${user.uname}</td>
					<td><c:if test="${user.usex==0}">男</c:if> <c:if
							test="${user.usex==1}">女</c:if></td>
					<td><c:if test="${empty user.uimage}">暂无信息</c:if> <c:if
							test="${!empty user.uimage}">
							<img alt="${user.uname}" src="userimages/${user.uimage }"
								height="30px" width="30px">
						</c:if></td>
					<td><c:if test="${empty user.usign}">暂无信息</c:if>
						<div class="span_text">${user.usign }</div></td>
					<td><a href="UserSong?temp=2&uid=${user.uid }">查看音乐人详情</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
	<tr>
		<td colspan="5">
			<div class="sub">
				<div class="sub1">
					<a href="UserSong?temp=10&cp=1">首页</a>
				</div>
				<c:forEach begin="1" end="${subpage.totalPage}" var="i">
					<div class="sub1">
						<a href="UserSong?temp=10&cp=${i}">${i }</a>
					</div>
				</c:forEach>
				<div class="sub1">
					<a href="UserSong?temp=10&cp=${subpage.totalPage }">尾页</a>
				</div>
				<div class="sub2">当前第${subpage.currentPage }页/共${subpage.totalPage}页</div>
			</div>
		</td>
	</tr>
</table>
</div>
</body>
</html>