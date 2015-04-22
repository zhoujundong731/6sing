<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_head">歌曲类型信息显示</p>
<table width="423" height="85" align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td width="96">歌曲类型编号</td>
		<td width="79">歌曲类型</td>
		<td width="148">操作</td>
	</tr>
	<c:if test="${!empty songtypes}">
		<c:forEach items="${songtypes}" var="st" varStatus="a">
			<c:if test="${a.index%2==0}">
				<tr class="tr_white">
					<td>${st.stid}</td>
					<td>${st.stname}</td>
					<td><a
						href="managerIndex.jsp?page=updateSongtype.jsp&stid=${st.stid}&stname=${st.stname}">修改</a>&nbsp;
						&nbsp;&nbsp;<a href="SongTypeServlet?temp=3&stid=${st.stid}" onclick="Del()">删除</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1}">
				<tr class="tr_2">
					<td>${st.stid}</td>
					<td>${st.stname}</td>
					<td><a
						href="managerIndex.jsp?page=updateSongtype.jsp&stid=${st.stid}&stname=${st.stname}">修改</a>&nbsp;
						&nbsp;&nbsp;<a href="SongTypeServlet?temp=3&stid=${st.stid}" onclick="Del()">删除</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
</table>