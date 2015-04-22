<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p class="menu_head">专辑详情页面(点击查看详情)</p>
<c:if test="${!empty albums}">
	<c:forEach items="${albums}" var="ab" varStatus="a">
		<a href="ManagerAlbum?temp=4&bid=${ab.bid}" >
			<div class="div_showArt">
				<img alt="${ab.bname}" src="../userimages/${ab.bimage}"><br/>
				${ab.bname}
				<div class="div_show_hidden">
					${ab.user.uname}
				</div>
			</div>
		</a>
	</c:forEach>
	
</c:if>