<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p class="menu_head">添加专辑页面（请选择歌手）</p>
<c:if test="${!empty arts}">
	<c:forEach items="${arts}" var="art" varStatus="a">
		<a href="managerIndex.jsp?page=addAlbum.jsp&uid=${art.uid}&uname=${art.uname}" >
			<div class="div_showArt">
				<img alt="${art.uname}" src="../userimages/${art.uimage }"><br/>
				${art.uname}
			</div>
		</a>
	</c:forEach>
</c:if>