<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <ul>
	<c:if test="${!empty menus }">
		<c:forEach var="mu" items="${menus}" varStatus="a">
			<li id="main_menu${a.index}" class="li_menu1"><a href="###" class="main_menu" onclick="cleck('main_menu${a.index}')">${mu.mname}</a><br/>
				<div class="menu_left" id="sunmenu">
		 		<ul>
		 			<c:if test="${mu.submenus!=null}">
						<c:forEach items="${mu.submenus}" var="sub" >
			 				 <c:if test="${sub.isdirect==0}">
								<li><a href="${sub.supath}">${sub.suname}</a></li>
							</c:if>
							<c:if test="${sub.isdirect==1}">
								<li><a href="managerIndex.jsp?page=${sub.supath }.jsp">${sub.suname}</a></li>
							</c:if>  
						</c:forEach>
					</c:if>
				</ul>
				</div>
			</li>
		</c:forEach>
	</c:if>
	<c:if test="${menus==null }">
	</c:if>
</ul> 