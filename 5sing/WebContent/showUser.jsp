<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐人详情</title>
<link href="style/showArt.css" type="text/css" rel="stylesheet">
<link href="style/managerIndex.css" type="text/css" rel="stylesheet">
<link href="style/showUser.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="show_main">
<p class="menu_head">音乐人详情</p>
<div class="show_top">
	<div class="show_top_left"><img alt="${oneUser.uname}" src="userimages/${oneUser.uimage }"></div>
    <div class="show_top_min">
    	姓名：${oneUser.uname }<br><br>
    	简介:${oneUser.usign}
    
    </div>
</div>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td>歌曲名</td>
		<td>简介</td>
		<td>下载量</td>
		<td>点击量</td>
		<td>收藏量</td>
		<td>操作</td>
	</tr>
	<c:if test="${!empty oneUser.songs }">
		<c:forEach items="${oneUser.songs }" var="song" varStatus="a">
			<c:if test="${a.index%2==0 }">
				<tr class="tr_white">
				<td>${song.sname }</td>
				<td><div class="span_text">${song.stext}</div></td>
				<td>${song.sdown }</td>
				<td>${song.sclick }</td>
				<td>${song.scnum }</td>
				<td><a href="UserSong?temp=3&sid=${song.sid}">试听</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1 }">
				<tr class="tr_2">
				<td>${song.sname }</td>
				<td><div class="span_text">${song.stext}</div></td>
				<td>${song.sdown }</td>
				<td>${song.sclick }</td>
				<td>${song.scnum }</td>
				<td><a href="UserSong?temp=3&sid=${song.sid}">试听</a></td>
				</tr>
			</c:if>
		
		</c:forEach>
	</c:if>
</table>
</div>
</body>
</html>