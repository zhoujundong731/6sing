<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p class="menu_head">添加歌曲页面(请选择歌手)</p>
<c:if test="${!empty arts}">
	<c:forEach items="${arts}" var="art" varStatus="a">
		<a href="ManagerSong?temp=2&uid=${art.uid}&uname=${art.uname}" >
			<div class="div_showArt">
				<img alt="${art.uname}" src="../userimages/${art.uimage }" width="90px" height="90px"><br/>
				${art.uname}
			</div>
		</a>
	</c:forEach>
</c:if>