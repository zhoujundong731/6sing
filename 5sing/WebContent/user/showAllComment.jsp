<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty comments}">
	<p class="menu_head">暂无歌曲评论</p>
</c:if>
<c:if test="${!empty comments}">
	<p class="menu_head">${user.uname}&nbsp;&nbsp;音乐评论</p>
	<div>
		<div>
			<div class="left com1">歌曲名</div>
			<div class="left com2">评论内容</div>
		</div>
		<c:forEach items="${comments}" var="com">
			<div>
				<div class="left com3"><a href="../UserSong?temp=3&sid=${com.song.sid}">${ com.song.sname}</a></div>
				<div class="left com4">${ com.ctext}</div>
			</div>
		</c:forEach>


	</div>
</c:if>