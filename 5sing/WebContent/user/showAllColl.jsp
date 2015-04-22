<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_head">${user.uname}&nbsp;&nbsp;收藏详情</p>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td>歌曲名</td>
		<td>简介</td>
		<td>点击量</td>
		<td>下载量</td>
		<td>收藏量</td>
		<td>收藏时间</td>
		<td>操作</td>
	</tr>
	<c:if test="${!empty colls }">
		<c:forEach items="${colls}" var="co" varStatus="a">
			<c:if test="${a.index%2==0}">
				<tr>
					<td>${co.song.sname}</td>
					<td><div class="span_text">${co.song.stext}</div></td>
					<td>${co.song.sclick}</td>
					<td>${co.song.sdown}</td>
					<td>${co.song.scnum}</td>
					<td>${co.cttime}</td>
					<td><a href="UserCollection?temp=2&ctid=${co.ctid}" onclick="Del()">取消收藏</a>&nbsp;&nbsp;&nbsp;<a href="../UserSong?temp=3&sid=${co.song.sid }">查看详情</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1 }">
				<tr class="tr_white">
					<td>${co.song.sname}</td>
					<td><div class="span_text">${co.song.stext}</div></td>
					<td>${co.song.sclick}</td>
					<td>${co.song.sdown}</td>
					<td>${co.song.scnum}</td>
					<td>${co.cttime}</td>
					<td><a href="UserCollection?temp=2&ctid=${co.ctid}" onclick="Del()">取消收藏</a>&nbsp;&nbsp;&nbsp;<a href="">查看详情</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
</table>