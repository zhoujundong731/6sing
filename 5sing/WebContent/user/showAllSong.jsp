<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p class="menu_head">${user.uname}&nbsp;&nbsp;歌曲详情</p>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td>歌曲名</td>
		<td>普通音乐</td>
		<td>高品质音乐</td>
		<td>MV</td>
		<td>简介</td>
		<td>点击量</td>
		<td>下载量</td>
		<td>收藏量</td>
		<td>操作</td>
	</tr>
	<c:if test="${!empty songs}">
		<c:forEach items="${songs}" var="song" varStatus="a">
			<c:if test="${a.index%2==0}">
				<tr class="tr_white">
					<td>${song.sname}</td>
					<td>
						<c:if test="${!empty song.smaddress}">有</c:if>
						<c:if test="${empty song.smaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.swaddress}">有</c:if>
						<c:if test="${empty song.swaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.svaddress}">有</c:if>
						<c:if test="${empty song.svaddress}">无</c:if>
					</td>
					<td><div class="span_text">${song.stext}</div></td>
					<td>${song.sclick }</td>
					<td>${song.sdown }</td>
					<td>${song.scnum }</td>
					<td><a href="UserIndex?temp=5&sid=${song.sid}">查看详情</a>
					&nbsp;&nbsp;&nbsp;<a href="../UserSong?temp=3&sid=${song.sid}">试听</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1}">
				<tr>
					<td>${song.sname}</td>
					<td>
						<c:if test="${!empty song.smaddress}">有</c:if>
						<c:if test="${empty song.smaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.swaddress}">有</c:if>
						<c:if test="${empty song.swaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.svaddress}">有</c:if>
						<c:if test="${empty song.svaddress}">无</c:if>
					</td>
					<td><div class="span_text">${song.stext}</div></td>
					<td>${song.sclick }</td>
					<td>${song.sdown }</td>
					<td>${song.scnum }</td>
					<td><a href="UserIndex?temp=5&sid=${song.sid}">查看详情</a>
					&nbsp;&nbsp;&nbsp;<a href="../UserSong?temp=3&sid=${song.sid}">试听</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
</table>