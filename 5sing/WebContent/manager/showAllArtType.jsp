<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p class="menu_head">歌手类型信息显示</p>
<table width="510" height="87" align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td width="134">歌手类型编号</td>
		<td width="175">歌手类型</td>
		<td width="187">操作</td>
	</tr>
	<c:if test="${!empty arttypes}">
		<c:forEach items="${arttypes}" var="at" varStatus="a">
			 <c:if test="${a.index%2==0}">
				<tr class="tr_white">
					<td>${at.atid}</td>
					<td>${at.atname}</td>
					<td><a
						href="managerIndex.jsp?page=updateArtType.jsp&atid=${at.atid}&atname=${at.atname}">修改</a>
						&nbsp;&nbsp;&nbsp;<a href="ArtTypeServlet?temp=3&atid=${at.atid}" onclick="Del()">删除</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1}">
				<tr class="tr_2">
					<td>${at.atid}</td>
					<td>${at.atname}</td>
					<td><a
						href="managerIndex.jsp?page=updateArtType.jsp&atid=${at.atid}&atname=${at.atname}">修改</a>
						&nbsp;&nbsp;&nbsp;<a href="ArtTypeServlet?temp=3&atid=${at.atid}" onclick="Del()">删除</a></td>
				</tr>
			</c:if> 
		</c:forEach>
	</c:if>
</table>